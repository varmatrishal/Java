/*
Program Name:       HotDogStand
Date:               June 9th 2018
Author:             Trishal Varma
Program Purpose:    Creating classes and objects

Program Design Description: The program creates hotdog stands with id and locations to find total
amount of hotdogs sold in 3 different locations.

*/


package com.HotDogStand;
public class HotDogStandClass
{
    private int sale;
    private int cost;
    private String ID;
    private String Location;
    private static int totalSold;

    //default constructor
    public HotDogStandClass()
    {
        ID = "";
        Location = "";
        cost = 0;
        sale = 0;
    }

    //overloaded constructor
    public HotDogStandClass(String a, int b, String c, int d)
    {
        ID = a;
        sale = b;
        Location = c;
        cost = d;
    }

    //copy constructor
    public HotDogStandClass (HotDogStandClass s)
    {
        if(s == null)
        {
            System.out.println("Error");
            System.exit(0);
        }
        else
        {
            sale = s.sale;
            Location = new String(s.Location);
            cost = s.cost;
            ID = new String(s.ID);
        }
    }

    //setters and getters
    public void setID(String a)
    {
        ID =a;
    }
    public String getID()
    {
        return new String(ID);
    }


    public void setLocation(String c)
    {
        Location =c;
    }
    public String getLocation()
    {
        return new String(Location);
    }



    public void setSale(int s)
    {
        sale= s;
    }
    public int getSale()
    {
        return sale;
    }


    public void setcost(int d)
    {
        cost= d;
    }
    public int getcost()
    {
        return cost;
    }



    //totalSold
    public static int getTotalSold()
    {
        return totalSold;
    }

    //justSold
    public void justSold()
    {
        totalSold ++;
        sale ++;
    }
    //toString method
    public String toString()
    {
        String x = "Hot dog stand with ID " + ID + " at " + Location + " sold " + sale;
        return x;
    }
    //compare two HotDogStandClass the same and the same sale
    public boolean equals(HotDogStandClass s)
    {
        if (this == s)
            return true;

        if(s != null && getClass( ) == s.getClass( ) )
        {
            HotDogStandClass h = new HotDogStandClass(s);
            if(sale == h.sale && ID.equals(h.ID))
                return true;
            else
                return false;
        }
        else
            return false;
    }

    public void finalize ( )
    {
        System.out.println  ( "HotDogStandClass class - finalize method" );
    }
    public void dispose ( )
    {
        System.out.println  ( "HotDogStandClass class - dispose method" );
    }
}


