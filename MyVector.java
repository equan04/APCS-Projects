
/**
 * class MyVector represents a 2D vector object
 * 
 * @author Emmett Q
 * @version Sept 23 2021
 */
public class MyVector
{
    // instance variables - replace the example below with your own
    private int x;
    private int y;

    public MyVector(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public void setComponents(int myX, int myY)
    {
        x = myX;
        y = myY;
    }

    public int getFirstComponent()
    {
        return x;
    }

    public int getSecondComponent()
    {
        return y;
    }

    public String toString()
    {
        return "<" + x + ", " + y + ">";
    }

    public double norm()
    {
        double magnitude = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        return magnitude;
    }

    public int dot(MyVector vector)
    {
        int dotProduct = this.x * vector.getFirstComponent() + this.y * vector.getSecondComponent();
        return dotProduct;
    }

    public double angle(MyVector vector)
    {
        double unroundedAngle = Math.toDegrees(Math.acos(dot(vector)/(vector.norm() * this.norm())));
        double roundedAngle = (Math.round(unroundedAngle * 10000))/10000.0;
        return roundedAngle;
    }

    public MyVector()
    {
        x = (int)(Math.random() * 21 - 10);
        y = (int)(Math.random() * 21 - 10);
    }

    public boolean isOrthogonal(MyVector vector)
    {
        if (dot(vector) == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean isParallel(MyVector vector)
    {
        if (y / x == vector.getSecondComponent()/vector.getFirstComponent())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}


