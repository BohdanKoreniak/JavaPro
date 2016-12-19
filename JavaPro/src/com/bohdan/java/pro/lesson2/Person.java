package com.bohdan.java.pro.lesson2;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by Bohdan on 17.12.2016.
 */
public class Person implements Serializable, Comparable<Person>
{
    private static final long serialVersionUID = 9132901243174411809L;

    private String name;
    private String surname;

    private int age;

    private LocalDate dateBirthday;

    public Person()
    {
    }

    public Person(String name, String surname, int age, LocalDate dateBirthday)
    {
        this.name = name;
        this.surname = surname;
        this.age = age;

        this.dateBirthday = dateBirthday;
    }

    public Person(String surname)
    {
        this.surname = surname;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public LocalDate getDateBirthday()
    {
        return dateBirthday;
    }

    public void setDateBirthday(LocalDate dateBirthday)
    {
        this.dateBirthday = dateBirthday;
    }

    @Override
    public int compareTo(Person person)
    {
        if (surname == null)
        {
            return 0;
        }
        return surname.compareTo(person.getSurname());
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }

        if (getClass() != obj.getClass())
        {
            return false;
        }

        Person person = (Person) obj;

        if (!name.equals(person.name))
        {
            return false;
        }

        if (!surname.equals(person.getSurname()))
        {
            return false;
        }

        if (age != person.getAge())
        {
            return false;
        }

        if (!dateBirthday.equals(person.getDateBirthday()))
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        return name.hashCode() * surname.hashCode() * age * dateBirthday.hashCode() * 31;
    }

    @Override
    public String toString()
    {
        return name + "\t" + surname + "\t" + age + "\t" + dateBirthday;
    }
}
