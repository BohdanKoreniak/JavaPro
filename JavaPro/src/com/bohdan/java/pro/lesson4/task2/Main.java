package com.bohdan.java.pro.lesson4.task2;

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

        System.out.println(treeMap.find(4));
        System.out.println(treeMap.find(101));

        System.out.println(treeMap.get(9));
        System.out.println(treeMap.get(909));

        System.out.println(treeMap.remove(5));
        System.out.println(treeMap.find(5));
    }
}
