//Name: Aaron Wheeler
//Period: 1A

import java.util.*;

public class Lab26
{
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        //1
        System.out.println(letterGrade(95));
        //2
        squareBoard(8);
        //3
        checkerBoard(8);
        //4
        printPow2(4);
        //5
        System.out.println(Arrays.toString(quad(1, 12, 7)));
        //6
        System.out.println(convertTemp(75, false));
        //7
        int[] numbers = {1, 12, 7};
        System.out.println(simpleSearch(numbers, 3));
        //8
        printReverse(123456);
        //9
        System.out.println(isArmstrong(15));
        //10
        int[] firstArray = {1, 2, 3};
        int[] secondArray = {1, 2};
        System.out.println(contains(firstArray, secondArray));
        //Birthday Calculator
        System.out.print("Enter the day of the month >>> ");
        int day = kb.nextInt();
        kb.nextLine();
        System.out.print("Enter the month of the year (as a number) >>> ");
        int month = kb.nextInt();
        kb.nextLine();
        System.out.print("Enter the year >>> ");
        int year = kb.nextInt();
        kb.nextLine();
        System.out.println(daysToBDay(day, month, year));
        //Pascal's Triangle
        pascalsTriangle(7);
    }
    //1
    public static String letterGrade(double grade)
    {
        String asLetter = "";
        if (grade < 70)
            asLetter = "F";
        else if (grade >= 70 && grade < 80)
            asLetter = "C";
        else if (grade >= 80 && grade < 90)
            asLetter = "B";
        else if (grade >= 90)
            asLetter = "A";
        return asLetter;
    }
    //2
    public static void squareBoard(int n)
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                System.out.print("# ");
            }
            System.out.println();
        }
    }
    //3
    public static void checkerBoard(int n)
    {
        for (int i = 0; i < n; i++)
        {
            if (i % 2 == 0)
                System.out.print(" ");
            for (int j = 0; j < n; j++)
            {
                System.out.print("# ");
            }
            System.out.println();
        }
    }
    //4
    public static void printPow2(int n)
    {
        for (int i = 0; i < n; i++)
        {
            System.out.println("2^" + i + " = " + (int) Math.pow(2, i));
        }
    }
    //5
    public static double[] quad(double a, double b, double c)
    {
        double[] roots = new double[2];
        roots[0] = (Math.sqrt(b*b - (4*a*c))-b)/(2*a);
        roots[1] = (0-Math.sqrt(b*b - (4*a*c))-b)/(2*a);
        return roots;
    }
    //6
    public static double convertTemp(double temp, boolean isF)
    {
        double converted = 0;
        if (isF)
            converted = (temp - 32)/(1.8);
        else
            converted = temp * 1.8 + 32;
        return converted;
    }
    //7
    public static int simpleSearch(int[] nums, int value)
    {
        int indexAt = -1;
        int count = 0;
        boolean found = false;
        while (count < nums.length && !found)
        {
            if (value == nums[count])
            {
                indexAt = count;
                found = true;
            }
            count++;
        }
        return indexAt;
    }
    //8
    public static void printReverse(int num)
    {
        int reversed = 0;
        while (num != 0)
        {
            reversed *= 10;
            reversed += num % 10;
            num = num / 10;
        }
        System.out.println(reversed);
    }
    //9
    public static boolean isArmstrong(int num)
    {
        boolean isArmstrong = false;
        int[] digits = new int[numLength(num)];
        for (int i = 0; i < digits.length; i++)
        {
            digits[i] = singleDigit(num, i);
        }
        int sumPowers = 0;
        for (int i = 0; i < digits.length; i++)
        {
            sumPowers += Math.pow(digits[i], 3);
        }
        if (sumPowers == num)
            isArmstrong = true;
        return isArmstrong;
    }

    public static int singleDigit(int num, int place)
    {
        int lastDigits = (int) (num % Math.pow(10, place + 1));
        int extraDigits = (int) (num % Math.pow(10, place));
        int adjust = (int) Math.pow(10, place);
        int singleDigit = (int) ((lastDigits - extraDigits)/adjust);
        return singleDigit;
    }

    public static int numLength(int num)
    {
        int count = 0;
        boolean finished = false;
        int numDigits = 0;
        while (!finished)
        {
            if (num % (Math.pow(10, count)) == num)
            {
                numDigits = count;
                finished = true;
            }
            count++;
        }
        return numDigits;
    }
    //10
    public static boolean contains(int[] a, int[] b)
    {
        int i = 0;
        boolean found = false;
        while (i < a.length - b.length + 1 && !found)
        {
            boolean check = true;
            int j = 0;
            while (check && j < b.length)
            {
                if (b[j] != a[i + j])
                    check = false;
                j++;
            }
            i++;
            if (check)
                found = true;
        }
        return found;
    }
    //Birthday calculator
    public static int daysToBDay(int day, int month, int year)
    {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter your birthday month >>> ");
        int userMonth = kb.nextInt();
        kb.nextLine();
        System.out.print("Enter your birthday day >>> ");
        int userDay = kb.nextInt();
        kb.nextLine();
        int numDays = 0;
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        while (month != userMonth)
        {
            numDays += daysInMonth[month - 1];
            month++;
            if (month == 13)
                month = 1;
        }
        while (day > userDay)
        {
            day--;
            numDays--;
        }
        while (day < userDay)
        {
            day++;
            numDays++;
        }
        return numDays;
    }
    //(Advanced Pascal's triangle
    public static void pascalsTriangle(int n)
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j <= i; j++)
            {
                System.out.print(factorial(i)/(factorial(j)*factorial(i - j)) + " ");
            }
            System.out.println();
        }
    }
    
    public static int factorial(int n)
    {
        int factorial = 1;
        for (int i = 1; i <= n; i++)
        {
            factorial *= i;
        }
        return factorial;
    }
}