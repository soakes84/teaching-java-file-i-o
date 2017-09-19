package com.theironyard;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
	// write your code here
//
//        File myFile = new File("demoFile.txt");                   **** This first created new file ******
//
//        try {
//            FileWriter newFile = new FileWriter(myFile);          **** Here is where we wrote to the file *****
//            newFile.write("Hello, this is a file that is being created!\n");  **** \n means new line ****
//            newFile.write("-signed Spencer\n");
//            newFile.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        String[] fileContents = getFileContents("demoFile.txt");   //Now we are getting the contents of the
                                                                            //file we created
        for (String line : fileContents) {
            System.out.println(line);
        }


    }

    public static String[] getFileContents (String fileName) {
        File file = new File (fileName);
        try {
            Scanner fileScanner = new Scanner(file);
            List<String> fileContents = new ArrayList<>();
            while (fileScanner.hasNext()) {
                fileContents.add(fileScanner.nextLine());
            }
            return fileContents.toArray(new String[0]); //Converts the list to an array
        }                                               //Since this time we are asking for data back from the file
                                                        //We have to specify what to do if it isn't found
        catch (FileNotFoundException ex) {
            System.out.println("Could not find file *" + fileName + "*");
            ex.printStackTrace();
            return null;
        }
    }
}
