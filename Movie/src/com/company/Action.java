/*  Project by Trishal Varma

    Lab Date: December 8th 2017 */

package com.company;
public class Action extends Movie

{

    public Action()
    {
        super();
    }
    public Action(String aRating, int aID, String aTitle)
    {
        super(aRating, aID, aTitle);
    }
    public double calcLateFees(int days)
    {
        return 3.0 * days;
    }
}
