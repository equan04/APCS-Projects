
/**
 * class Tenths is a lab using arrays filled with doubles rounded to 10th place.
 * 
 * @author Emmett Q
 * @version 12/9/21
 */
public class Tenths
{
    double[] nums;

    public Tenths(int n)
    {
        nums = new double[n];
        for(int i = 0; i < nums.length; i++) //filling each element
            nums[i] = Math.round((Math.random()*9999 + 1)*10)/10.0;
    }

    public int find(double target)
    {
        for(int i = 0; i < nums.length; i++) //testing to see if each element = target
        {
            if(nums[i] == target)
                return i;
        }
        return -1;
    }

    public Tenths(double[] input)
    {
        nums = new double[input.length];
        for(int i = 0; i < input.length; i++) //filling each element w/ input
            nums[i] = input[i];
    }

    public boolean contains(double object)
    {
        for(int i = 0; i < nums.length; i++) //testing if each element in array = object
        {
            if(nums[i] == object)
                return true;
        }
        return false;
    }

    public double average()
    {
        double sum = 0;
        for(double element : nums) //don't need index; adding all elements together
            sum+=element;
        return Math.round((sum / nums.length)*10)/10.0;
    }

    public void replace(int index, double replace)
    {
        nums[index] = replace; //changing indicated element to inputted double
    }

    public int replace(double initial, double replace)
    {
        int counter = 0;
        for(int i = 0; i < nums.length; i++) //checking to see if each element = initial
        {
            if(nums[i] == initial) //replacing initial with replace
            {
                nums[i] = replace;
                counter++;
            }
        }
        return counter;
    }

    public int countAscending()
    {
        int counter = 1;
        int max = 0;
        for(int i = 0; i < nums.length - 1; i++) //going through each element to see if ascending
        {
            if(nums[i+1] - nums[i] >= 0) //elements are ascending--> increase counter
                counter++;
            if(counter > max) //new longest string of ascending numbers --> new max
                max = counter;
            if(!(nums[i+1] - nums[i] >= 0)) //break in ascending pattern --> reset counter
                counter = 1;
        }
        return max;
    }

    public boolean swap(int index1, int index2)
    {
        if(index1 >=0 && index1 < nums.length && index2 >=0 && index2 < nums.length) //checking bounds
        {
            double tempDouble = nums[index1]; //swapping the two elements
            nums[index1] = nums[index2];
            nums[index2] = tempDouble;
            return true;
        }
        return false;
    }

    public boolean hasDuplicate()
    {
        for(int i = 0; i < nums.length; i++) //going through all elements
        {
            for(int j = i + 1; j < nums.length; j++) //comparing all elements after those at index i to avoid duplicates
            {
                if(nums[i] == nums[j])
                    return true;
            }
        }
        return false;
    }

    public boolean add(int index, double value)
    {
        double[] newNums = new double[nums.length + 1];
        if(index < newNums.length && index >= 0)//checking bounds
        {
            for(int i = 0; i < index; i++) //copying down values up until inserted value
                newNums[i] = nums[i];
            newNums[index] = value; //inserting value
            if(index == nums.length) //if value is added to end of array
            {
                nums = newNums;
                return true;
            }
            else
            {
                for(int i = index + 1; i < newNums.length; i++) //copying rest of values
                    newNums[i] = nums[i-1];
                nums = newNums;
                return true;
            }
        }
        else
            return false;
    }

    public void remove(int index)
    {
        double[] newNums = new double[nums.length - 1];
        for(int i = 0; i < index; i++) //copying down values up until inserted value
            newNums[i] = nums[i];
        for(int i = index; i < newNums.length; i++) //copying rest of values excluding one at index
            newNums[i] = nums[i+1];
        nums = newNums;
    }

    public void printNums()
    {
        System.out.println(nums);
    }
}



