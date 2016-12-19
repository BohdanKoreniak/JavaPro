package com.bohdan.java.pro.lesson1.task2.managers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;

/**
 * Created by Bohdan on 17.12.2016.
 */
public class ConsoleManager
{
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void printText(String text)
    {
        System.out.println(text);
    }

    public static String readString()
    {
        try
        {
            return bufferedReader.readLine();
        }
        catch (IOException e)
        {
            printText("Enter correct data");
            return readString();
        }
    }

    public static Integer readInt()
    {
        try
        {
            return Integer.parseInt(bufferedReader.readLine());
        }
        catch (IOException | NumberFormatException e)
        {
            printText("Enter correct data");
            return readInt();
        }
    }

    public static LocalDate readDate()
    {
        printText("Enter date in format 'dd.mm.yy'");
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        try
        {
            return LocalDate.parse(readString(), formatter);
        }
        catch (DateTimeParseException e)
        {
            return readDate();
        }
    }
}
