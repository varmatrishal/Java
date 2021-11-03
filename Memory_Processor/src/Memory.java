/*
Name:           Trishal Varma
Date:           February 18th, 2020
Class:          Operating Systems Concepts - S20
Professor:      Greg Ozbirn
Objective:      Learn how multiple processes can communicate and copperate with one another.
                Understanding low-level concepts important to an operating system.
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Memory
{
    // Array of integers representing memory
    static int[] memory = new int[2000];        // memory can't be private

    public static void main() {
        main();
    }

    public static void main(String[] args) throws FileNotFoundException {

        if(args.length < 1) // If input is less than exit the progaram, level.
        {
            System.exit(1);
        }
        String inputPath;
        inputPath = args[0];
        initializeMemory(inputPath);


        Scanner input = new Scanner(System.in);
        while(input.hasNextLine())
        {
            String line = input.nextLine();
            char command = line.charAt(0);
            int address, data;
            switch(command)
            {

                // Reads command from address.
                case 'r': // read command
                    address = Integer.parseInt(line.substring(1));
                    System.out.println(read(address));
                    break;
                // Write commands from address, and data.
                case 'w': // write command
                    String[] params = line.substring(1).split(",");
                    address = Integer.parseInt(params[0]);
                    data = Integer.parseInt(params[1]);
                    write(address, data);
                    break;
                    // ends the command.
                case 'e':
                    System.exit(0);
            }

        }
        input.close();
    }
    private static void initializeMemory(String inputFilePath) throws FileNotFoundException
    {
        Scanner scan = new Scanner(new File(inputFilePath));
        int memIndex = 0;
        while(true)
        {
            if (!(scan.hasNextLine())) break;
            String line = scan.nextLine().trim();
            if(line.length() < 1) // Empty line, skip it.
            {
                continue;
            }

            if (line.charAt(0) == '.') {
                memIndex = Integer.parseInt(line.substring(1).split("\\s+")[0]);
            } else { // when gets to line .1000 skip


                if (line.charAt(0) < '0' || line.charAt(0) > '9')// slip if number
                    continue;
                String[] split = line.split("\\s+");
                if (split.length < 1) // An empty line, skip it
                {
                    continue;
                } else // Read the first integer into memory
                {
                    memory[memIndex++] = Integer.parseInt(split[0]);
                }
            }
        }
        scan.close();
    }

    private static void store(String str)
    {
        // store string value which is logged.
    }

    private static int read(int address)
    {
        store("Reading "+address+" = "+memory[address]);
        return memory[address];
    }


    private static void write(int address, int data)
    {
        store("Writing "+data+" to "+address);
        memory[address] = data;
    }

}

/**
 @author Trishal Varma
 @since February 21st 2020
 */