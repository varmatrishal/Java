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

public class PostOffice {


    public static Semaphore maxCap = new Semaphore(10, true);             // Max Capacity of the Post Office //
    public static Semaphore Ready = new Semaphore(0, true);
    public static Semaphore Desk = new Semaphore(3, true);
    public static Semaphore mutex = new Semaphore(1, true);


    public static Semaphore coord = new Semaphore(0, true);
    public static Semaphore leave = new Semaphore(0, true);
    public static Semaphore coordN = new Semaphore(0, true);
    public static Semaphore scale = new Semaphore(1, true);

    
    public static int count;
    public static Queue<Integer> queue;
    public static final int custNum = 50;
    public static final int Num = 3;
    public static Semaphore[] finished;

    static {
        finished = new Semaphore[custNum];
        queue = new LinkedList<>();
        for (int i = 0; i < custNum; i++) finished[i] = new Semaphore(0, true);
    }
    public static Customer[] objCust;

    static {
        objCust = new Customer[custNum];
    }

    public static Worker[] objWork;

    static {
        objWork = new Worker[Num];
    }

    public static Thread[] t;

    static {
        t = new Thread[custNum];
    }

    public static Thread[] t2;

    static {
        t2 = new Thread[Num];
    }
}


/**
 @author Trishal Varma
 @since April 3rd 21st 2020
 */