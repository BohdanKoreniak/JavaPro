package pro.lesson2.managers;

import com.bohdan.java.pro.lesson2.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Bohdan on 17.12.2016.
 */
public class PersonManager
{
    private List<Person> listPerson = new ArrayList<>();

    public void addPerson()
    {
        Person person = new Person();

        ConsoleManager.printText("Enter person`s personal data, please");

        ConsoleManager.printText("Enter person`s name");
        person.setName(ConsoleManager.readString());

        ConsoleManager.printText("Enter person`s surname");
        person.setSurname(ConsoleManager.readString());

        ConsoleManager.printText("Enter person`s age");
        person.setAge(ConsoleManager.readInt());

        ConsoleManager.printText("Enter person`s birthday date");
        person.setDateBirthday(ConsoleManager.readDate());

        listPerson.add(person);
    }

    public void printPersons()
    {
        for (Person person : listPerson)
        {
            ConsoleManager.printText(person.toString());
        }
    }

    public void saveListPerson()
    {
        try
        {
            ConsoleManager.printText("Enter destination file name for saving persons");
            FileManager.saveObject(listPerson, ConsoleManager.readString());
        }
        catch (IOException e)
        {
            ConsoleManager.printText("Error while saving person`s list");
        }
    }

    public void readListPerson()
    {
        try
        {
            ConsoleManager.printText("Enter source file name for retrieving persons");
            Object object = FileManager.readObject(ConsoleManager.readString());

            if (object.getClass() == listPerson.getClass())
            {
                listPerson = (ArrayList<Person>) object;
            }
        }
        catch (ClassNotFoundException | IOException e)
        {
            ConsoleManager.printText("Error while reading person`s list");
        }
    }

    public void searchPersonBySurname()
    {
        ConsoleManager.printText("Enter sought person`s surname");
        Person person = new Person(ConsoleManager.readString());

        int personIndex = Collections.binarySearch(listPerson, person);

        Collections.sort(listPerson);

        if (personIndex >= 0)
        {
            ConsoleManager.printText(listPerson.get(Collections.binarySearch(listPerson, person)).toString());
        }
        else
        {
            ConsoleManager.printText("Person was not found");
        }
    }

    public void run()
    {
        labelWhileMain:
        while (true)
        {
            ConsoleManager.printText("Enter command\n" +
                    "1 - to add one person into list\n" +
                    "2 - for showing all persons in the list\n" +
                    "3 - for saving list into the file\n" +
                    "4 - for reading all persons from the file\n" +
                    "5 - for searching person by surname\n" +
                    "0 - to exit");

            int commandId = ConsoleManager.readInt();

            switch (commandId)
            {
                case 1:
                {
                    addPerson();
                    break;
                }
                case 2:
                {
                    printPersons();
                    break;
                }
                case 3:
                {
                    saveListPerson();
                    break;
                }
                case 4:
                {
                    readListPerson();
                    break;
                }
                case 5:
                {
                    searchPersonBySurname();
                    break;
                }
                case 0:
                {
                    break labelWhileMain;
                }
            }
        }
    }
}
