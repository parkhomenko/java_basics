package com.java.basics.annotations;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationsTest {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {

        //Creating an instance of the class Printer
        Class printerClass = Class.forName("com.java.basics.annotations.Printer");
        Printer printer = (Printer) printerClass.newInstance();

        //Invocation of a method using the paramters inside annotation
        PrinterOptions annotation = printer.getClass().getAnnotation(PrinterOptions.class);
        Method method = printer.getClass().getMethod(annotation.numberToPrint(), int.class);
        method.invoke(printer, annotation.numberOfTimes());

        //The list of methods in the class Printer
        Method[] methods = Printer.class.getMethods();
        for (Method meth : methods) {
            System.out.println(meth.getName());
        }

        //Properties of the class Printer
        Class clazz = Printer.class;
        Printer clazz_inst = (Printer) clazz.newInstance();
        System.out.println(clazz.getName());
        System.out.println(clazz.getSimpleName());
        System.out.println(clazz.getAnnotations()[0]);

        //Geting all the declared fields of the Printer class
        Field[] fields = clazz_inst.getClass().getDeclaredFields();
        System.out.println(fields[0]);

        //Setting the field access to true for private field
        //will give us a possibility to get its value
        fields[0].setAccessible(true);
        System.out.println(fields[0].get(clazz_inst));

        //Getting all declared constructors of the Printer class
        System.out.println(clazz.getDeclaredConstructors()[0]);

    }
}

@PrinterOptions(numberToPrint = "printTwoNumber", numberOfTimes = 5)
class Printer {

    private int age = 5;

    Printer() {
        System.out.println("something");
    }

    Printer(int k) {
        System.out.println("something");
    }

    public void printOneNumber(int times) {
        for (int i = 0; i < times; i++)
            System.out.println("1");
    }

    public void printTwoNumber(int times) {
        for (int i = 0; i < times; i++)
            System.out.println("2");
    }
}
