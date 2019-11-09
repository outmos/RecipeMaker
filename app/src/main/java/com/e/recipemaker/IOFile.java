package com.e.recipemaker;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class IOFile {
    public static void writeFile(File file, String[] record){
        try (CSVWriter writer = new CSVWriter(new FileWriter(file, true))){
            writer.writeNext(record);
            System.out.println(record);
        } catch (IOException e) {
            System.out.println("echec d'écriture");
            e.printStackTrace();
        }
    }

    public static void readFile(File file){
        try (CSVReader reader = new CSVReader(new FileReader(file))) {
            System.out.println("lecture...");
            //Read CSV line by line and use the string array as you want
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) //Verifying the read data here
                System.out.println(Arrays.toString(nextLine));
        } catch (IOException e) {
            System.out.println("echec de lecture");
            e.printStackTrace();
        }
    }

    public static int checkPassword(File file, String[] records) {
        try (CSVReader reader = new CSVReader(new FileReader(file))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                if (records[1].equals(nextLine[1])) {//good username
                    if (records[2].equals(nextLine[2]))//good password
                        return Integer.parseInt(nextLine[0]); //return id
                    else
                        return -1;//invalid password;
                }
            }
        } catch (IOException e) {
            System.out.println("echec de lecture");
            e.printStackTrace();
        }
        return 0;//username not found
    }

    public static int validateRecord(File file, String[] record){
    if(record[0].isEmpty() || record[1].isEmpty() )
        return 0; //empty entry
    int id = 0;
    try (CSVReader reader = new CSVReader(new FileReader(file))) {
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            id  = Integer.parseInt(nextLine[0]);
            if (nextLine[1].equals(record[1]))
                return -1;//username taken
        }
        id+=1;
    } catch (IOException e) {
        id = -2;
        System.out.println("echec de lecture");
        e.printStackTrace();
    }
    return id; // value >0, account valid
    }
}
