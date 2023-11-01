/**
 * BinaryConversion - convert a number between decimal and binary.
 * 
 * @author Emmett
 * @version 1.0
 */
public class BinaryConversion
{
    private String num; //The numeric value
    private int base; //The base of the numeric value (10, 2, or 16)
    /**
     * Constructor for objects of class BinaryDemo
     * 
     * @precondition – n is a non-negative integer in base 10
     */
    public BinaryConversion(int n)
    {
        num = n + "";
        base = 10;
    }

    /**
     * Convert to base 2
     * 
     * @precondition - the number is in base 10
     * @postcondition - update the base to 2
     * @return - true if the precondition is met, false otherwise
     */
    public boolean toBase2()
    {
        if(base == 2)
            return false;
        if(base == 16)
            num = to10From16(num, num.length(), 0) + "";
        if(num.equals("0"))
        {
            base = 2;
            return true;
        }
        int n = Integer.parseInt(num);
        num = toBase2(n);
        base = 2;
        return true;
    }

    private static String toBase2(int n)
    {
        if(n == 0)
            return "";
        if(n%2==1)
        {
            return toBase2(n/2) + "1";
        }
        return toBase2(n/2) + "0";
    }

    /**
     * Convert to base 10
     * 
     * @precondition - the number is in base 2
     * @postcondition - update the base to 10      
     * @return - true if the precondition is met, false otherwise
     */
    public boolean toBase10()
    {
        if(this.base ==10)
            return false;
        if (base ==16)
        {
            num = to10From16(num, num.length(), 0) + "";
            base = 10;
            return true;
        }
        if(num.equals(0))
        {
            base = 10;
            return true;
        }
        num = toBase10(num, num.length(), 0) + "";
        base = 10;
        return true;
    }

    private static int toBase10(String num, int length, int i)
    {
        if (i>= length)
            return 0;
        if(num.substring(i, i+1).equals("1"))
            return (int)Math.pow(2, num.length()-1-i) + toBase10(num, num.length(), i+1);
        return 0 + toBase10(num, num.length(), i+1);
    }

    public String toString()
    {
        return num + " in base " + base;
    }

    /**
     * COMPLETE PART 1 AND PASS BINARY-ONLY UNIT TEST
     *    BEFORE MOVING ON TO PART 2
     * 
     * Part 2:  Convert to base 16 (hexadecimal)
     * 
     * @precondition - the number is not in base 16
     * @postcondition - update the base to 16 and num to hexadecimal      
     * @return - true if the precondition is met, false otherwise
     * 
     * Note:  you will need to modify methods toBase10 and toBase2
     *        in case the number was originally in base 16
     *        For this reason, you may want to save two different 
     *        versions of this project: part1 and part 2
     */
    public boolean toBase16()
    {
        if (base == 16)
            return false;
        if(num.equals(0))
        {
            base = 16;
            return true;
        }
        if(base == 2)
            num = toBase10(num, num.length(), 0) + "";
        int n = Integer.parseInt(num);
        num = toHex(n);
        base = 16;
        return true;
    }

    private static String toHex(int num)
    {
        int remainder = num%16;
        String output = "";
        if(num < 10)
            output =  num + "";
        if(remainder==0)
            output = "0";
        else if(remainder < 10)
            output = remainder + "";
        else if(remainder == 10)
            output = "A";
        else if (remainder == 11)
            output = "B";
        else if (remainder == 12)
            output = "C";
        else if (remainder == 13)
            output = "D";
        else if (remainder == 14)
            output = "E";
        else if (remainder == 15)
            output = "F";
        if(num < 16)
            return output;
        return toHex(num/16) + output;
    }

    private static int to10From16(String num, int length, int i)
    {
        if (i>= length)
            return 0;
        if(num.substring(i, i+1).equals("0"))
            return 0  + to10From16(num, num.length(), i+1);
        if(num.substring(i, i+1).equals("1"))
            return (int)Math.pow(16, num.length()-1-i) + to10From16(num, num.length(), i+1);
        if(num.substring(i, i+1).equals("2"))
            return (int)Math.pow(16, num.length()-1-i) * 2 + to10From16(num, num.length(), i+1);
        if(num.substring(i, i+1).equals("3"))
            return (int)Math.pow(16, num.length()-1-i) * 3 + to10From16(num, num.length(), i+1);
        if(num.substring(i, i+1).equals("4"))
            return (int)Math.pow(16, num.length()-1-i) * 4 + to10From16(num, num.length(), i+1);
        if(num.substring(i, i+1).equals("5"))
            return (int)Math.pow(16, num.length()-1-i) * 5 + to10From16(num, num.length(), i+1);
        if(num.substring(i, i+1).equals("6"))
            return (int)Math.pow(16, num.length()-1-i) * 6 + to10From16(num, num.length(), i+1);
        if(num.substring(i, i+1).equals("7"))
            return (int)Math.pow(16, num.length()-1-i) * 7 + to10From16(num, num.length(), i+1);
        if(num.substring(i, i+1).equals("8"))
            return (int)Math.pow(16, num.length()-1-i) * 8 + to10From16(num, num.length(), i+1);
        if(num.substring(i, i+1).equals("9"))
            return (int)Math.pow(16, num.length()-1-i) * 9 + to10From16(num, num.length(), i+1);
        if(num.substring(i, i+1).equals("A"))
            return (int)Math.pow(16, num.length()-1-i) * 10 + to10From16(num, num.length(), i+1);
        if(num.substring(i, i+1).equals("B"))
            return (int)Math.pow(16, num.length()-1-i) * 11 + to10From16(num, num.length(), i+1);
        if(num.substring(i, i+1).equals("C"))
            return (int)Math.pow(16, num.length()-1-i) * 12 + to10From16(num, num.length(), i+1);
        if(num.substring(i, i+1).equals("D"))
            return (int)Math.pow(16, num.length()-1-i) * 13 + to10From16(num, num.length(), i+1);
        if(num.substring(i, i+1).equals("E"))
            return (int)Math.pow(16, num.length()-1-i) * 14 + to10From16(num, num.length(), i+1);
        return (int)Math.pow(16, num.length()-1-i) * 15 + to10From16(num, num.length(), i+1);
    }
}
