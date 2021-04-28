package constituents;

//import org.jetbrains.annotations.NotNull;
import com.sun.istack.internal.NotNull;
import exceptions.ValidationException;

/**
 * Class of coordinates of studygroup.
 */
public class Coordinates {
    private double x;
    @NotNull
    private int y; // Поле не может быть null
    /**
     * Constructor.
     */
    public Coordinates() {}
    /**
     * Constructor
     * @param x - the coordinate x
     * @param y - the coordinate y
     * @throws NullPointerException
     * @throws ValidationException
     */
    public Coordinates(double x,int y) throws ValidationException {

        this.x = x;
        this.y = y;
    }

    public void setX(double x) { this.x = x; }

    public void setY(int y) throws NullPointerException, ValidationException {

        this.y = y;
    }

    public double getX() {return x;}
    public int getY() {return y;}

    /**
     * Method which compares coordinates with each other.
     * @param anotherCoordinates - another coordinates.
     * @return
     */
    public int compareTo(Coordinates anotherCoordinates){
        return (int) (this.x - anotherCoordinates.x);
    }

    @Override
    public String toString() {
        return "Coordinates [x = " + x + ", y = " + y +"] ";
    }
}
