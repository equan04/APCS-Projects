import java.util.Scanner;
/**
 * class MyVectorSimulator tests enhancements of the MyVector class
 * 
 * @author Emmett Q
 * @version 10/1/21
 */
public class MyVectorSimulator
{
    public static void main(String[]args)
    {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter a vector in the form (int, int): ");
        String inVector1 = in.nextLine();
        
        System.out.print("Enter a vector in the form (int, int): ");
        String inVector2 = in.nextLine();
        
        int v1x = Integer.parseInt(inVector1.substring(1, inVector1.indexOf(",")));
        int v1y = Integer.parseInt(inVector1.substring(inVector1.indexOf(" ")+1, inVector1.indexOf(")")));
        int v2x = Integer.parseInt(inVector2.substring(1, inVector2.indexOf(",")));
        int v2y = Integer.parseInt(inVector2.substring(inVector2.indexOf(" ") + 1, inVector2.indexOf(")")));
        
        MyVector vector1 = new MyVector(v1x, v1y);
        MyVector vector2 = new MyVector (v2x, v2y);
        
        System.out.println("The angle between " + inVector1 + " and " + inVector2 + " is: " + vector1.angle(vector2));
    }
}


