/* Project Created by Trishal Varma  */


    package com.company;

            import java.util.Scanner;
            import java.text.DecimalFormat;

public class Conversion {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
            double convertCelsius, convertKelvin;

        System.out.println("Please enter the starting Fahrenheit temperature: ");
            double startFahren = keyboard.nextDouble();

        System.out.println("Please enter the ending Fahrenheit temperature: ");
            double endFahren = keyboard.nextDouble();

        System.out.println("Enter the increment to calculate by: ");
            double increment = keyboard.nextDouble();

        System.out.println();
        System.out.println("|Fahren| |Celcius| |Kelvin|");
        System.out.println("---------------------------");

        DecimalFormat decimalPlaces = new DecimalFormat( "0.00");


        /* _________________________________Do while loop__________________________*/
        do {
            convertCelsius = (startFahren - 32)* (5.0/9.0);
            convertKelvin = convertCelsius + 273.15;


            System.out.printf("|  " + decimalPlaces.format (startFahren) + "|" +
                decimalPlaces.format(convertCelsius) +
                    "| " + decimalPlaces.format( convertKelvin) + "  |" );
            System.out.println();
                    startFahren += increment;

        }
        while (startFahren <= endFahren);



    }
}
