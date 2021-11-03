/* Project Created by Trishal Varma  */


package com.company;
import javax.swing.JOptionPane;

public class Temp  {

    public static void main(String[] args) {

        String fahrenheit = JOptionPane.showInputDialog(null,"Please Enter the Temperature in Fahrenheit: ",

                "Enter Fahrenheit", JOptionPane.QUESTION_MESSAGE);

        double fahrenTemp = Double.parseDouble(fahrenheit);

        double celsius = (5.0/9.0*(fahrenTemp-32));

        String output = "The temperature is " + celsius + " in Celsius";

        JOptionPane.showMessageDialog(null,output);


    }
}
