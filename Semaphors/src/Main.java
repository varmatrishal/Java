

/*
Name:           Trishal Varma
Date:           April 4th, 2020
Class:          Operating Systems Concepts - S20
Professor:      Greg Ozbirn
Objective:      Design and learn how multiple threads coordinate using semaphores.

 */

import java.util.stream.IntStream;
import static java.lang.System.*;

public class Main {
    public static void main (String... args) {

        PostOffice Po;
        IntStream.range(0, PostOffice.custNum).forEachOrdered(i -> {
            PostOffice.objCust[i] = new Customer(i);
            PostOffice.t[i] = new Thread(PostOffice.objCust[i]);
            PostOffice.t[i].start();
        });

        IntStream.range(0, PostOffice.Num).forEachOrdered(i1 -> {
            PostOffice.objWork[i1] = new Worker(i1);
            PostOffice.t2[i1] = new Thread(PostOffice.objWork[i1]);
            PostOffice.t2[i1].start();
        });

        IntStream.range(0, PostOffice.custNum).forEachOrdered(i -> {
            try {
                PostOffice.t[i].join();
                out.println("Joined customer " + i);
            } catch (InterruptedException e) {

            }
        });
        exit(0);
    }
}

/**
 @author Trishal Varma
 @since March 31st 2020
 */