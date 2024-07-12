import java.util.*;

public class Circle {
    int x;
    int y;
    int radius;
    public static void main(String[] args){
   
    }
    public Circle(int x, int y, int radius){
        newCircle(x, y, radius);
    }
    Circle newCircle(int x, int y, int radius){
        if(radius == 0){
            Utility.error("Fehler Falsche Angabe");
        }
        return new Circle(x, y, radius);
    }
    static Circle clone(Circle kreis){
        return new Circle(kreis.x, kreis.y, kreis.radius);
    }
}
