package com.bohdan.java.pro.lesson2.task2;

/**
 * Created by Bohdan on 18.12.2016.
 */
public class Main
{
    public static void main(String[] args)
    {
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        treeMap.add(18, "Thorin");
        treeMap.add(10, "Kili");
        treeMap.add(19, "Fili");
        treeMap.add(17, "Balin");
        treeMap.add(5, "Dwalin");
        treeMap.add(8, "Oin");
        treeMap.add(4, "Gloin");
        treeMap.add(2, "Dori");
        treeMap.add(7, "Nori");
        treeMap.add(9, "Ori");
        treeMap.add(0, "Bifur");
        treeMap.add(3, "Bofur");
        treeMap.add(23, "Bombur");

        treeMap.add(24, "John");
        treeMap.add(1, "John");
        treeMap.add(13, "John");
        treeMap.add(16, "John");
        treeMap.add(20, "John");

        System.out.println(treeMap.getNodes());
        System.out.println(treeMap.contains("John"));
    }
}
