package com.bohdan.java.pro.lesson1;

/**
 * Created by Bohdan on 17.12.2016.
 */
public class Main
{
    public static void main(String[] args)
    {
        User user = new User("user1", "user1", 2016);
        User user1 = new User("user1", "user1", 2015);
        User user2 = new User("user1", "user1", 2016);

        System.out.println(user.equals(user1));
        System.out.println(user.equals(user2));

        System.out.println(user.hashCode() == user1.hashCode());
        System.out.println(user.hashCode() == user2.hashCode());
    }
}
