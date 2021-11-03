/* Project Created by Trishal Varma
Objects and Classes
 */

package com.company;
import com.sun.org.apache.regexp.internal.RE;
import org.w3c.dom.css.Rect;
public class Rectangles {

                private double Width;
                private double Length;
                private String Color;

public Rectangles()             {
                                Width = 12;
                                Length = 4;
                                Color = "Purple";
                                }
     public Rectangles (double Wid, double Len, String Col) {
        Width = Wid;
        Length = Len;
        Color = Col;
    }
public double getWidth() {
        return Width;
    }
public void setWidth (double Wid) {
        Width = Wid;
    }
public double getLength() {
        return Length;
    }
public void setLength (double Len) {
        Length = Len;
    }
public String getColor() {
        return Color;
    }
public String toString() {


    return "The " + Color + " Rectangle has the dimensions of " + Width + " X " + Length;
    }
    public void setColor (String Col) {
        Color = Col;
    }
    public double findArea() {
        return Width * Length;
    }
    public boolean equals (Rectangles rect)
{
                    boolean Statement = false;
                        if (Length == rect.Length &&
                            Width == rect.Width &&
                                    Color.toString().equals(rect.getColor().toString()))
            Statement = true;
            return Statement;
    }
}
