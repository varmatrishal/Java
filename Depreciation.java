/* Project Created by Trishal Varma  */


package com.company;


import java.util.Scanner;

public class Depreciation {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        double purchasePrice;
        double salvageValue;
        double numberYears;
        double depreciationValue;


       System.out.println("Enter the purchase price of your item: ");
            purchasePrice = keyboard.nextDouble();

        System.out.println("Enter the salvage value of your item: ");
            salvageValue = keyboard.nextDouble();

        System.out.println("Enter the number of years for service: ");
            numberYears = keyboard.nextDouble();

        depreciationValue = (purchasePrice - salvageValue) / numberYears;

     System.out.println("The Depreciated value of your item is: $ " +depreciationValue+ ", because the purchse price of your item being $ "
             +purchasePrice+ ", the salvage year is " +salvageValue+ " through " +numberYears+ " of service.");


    }
}
