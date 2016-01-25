package com.courses.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionsTest {

    public static void main(String[] args) {
	    ExceptionsTest test = new ExceptionsTest();

//        test.readFile();

        String[] array = new String[5];
        test.getElement(array, 4);

        try {
            test.chaining();
        } catch (CustomException e) {
            System.out.println(e.getCause().getCause());
        }

        //test.divideByZero();

        //test.recursion(3);
    }

    //checked exception example
    public void readFile() {
        File file = new File("d:\\34.txt");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            System.out.println("In file not found");
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void readFileWithResources() {
        File file = new File("d:\\34.txt");
        try (FileReader fileReader = new FileReader(file)) {
            fileReader.read();
        } catch (IOException e) {
            System.out.println("In file not found");
        }
    }

    public void chaining() throws CustomException {
        File file = new File("d:\\34.txt");
        try (FileReader fileReader = new FileReader(file)) {
            fileReader.read();
        } catch (IOException e) {
            try {
                throw new InsufficientMoney("Not enough money", e);
            } catch (InsufficientMoney im) {
                throw new CustomException("Custom exception", im);
            }
        }
    }

    //unchecked exception example
    public void getElement(String[] array, int index) {
        String value = array[index];
    }

    //unchecked exception example
    public void divideByZero() {
        int k = 5;
        k = k / 0;
    }

    //error example
    public void recursion(int value) {
        while (value < 5) {
            recursion(value);
        }
    }

    //suppressed exception example
    /*static {
        int k = 5 / 0;
    }*/
}
