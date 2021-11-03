/*  Project by Trishal Varma

    Lab Date: December 8th 2017 */
package com.company;

public class Drama extends Movie

{
    public Drama()
    {
        super();
    }

    public Drama(String aRating, int aID, String aTitle)
    {
        super(aRating, aID, aTitle);
    }

    public double calcLateFees(int days)
    {
        return 2.0 * days;
    }
}