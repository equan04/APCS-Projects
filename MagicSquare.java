/**
 * class MagicSquare is the programming project using magic squares made of arrays
 *
 * @author Emmett Quan
 * @version 1/10/22
 */
public class MagicSquare
{
    // instance variables
    private int[][] square;

    /**
     * default Constructor for objects of class MagicSquares (3x3 square)
     */
    public MagicSquare()
    {
        square = new int[3][3];
        //hard coding magic square
        square[1][1] = 4;
        square[1][2] = 9;
        square[1][3] = 2;
        square[2][1] = 3;
        square[2][2] = 5;
        square[2][3] = 7;
        square[3][1] = 8;
        square[3][2] = 1;
        square[3][3] = 6;
    }

    public int getMagicNumber() //gets magic number of magic MagicSquare, return -1 if not magic MagicSquare
    {
        int magicNum = 0;
        for(int i = 0; i < square.length; i++)//adding diagonal
            magicNum += square[i][i];
        int diagTempNum = 0; // to check other diagonal with
        for(int i = 0; i < square.length; i++)//checking other diagonal
        {
            diagTempNum += square[i][square.length - 1 - i];
        }
        if(diagTempNum != magicNum)
            return -1;
        for(int row = 0; row< square.length; row++) //adding up rows
        {
            int tempNum = 0; //testing if magic square
            for(int element : square[0])
                tempNum+= element;
            if(tempNum != magicNum)
                return -1;
        }
        for(int col = 0; col < square[0].length; col++) //adding up columns
        {
            int tempNum = 0; //testing if magic square
            for(int row = 0; row < square.length; row++)
                tempNum+= square[row][col];
            if(tempNum != magicNum)
                return -1;
        }
        return magicNum; //MagicSquare is magic square, returning magic number
    }

    public void print() //prints magic square
    {
        for(int row = 0; row < square.length; row++)
        {
            for(int col = 0; col < square[0].length; col++)
                System.out.print(square[row][col]); //printing row elements
            System.out.println(); //creating new row
        }
    }

    public static boolean isMagicSquare(int[][] square)//tests if magic square
    {
        int magicNum = 0;
        for(int i = 0; i < square.length; i++)//adding diagonal
            magicNum += square[i][i];
        int diagTempNum = 0; // to check other diagonal with
        for(int i = 0; i < square.length; i++)//checking other diagonal
        {
            diagTempNum += square[i][square.length - 1 - i];
        }
        if(diagTempNum != magicNum)
            return false;
        for(int row = 0; row< square.length; row++) //adding up rows
        {
            int tempNum = 0; //testing if magic Square
            for(int element : square[0])
                tempNum+= element;
            if(tempNum != magicNum)
                return false;
        }
        for(int col = 0; col < square[0].length; col++) //adding up columns
        {
            int tempNum = 0; //testing if magic Square
            for(int row = 0; row < square.length; row++)
                tempNum+= square[row][col];
            if(tempNum != magicNum)
                return false;
        }
        return true;
    }

    public MagicSquare(int[][] mySquare) //parameterized constructor
    {
        mySquare = new int[mySquare.length][mySquare[0].length];
    }
}
