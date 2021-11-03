/*  Project by Trishal Varma

    Lab Date: December 8th 2017 */
package com.company;


public class Main

{

    public static void main(String[] args)

    {
        Movie movie = new Movie("PG-13", 41245, "The Dark Knight Rises");
        Action action = new Action("G", 2587, "Finding Nemo");
        Comedy comedy = new Comedy("R", 7989, "Dead Pool");
        Drama drama = new Drama("PG-13", 4563, "Spider Man Homecoming");
        System.out.println(movie);
        System.out.println("Late Fee: $" + movie.calcLateFees(10));
        System.out.println(action);
        System.out.println("Late Fee: $" + action.calcLateFees(10));
        System.out.println(comedy);
        System.out.println("Late Fee: $" + comedy.calcLateFees(10));
        System.out.println(drama);
        System.out.println("Late Fee: $" + drama.calcLateFees(10));

    }

}


