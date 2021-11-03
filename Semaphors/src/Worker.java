/*
Name:           Trishal Varma
Date:           April 4th, 2020
Class:          Operating Systems Concepts - S20
Professor:      Greg Ozbirn
Objective:      Design and learn how multiple threads coordinate using semaphores.

 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Worker implements Runnable {

    public int Num;
    public static Queue<Integer> Queue = new LinkedList<>();
    private int next_cust_number;


    /**
     * @param Num
     */
    Worker(int Num) {
        this.Num = Num;
    }

    @Override
    public void run() {
        work_created();
        while (true) {
            if (!(true)) {
                break;
            }
            wait(PostOffice.Ready);
            wait(PostOffice.mutex);
            rmqueue();
            signal(PostOffice.mutex);
            signal(PostOffice.coord);
            wait(PostOffice.coordN);
            serve_cust();
            signal(PostOffice.finished[next_cust_number]);
            wait(PostOffice.leave);
            signal(PostOffice.Desk);
        }
    }


    void rmqueue() {                                                                // Removing customers from the line
        next_cust_number = PostOffice.queue.remove();
        System.out.println("Postal worker " + Num + " serving Customer " + next_cust_number);
        switch (PostOffice.objCust[next_cust_number].worker = Num) {
        }
    }


    void work_created() {                                                           // Creating workers//
        System.out.println("Postal Worker " + Num + " created");
    }

    void signal(Semaphore s) {

        s.release();

    }

    void serve_cust() {
        int task = Queue.remove();
        if (task == 1) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Postal worker " + Num + " finished serving customer " + next_cust_number);

        } else {
            if (task == 2) {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Postal worker " + Num + " finished serving customer " + next_cust_number);

            } else if (task == 3) {
                wait(PostOffice.scale);
                System.out.println("Scales in use by postal worker " + Num);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Scales released by postal worker " + Num);
                signal(PostOffice.scale);
                System.out.println("Postal worker " + Num + " finished serving customer " + next_cust_number);

            }
        }
    }

    void wait(Semaphore s) {
        try {
            s.acquire();
        } catch (InterruptedException ignored) {

        }
    }
}

/**
 @author Trishal Varma
 @since April 3rd 2020
 */