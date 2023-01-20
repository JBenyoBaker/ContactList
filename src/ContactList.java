import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * A class that stores subclasses of Person as a contact list.
 * The user is presented with a menu of options and may add, sort,
 * search, or list the contacts.
 *
 * Created for Menlo School CS2
 *
 * @author: Ms. Namasivayam & Mr. Blick
 * @version: 2022-2023
 */

public class ContactList
{
    public static final int FIRST_NAME = 0;
    public static final int LAST_NAME = 1;
    public static final int PHONE_NUMBER = 2;
    // TODO: Create your array contacts
    public ArrayList<Person> contacts;

    // TODO: Write a Constructor
    public ContactList()
    {
         contacts = new ArrayList<>();
    }

    public void printMenuOptions() {
        System.out.println("Menu: ");
        System.out.println("1. Add Contact");
        System.out.println("2. List All Contacts By First Name");
        System.out.println("3. List All Contacts By Last Name");
        System.out.println("4. List All Contacts By Phone Number");
        System.out.println("5. List All Students");
        System.out.println("6. Search By First Name");
        System.out.println("7. Search By Last Name");
        System.out.println("8. Search by Phone Number");
        System.out.println("0. Exit");
    }

    /**
     * Asks user for input to create and add a new Person
     * to the contact list
     */
    public void addContact(Person p) {
        // TODO: Complete the addContact method
        contacts.add(p);
    }

    /**
     * Loops through and prints all contacts
     */
    public void printContacts() {
        // TODO: Complete the printContacts method
        for (Person p : contacts)
        {
            System.out.println(p);
        }
    }

    /**
     * Bubble sorts the contacts in the list by firstName,
     * lastName, or phoneNumber
     * @param sortBy: 0=firstName, 1=lastName, 2=phoneNumber
     */
    public void sort(int sortBy)
    {
        // TODO: Complete the sort method
        if (sortBy == FIRST_NAME)
        {
            for (int i = 0; i < contacts.size() - 1; i++)
            {
                for (int j = i + 1; j < contacts.size() - 1; j++)
                {
                    if (contacts.get(i).getFirstName().compareTo(contacts.get(j).getFirstName()) == 1)
                    {
                        Collections.swap(contacts, i, j);
                    }
                }
            }
        }
        else if (sortBy == LAST_NAME)
        {
            for (int i = 0; i < contacts.size() - 1; i++)
            {
                for (int j = i + 1; j < contacts.size(); j++)
                {
                    if (contacts.get(i).getLastName().compareTo(contacts.get(j).getLastName()) == 1)
                    {
                        Collections.swap(contacts, i, j);
                    }
                }
            }
        }
        else if (sortBy == PHONE_NUMBER)
        {
            for (int i = 0; i < contacts.size() - 1; i++)
            {
                for (int j = i + 1; j < contacts.size(); j++)
                {
                    if (contacts.get(i).getPhoneNumber().compareTo(contacts.get(j).getPhoneNumber()) == 1)
                    {
                        Collections.swap(contacts, i, j);
                    }
                }
            }
        }
    }

    // TODO: Write searchByFirstName
    //search algorithim which cuts potential list in half each iteration
    public Person searchByFirstName(String name)
    {
        for (Person p : contacts)
        {
            if (p.getFirstName().equals(name))
            {
                return p;
            }
        }
        return null;
    }

    // TODO: Write searchByLastName
    public Person searchByLastName(String name)
    {
        for (Person p : contacts)
        {
            if (p.getLastName().equals(name))
            {
                return p;
            }
        }
        return null;
    }

    // TODO: Write searchByPhoneNumber
    public Person searchByPhoneNumber(String number)
    {
        for (Person p : contacts)
        {
            if (p.getPhoneNumber().equals(number))
            {
                return p;
            }
        }
        return null;
    }
    /**
     * Lists just the Student objects in the Contact List
     */
    public void listStudents()
    {
        // TODO: Complete the listStudents method
        for (Person p : contacts)
        {
            if (p instanceof Student)
            {
                System.out.println(p);
            }
        }
    }

    /**
     * Loops providing menu options to the user
     * until the user exits
     */
    public void run() {
        while (true)
        {
            System.out.println("Welcome to your Contacts List");
            System.out.println("Please pick from the following menu options");
            printMenuOptions();

            // TODO: Complete the run method
            Scanner reader = new Scanner(System.in);
            int choice = reader.nextInt();
            if (choice == 1)
            {
                System.out.println("Enter a first name: ");
                reader.nextLine();
                String firstName = reader.nextLine();
                System.out.println("Enter a last name: ");
                String lastName = reader.nextLine();
                System.out.println("Enter a phone number: ");
                String phoneNumber = reader.nextLine();
                contacts.add(new Person(firstName, lastName, phoneNumber));
            }
            else if (choice == 2)
            {
                sort(FIRST_NAME);
                printContacts();
            }
            else if (choice == 3)
            {
                sort(LAST_NAME);
                printContacts();
            }
            else if (choice == 4)
            {
                sort(PHONE_NUMBER);
                printContacts();
            }
            else if (choice == 5)
            {
                listStudents();
            }
            else if (choice == 6)
            {
                System.out.println("Enter a name: ");
                reader.nextLine();
                String name = reader.nextLine();
                if (searchByFirstName(name) == null)
                {
                    System.out.println("name is not in the list");
                }
                else
                {
                    System.out.println(searchByFirstName(name));
                }
            }
            else if (choice == 7)
            {
                System.out.println("Enter a name: ");
                reader.nextLine();
                String name = reader.nextLine();
                if (searchByLastName(name) == null)
                {
                    System.out.println("name is not in the list");
                }
                else
                {
                    System.out.println(searchByLastName(name));
                }
            }
            else if (choice == 8)
            {
                System.out.println("Enter a number: ");
                reader.nextLine();
                String number = reader.nextLine();
                if (searchByPhoneNumber(number) == null)
                {
                    System.out.println("number is not in the list");
                }
                else
                {
                    System.out.println(searchByPhoneNumber(number));
                }
            }
            else if (choice == 0)
            {
                return;
            }
        }
    }


    public static void main(String[] args)
    {
        ContactList cl = new ContactList();
        cl.run();
    }
}
