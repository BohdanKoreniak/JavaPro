package com.bohdan.java.pro.lesson4.task1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Bohdan on 18.12.2016.
 */
public class LinkedListVsArrayList
{
    public static void main(String[] args)
    {
        List<Integer> arrayListInts = new ArrayList<>();
        List<Integer> linkedListInts = new LinkedList<>();


        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10_001; i++)
        {
            arrayListInts.add((int) (Math.random() * 10_000));
        }
        long endTime = System.currentTimeMillis();

        System.out.println(new StringBuilder().append("\nAdding elements array list (sequence): ").append(endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10_001; i++)
        {
            linkedListInts.add((int) (Math.random() * 10_000));
        }
        endTime = System.currentTimeMillis();

        System.out.println(new StringBuilder().append("Adding elements linked list (sequence): ").append(endTime - startTime));


        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10_000; i++)
        {
            arrayListInts.add((int) (Math.random() * 10_000), (int) (Math.random() * 10_000));
        }
        endTime = System.currentTimeMillis();

        System.out.println(new StringBuilder().append("\nAdding elements array list (random index): ").append(endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10_000; i++)
        {
            linkedListInts.add((int) (Math.random() * 10_000), (int) (Math.random() * 10_000));
        }
        endTime = System.currentTimeMillis();

        System.out.println(new StringBuilder().append("Adding elements linked list (random index): ").append(endTime - startTime));


        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10_000; i++)
        {
            arrayListInts.remove((int) (Math.random() * 10_000));
        }
        endTime = System.currentTimeMillis();

        System.out.println(new StringBuilder().append("\nDeleting elements array list (random index): ").append(endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10_000; i++)
        {
            linkedListInts.remove((int) (Math.random() * 10_000));
        }
        endTime = System.currentTimeMillis();

        System.out.println(new StringBuilder().append("Deleting elements linked list (random index): ").append(endTime - startTime));
    }
}
