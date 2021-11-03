/*
Name:           Trishal Varma
Date:           April 4th, 2020
Class:          Operating Systems Concepts - S20
Professor:      Greg Ozbirn
Objective:      Design and learn how multiple threads coordinate using semaphores.

 */

import java.util.Random;
import java.util.concurrent.Semaphore;

import static java.lang.System.*;

public class Customer implements Runnable {


    public int custNum;
    public int task;
    public int worker;


    Customer(int custNum) {
        this.custNum = custNum;
    }


    @Override
    public void run() {
        cust_create();
        wait(PostOffice.maxCap);
        cust_enterPostO();
        wait(PostOffice.Desk);
        wait(PostOffice.mutex);
        addtoqueue(custNum);
        signal(PostOffice.Ready);
        signal(PostOffice.mutex);
        wait(PostOffice.coord);
        cust_req();
        signal(PostOffice.coordN);
        wait(PostOffice.finished[custNum]);
        finished_work();
        leaves();
        signal(PostOffice.leave);
        signal(PostOffice.maxCap);
        PostOffice.count++;
    }

    void leaves() {
        out.println("Customer " + custNum + " leaves post office");              // Customer leaves Post Office.
    }

    void finished_work() {
        out.println("Customer " + custNum + " finished " + tasknameInter(task));     // Customer that is finshed the task.
    }

    private String tasknameInter(int task) {
        String message = new String();
        if (task == 1) {
            message = "Buying Stamps";

        } else if (task == 2) {
            message = "Mailing a Letter";

        } else if (task == 3) {
            message = "Mailing a Package";

        }
        return message;
    }



/** Customer requesting a worker for additoinal help in the line. **/


    void cust_req() {
        out.println("Customer " + custNum + " asks postal worker " + worker + " to " + taskname(task));
        Worker.Queue.add(task);
    }


    private String taskname(int task) {
        String message = new String();
        if (task == 1) {
            message = "Buy Stamps";

        } else if (task == 2) {
            message = "Mail a Letter";

        } else if (task == 3) {
            message = "mail a Package";

        }
        return message;
    }

    void addtoqueue(int custId) {                                                  // Customer ID added to the line.
        PostOffice.queue.add(custId);
    }

    void cust_create() {                                                       // Create customer to be assigned a task to.
        out.println("Customer " + custNum + " created");
        Random r = new Random();
        int low;
        low = 1;
        int high;
        high = 4;
        switch (this.task = r.nextInt(high - low) + low) {
        }
    }


    void wait(Semaphore sem) {                                                        // Sempahore waits //
        try {
            sem.acquire();
        } catch (InterruptedException ignored) {

        }
    }


    void cust_enterPostO() {
        out.println("Customer " + custNum + " enters PostOffice");
    }


    void signal() {
        signal();
    }

    void signal(Semaphore sem) {
        sem.release();
    }
}

/**
 @author Trishal Varma
 @since April 2nd 2020
 */