/*
Program Name:       HotDogStand
Date:               June 9th 2018
Author:             Trishal Varma
Program Purpose:    Creating classes and objects

Program Design Description: The program creates hotdog stands with id and locations to find total
amount of hotdogs sold in 3 different locations.

*/

package com.HotDogStand;

public class HotDogStandMainClass
{
    public static void main(String[] args)
    {

        HotDogStandClass s1,s2, s3;
        s1 = new HotDogStandClass("S020", 3, "14 Donald Trump Sucks st., New York 08820, United States of America", 2);
        s2 = new HotDogStandClass();
        s3 = new HotDogStandClass();


        s2.setID("S023");
        s2.setSale(4);
        s2.setLocation("12 Amitabh Bachan Road, Mumbai 800098, India");
        s2.setcost(2);

        s3.setID("S032");
        s3.setSale(3);
        s3.setLocation("2502 Hrithik Roshan blvd, Sochi 732034, Russia");
        s3.setcost(3);


        //HotDogStandClass s3 = new HotDogStandClass(s2);



        //justSold and getTotalSold
        for (int i=0; i < 20; i++)
        {
            s1.justSold();
            HotDogStandClass.getTotalSold();
        }
        for (int i=0; i < 10; i++)
        {
            s2.justSold();
            HotDogStandClass.getTotalSold();
        }
        for (int i=0; i < 10; i++)
        {
            s3.justSold();
            HotDogStandClass.getTotalSold();
        }

        System.out.println("Total sale of three hot dog stands is " + HotDogStandClass.getTotalSold());

        //print s1,s2, and s3
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);


        //compare s3 and s2
        System.out.println("Compare two hot dog stands");
        if (s3.equals(s2))
            System.out.println("Two hot dog stands S2 and S3 have same data"
                    + " or same reference");
        else
            System.out.println("Two hot dog stands s2 and s3 have different data");

        //compare s3 and s1
        if (s3.equals(s1))
            System.out.println("Two hot dog stands s1 and s3 have same data"
                    + " or same reference");
        else
            System.out.println("Two hot dog stands s1 and s3 have different data");

        //compare s2 and s1
        if(s2.equals(s1))
            System.out.println("Two hot dog stands s2 and s1 have same data"
                    + " or same reference");
        else
            System.out.println("Two hot dog stands s2 and s1 have different data");


        System.gc();
    }
}
