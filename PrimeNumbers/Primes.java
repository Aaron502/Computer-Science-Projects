
/*
Generates and prints all prime numbers up to the specified value.

@author Aaron Wheeler
 */

public class Primes
{
    private long maxPrime;

    public Primes(long maxPrime) {
        this.maxPrime = maxPrime;
    }

    public Long[] calculatePrimes() {
        Long[] primes = new Long[(int) maxPrime];
        boolean prime = true;
        long current = maxPrime;
        long count = maxPrime;
        int numPrimes = 0;
        
        while (count > 0){
            prime = true;
            if (current == 1)
                prime = false;
            else {
                for (long i = current/2 + 1; i > 1; i--){
                    if (current % i == 0)
                        prime = false;
                }
            }
            
            if (prime){
                primes[numPrimes] = current;
                numPrimes++;
            }
            current--;
            count--;
        }
        Long[] primesList = new Long[numPrimes];
        for (int i = 0; i < numPrimes; i++){
            primesList[i] = primes[numPrimes - 1 - i];
        }
        return primesList;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Primes maxPrime\nwhere maxPrime is the largest possible prime number");
            System.exit(1);
        }
        Primes primesCalculator = new Primes(Long.valueOf(args[0]));
        Long[] primes = primesCalculator.calculatePrimes();

        for (long prime : primes) {
            System.out.format("%d ", prime);
        }
    }
}
