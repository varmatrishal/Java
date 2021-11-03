/* Project Created by Trishal Varma
Lab 4: Test for the Rectangle problem
 */

package com.company;
public class testClass {

        public static void main (String[] args) {

            Rectangles RectangRed = new Rectangles(9, 6, "Red");
            Rectangles RectangYellow = new Rectangles(4, 20, "Yellow");

   System.out.println(RectangRed.toString());
   System.out.println(RectangYellow.toString());

                                System.out.println();
            System.out.println("Area is " + RectangRed.findArea() + " for the Red rectangle.");
            System.out.println("Area is " + RectangYellow.findArea() + " for the Yellow rectangle.");

                                System.out.println();
            if (RectangRed.equals(RectangYellow))
            {
                System.out.println("Are the Rectangles equal: Yes");
            }
            else
            {
                System.out.println("Are the Rectangles equal: No");
            }
        }
}