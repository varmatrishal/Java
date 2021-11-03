/*  Project Created by Trishal Varma


package com.company;
import java.util.Scanner;
import java.util.Arrays;
public class Array {


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the total number of numbers for the program?");
        int num = input.nextInt();

        int number[] = new int[num];
        int low = number[0];
        int high = number[0];
        int sum = 0;
        double avgNum;

        System.out.println("Enter the " + num + " numbers now.");

        for (int i = 0 ; i < number.length; i++ ) {
            number[i] = input.nextInt();
        }
        
        System.out.println("Here are the numbers sorted from low to high: ");
        Arrays.sort( number );
        for ( int i = 0 ; i < number.length ; i++ ) {

            System.out.println(number[i]);
        }

        for (int i : number)
            sum += i;
        avgNum = (double)sum/number.length;


        for (int counter = 0; counter < number.length; counter++)
        {
            if (number[counter] > high)
            {
                high = number[counter];
            }
        }

        for (int counter = 0; counter < number.length; counter++)
        {
            if (number[counter] < low)
            {
                low = number[counter];
            }
        }

        System.out.println("The largest number is: " + high);
        System.out.println("The lowest number is: " + low);
        System.out.println("The average of the " + num + " numbers are:  " + avgNum);
    }


        }


