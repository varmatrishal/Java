/* Project Created by Trishal Varma  */

package com.company;

import java.util.Scanner;

public class Distance  {

    public static void main(String[] args) {
Scanner keyboard = new Scanner(System.in);

        double distance;
        double totalCost;
        double pricePerGallon;

        System.out.println("How many miles do you drive? ");
                distance = keyboard.nextDouble();

        System.out.println ("What is the price of gas? ");
                pricePerGallon = keyboard.nextDouble();

                totalCost = distance * pricePerGallon;



        System.out.println("The cost of commute for diving " + distance + " miles, with gas priced at $ " +pricePerGallon +", is $ " +totalCost+ " dollars." );


    }
}
