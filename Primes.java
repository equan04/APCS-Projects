
/**
 * class Primes is a project with number theory and loops.
 * 
 * @author Emmett Q 
 * @version 11/4/21
 */
public class Primes
{
    public static boolean isPrime(int p)
    {
        if (p <= 1) //exception
            return false;
        for (int i = 2; i < p; i++)
            if (p % i == 0)
                return false;
        return true;
    }

    public static void printPrimes(int n)
    {
        int counter = 0;
        int num = 2;
        if(n >= 1)//checking precondition
        {
            while(counter < n)//making sure # of primes doesn't exceed n
            {
                if(isPrime(num))//checking and printing primes
                {
                    System.out.println(num);
                    counter++;
                }
                num++;
            }
        }
    }

    public static int countPrime(int max)
    {
        int counter = 0;
        for(int i = 0; i <= max; i++)
        {
            if(isPrime(i)) //counting prime number less than max
                counter++; 
        }
        return counter;
    }

    public static int maximumPrime(int max)
    {
        int maxPrime = 0;
        if(max < 2) //result for invalid
            return -1;
        for(int i = 0; i <= max; i++)
        {
            if(isPrime(i))
                maxPrime = i; //storing largest prime
        }
        return maxPrime;
    }

    public static int sumPrime(int n)
    {
        int sum = 0;
        int counter = 0;
        int num = 2;
        if(n >= 1) //checking precondition
        {
            while(counter < n)//making sure # of primes doesn't exceed n
            {
                if(isPrime(num))//checking and printing primes
                {
                    sum += num; //adding prime to total sum
                    counter++;
                }
                num++;
            }
            return sum;
        }
        else
            return 0;
    }
    
    public static double avePrime(int n)
    {
        if (n >= 1)
        {
            return (sumPrime(n) + 0.0) / n; //finding ave using helper method
        }
        else
            return 0;
    }

    public static int primeSpace(int n)
    {
        int counter = 0;
        int maxDist = 0;
        int pastPrime = 2; //2 is the first prime number
        if (n >= 3) //3 is the minimum input that has two prime number <=
        {
            for(int i = 3; i <= n; i++)  
            {
                if(isPrime(i)) //finding primes
                {
                    if(i - pastPrime > maxDist)
                    {
                        maxDist = i - pastPrime; //setting new biggest distance
                    }
                    pastPrime = i;
                }
            }
            return maxDist;
        }
        else
            return 0;
    }
    
    public static int countTwinPrimes(int n)
    {
        int counter = 0;
        int pastPrime = 2; //first prime num
        for(int i = 0; i <= n; i++)
        {
            if(isPrime(i))
            {
                if(i - pastPrime == 2)
                    counter++;
                pastPrime = i;
            }
        }
        return counter;
    }

    public static String factor(int num)
    {
        String result = "";
        int quotient = num;
        while(!(isPrime(quotient)))
        {
            for(int i = 2; i <= quotient; i++)
            {
                if(isPrime(i) && quotient % i == 0)
                    result = result + "*" + i;
            }
        }
        result = result + "*" + quotient;
        return result;
    }

}



