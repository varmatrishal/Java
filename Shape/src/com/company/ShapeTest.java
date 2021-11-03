/*  Project Created by Trishal Varma
*/

public class ShapeTest

{
    public static void main(String[] args)

    {
        Shape shapelip1 = new Shape();
        Ellipse elip1 = new Ellipse();
        Rectangle rectrig1 = new Rectangle();
        Triangle trig1 = new Triangle();
        Square square1 = new Square();
        Circle circle1 = new Circle();

        Shape shape[] = {shapelip1, elip1, rectrig1, trig1, square1, circle1};

        for (int i = 0; i < shape.length; i++)
        {
            System.out.println();
            shape [i].draw();
            shape[i].erase();
            shape[i].move();
        }

    }
}
