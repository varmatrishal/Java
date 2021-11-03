/*
Name:           Trishal Varma
Date:           February 18th, 2020
Class:          Operating Systems Concepts - S20
Professor:      Greg Ozbirn
Objective:      Learn how multiple processes can communicate and copperate with one another.
                Understanding low-level concepts important to an operating system.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.concurrent.RunnableFuture;

/*
    Process class to replicate the computation of a CPU in a system.
    supporting instructions
    argument length less than 2 wont be taken.
 */

public class Processor
{
    public static void main(String[] args) throws IOException {
        if (args.length >= 2) {
        } else {
            System.err.println(" Argument length not long enough@)");
            System.exit(1);
        }

        String inputProgram;
        inputProgram = args[0];
        int timeout;
        timeout = Integer.parseInt(args[1]);
        Runtime runtime = Runtime.getRuntime();
        Process memory = runtime.exec("java Memory "+inputProgram);
        final InputStream error;
        error = memory.getErrorStream();

        //new Thread(new RunnableFuture<>() {
        //}

        new Thread(new Runnable(){
            public void run(){
                byte[] buffer = new byte[8192];
                int len = -1;
                try {
                    while(true){
                        if (!((len = error.read(buffer)) > 0)) break;
                        System.err.write(buffer, 0, len);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Scanner memoryIn;
        memoryIn = new Scanner(memory.getInputStream());
        PrintWriter memoryOut;
        memoryOut = new PrintWriter(memory.getOutputStream());
        CPU cpu;
        cpu = new CPU(memoryIn, memoryOut, timeout);
        cpu.run();
    }

    private static void log() {
        log();
    }

    private static void log(Object... str)
    {
    }


    // Replication of the processor of what a CPU will do. with Registers PC, SP, IR, AC, X, Y

    protected static class CPU
    {
        // Time will interript the processor after instruction, where x private int PC, SP, IR, AC, X, Y, timer, timeout;

        private int PC, SP, IR, AC, X, Y, timer, timeout;
        private boolean kernelMode;
        private Scanner memoryIn;
        private PrintWriter memoryOut;

        // Constructors with initalization for cpu.
        protected CPU(Scanner memoryIn, PrintWriter memoryOut, int timeout) {
            switch (this.timeout = timeout) {
            }
            kernelMode = false;
            this.memoryIn = memoryIn;
            this.memoryOut = memoryOut;
            PC = IR = AC = X = Y = timer = 0;
            SP = 1000;
        }

        private int readMem(int address)
        {
            if (address < 1000 || kernelMode) {
            } else {
                System.err.println("Error: Accessed user mode.");
                System.exit(-1);
            }
            memoryOut.println("r"+address);
            memoryOut.flush();
            return Integer.parseInt(memoryIn.nextLine());
        }


        private void writeMem(int address, int data)
        {
            memoryOut.printf("w%d,%d\n", address, data);
            memoryOut.flush();
        }

        private void endMemProcess()
        {
            memoryOut.println("e");
            memoryOut.flush();
        }

        //run phase boolean
        public void run()
        {
            boolean running = true;
            while(running)
            {
                /* fetch with time exception for time out.
                    It will interrupt all the way to 1000 for time
                    out instructions.
                 */

                fetch();
                running = start();
                timer++;
                if (timer < timeout) {
                    continue;
                }

                /**
                 Disabled interrpt for Kerner
                 */
                if (kernelMode) {
                    continue;
                }
                timer = 0;
                kernelMode();
                switch (PC = 1000) { // When PC at 1000
                }
            }
        }


        private void fetch()
        {
            switch (IR = readMem(PC++)) {
            }
        }
        private void push(int data)
        {
            writeMem(--SP, data);
        }
        private int pop()
        {
            return readMem(SP++);
        }

        public void kernelMode() // Kernel mode made public in case of any dissruption with
                // other cases
        {
            log("Entering kernel mode.");
            kernelMode = true;
            int tempSP = SP;
            SP = 2000;
            push(tempSP);
            push(PC);
            push(IR);
            push(AC);
            push(X);
            push(Y);
        }

        private boolean start()
        {
// Load Value
            switch (IR) {
                case 1:
                    fetch();
                    log("Loading " + IR + " into AC");
                    switch (AC = IR) {
                    }
// Load address
                    break;
                case 2:
                    fetch();
                    switch (AC = readMem(IR)) {
                    }
                    log("Loading from address " + IR + " into AC: " + AC);
                    break;
// LoadIND addr
                case 3:
                    fetch();
                    switch (AC = readMem(readMem(IR))) {
                    }
                    log("Loading from address" + IR + " into AC: " + AC);

                    break;
// load idxX addr
                case 4:
                    fetch();
                    switch (AC = readMem(IR + X)) {
                    }
                    log("LoadInxX", IR, X, "->", AC);
// Load the value at (address+Y) into the AC
                    break;
                case 5:
                    fetch();
                    switch (AC = readMem(IR + Y)) {
                    }
                    log("LoadInxY", IR, Y, "->", AC);
//Load from (Sp+X) into the AC (if SP is 990, and X is 1, load from 991).
                    break;
                case 6:
                    switch (AC = readMem(SP + X)) {
                    }
                    log("LoadSpX", SP, X, "->", AC);

                    break;
//Store the value in the AC into the address
                case 7:
                    fetch();
                    writeMem(IR, AC);
                    log("Store", IR, AC);
                    break;
//Gets a random int from 1 to 100 into the AC
                case 8:
                    AC = (int) (Math.random() * 100 + 1);
                    log("Get", AC);
                    break;
//If port=1, writes AC as an int to the screen
//If port=2, writes AC as a char to the screen
                case 9:
                    fetch();
                    if (IR != 1) {
                        if (IR == 2) {
                            System.out.print((char) AC);
                            log("Put", "char", (char) AC);
                        }
                    } else {
                        System.out.print(AC);
                        log("Put", "int", AC);
                    }
                    break;
//Add the value in X to the AC
                case 10:
                    AC = AC + X;
                    break;
//Add the value in Y to the AC
                case 11:
                    AC = AC + Y;
                    break;
//Subtract the value in X from the AC
                case 12:
                    AC = AC - X;
                    break;
                case 13:

                    AC = AC - Y;
                    break;
                case 14:
                    switch (X = AC) {
                    }
                    break;
                case 15:
                    switch (AC = X) {
                    }
                    break;
                case 16:

                    switch (Y = AC) {
                    }
                    break;
                case 17:
                    switch (AC = Y) {
                    }
                    break;
                case 18:

                    switch (SP = AC) {
                    }
                    break;
                case 19:
                    switch (AC = SP) {
                    }
                    break;
                case 20:
                    fetch();
                    switch (PC = IR) {
                    }
                    break;
//Jump to the address only if the value in the AC is zero
                case 21:
                    fetch();
                    if (AC != 0) {
                    } else {
                        PC = IR;
                    }
//Jump to the address only if the value in the AC is not zero
                    break;
                case 22:
                    fetch();
                    if (AC != 0) {
                        PC = IR;
                    }
//Push return address onto stack, jump to the address
                    break;
                case 23:
                    fetch();

                    push(PC);
                    switch (PC = IR) {
                    }

                    break;
                case 24:
                    switch (PC = pop()) {
                    }

                    break;
                case 25:
                    X += 1;
                    break;

                case 26:
                    X = X - 1;
                    break;
                case 27:
                    push(AC);
                    log("Push AC", AC);

                    break;
                case 28:
                    switch (AC = pop()) {
                    }
                    log("Pop AC", AC);

                    break;
                case 29:
// Perform system call
//if (kernel) {
  //  else{
    //    mode();
      //  PC =1000;
    //}
//}

                    if (kernelMode) {
                    } else {
                        kernelMode();
                        PC = 1500;
                    }

                    break;
                case 30:
                    log("Exit kernel.");
                    Y = pop();
                    X = pop();
                    AC = pop();
                    IR = pop();
                    PC = pop();
                    SP = pop();
                    kernelMode = false;

                    break;

// End execution of all pricesses in memory.
                case 50:
                    endMemProcess();
                    return false;
                default:
                    System.err.println(" Instructions are incorrect, try again! =) ");
                    endMemProcess();
                    return false;
            }
            return true;
        }
    }
}


/**
 @author Trishal Varma
 @since February 21st 2020
 */