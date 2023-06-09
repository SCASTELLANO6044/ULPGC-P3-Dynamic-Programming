package org.example.main;


import org.example.dynamicprogramming.Memoization;
import org.example.dynamicprogramming.Tabulation;
import org.example.utils.AlphanumericSortComparator;
import org.example.utils.Description;
import org.example.utils.FileInputReader;
import org.example.utils.Switches;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        if (Switches.contains(args, "-h", "--help")) Switches.help();

        boolean tab = false;
        boolean mem = false;
        boolean both = false;

        if (Arrays.asList(args).contains("-check")) {
            both = true;
        } else if (Switches.contains(args, "-sm", "--memoization")) {
            mem = true;
        } else if (Switches.contains(args, "-st", "--tabulation" )) {
            tab = true;
        }else {
            Switches.help();
        }

        boolean isDirectory = false;
        String path = "";

        if (Switches.contains(args, "-d", "--directory")){
            isDirectory = true;
            path = args[Switches.indexOf(args, "-d", "--directory") + 1];
        } else if (Switches.contains(args, "-f", "--file")) {
            path = args[Switches.indexOf(args, "-f", "--file") + 1];
        }else {
            Switches.help();
        }

        DecimalFormat df = new DecimalFormat("#.000000");

        if(isDirectory){
            File f = new File(path);
            String[] files = f.list();
            Comparator<String> numericalOrder = AlphanumericSortComparator.NUMERICAL_ORDER;
            Arrays.sort(files, numericalOrder);
            for (String file : files){
                Description description = new FileInputReader().read(path+file);
                if(both){
                    long startTime = System.currentTimeMillis();
                    Map<String, Integer> memory = new HashMap<>();
                    int memoization = Memoization.execute(description.getCoinTypeArray(),
                            description.getCoinTypeArray().length - 1,description.getSum(), memory);
                    System.out.println(file + ": Number of paths with memoization: "+ memoization);
                    long finalTime = System.currentTimeMillis() - startTime;
                    System.out.println("Time: " + df.format(finalTime / 1000.0) + " s");
                    System.out.println("****************************************");
                    startTime = System.currentTimeMillis();
                    int tabulation = Tabulation.execute(description.getCoinTypeArray(), description.getSum());
                    System.out.println(file + ": Number of paths with tabulation: "+ tabulation);
                    finalTime = System.currentTimeMillis() - startTime;
                    System.out.println("Time: " + df.format(finalTime / 1000.0) + " s");
                    System.out.println("****************************************");
                } else if (mem) {
                    long startTime = System.currentTimeMillis();
                    Map<String, Integer> memory = new HashMap<>();
                    int memoization = Memoization.execute(description.getCoinTypeArray(),
                            description.getCoinTypeArray().length - 1,description.getSum(), memory);
                    System.out.println(file + ": Number of paths with memoization: "+ memoization);
                    long finalTime = System.currentTimeMillis() - startTime;
                    System.out.println("Time: " + df.format(finalTime / 1000.0) + " s");
                    System.out.println("****************************************");
                } else if (tab) {
                    long startTime = System.currentTimeMillis();
                    int tabulation = Tabulation.execute(description.getCoinTypeArray(), description.getSum());
                    System.out.println(file + ": Number of paths with tabulation: "+ tabulation);
                    long finalTime = System.currentTimeMillis() - startTime;
                    System.out.println("Time: " + df.format(finalTime / 1000.0) + " s");
                    System.out.println("****************************************");
                }
            }
        }else {
            Description description = new FileInputReader().read(path);
            if(both){
                long startTime = System.currentTimeMillis();
                Map<String, Integer> memory = new HashMap<>();
                int memoization = Memoization.execute(description.getCoinTypeArray(),
                        description.getCoinTypeArray().length - 1,description.getSum(), memory);
                System.out.println(path + ": Number of paths with memoization: "+ memoization);
                long finalTime = System.currentTimeMillis() - startTime;
                System.out.println("Time: " + df.format(finalTime / 1000.0) + " s");
                System.out.println("****************************************");
                startTime = System.currentTimeMillis();
                int tabulation = Tabulation.execute(description.getCoinTypeArray(), description.getSum());
                System.out.println(path + ": Number of paths with tabulation: "+ tabulation);
                finalTime = System.currentTimeMillis() - startTime;
                System.out.println("Time: " + df.format(finalTime / 1000.0) + " s");
                System.out.println("****************************************");
            } else if (mem) {
                long startTime = System.currentTimeMillis();
                Map<String, Integer> memory = new HashMap<>();
                int memoization = Memoization.execute(description.getCoinTypeArray(),
                        description.getCoinTypeArray().length - 1,description.getSum(), memory);
                System.out.println(path + ": Number of paths with memoization: "+ memoization);
                long finalTime = System.currentTimeMillis() - startTime;
                System.out.println("Time: " + df.format(finalTime / 1000.0) + " s");
                System.out.println("****************************************");
            } else if (tab) {
                long startTime = System.currentTimeMillis();
                int tabulation = Tabulation.execute(description.getCoinTypeArray(), description.getSum());
                System.out.println(path + ": Number of paths with tabulation: "+ tabulation);
                long finalTime = System.currentTimeMillis() - startTime;
                System.out.println("Time: " + df.format(finalTime / 1000.0) + " s");
                System.out.println("****************************************");
            }

        }

    }
}