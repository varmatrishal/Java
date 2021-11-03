/*  Project by Trishal Varma

    Lab Date: December 8th 2017 */
package com.company;
public class Comedy extends Movie

{

    public Comedy()
    {
        super();
    }
    public Comedy(String aRating, int aID, String aTitle)
    {
        super(aRating, aID, aTitle);
    }
    public double calcLateFees(int days)
    {
        return 2.5 * days;
    }
}