/**
 * A subclass of Person that represents a Student
 *
 * Created for Menlo School CS2
 *
 * @author: Ms. Namasivayam & Mr. Blick
 * @version: 2022-2023
 */

public class Student extends Person
{
    // TODO: Modify and complete this class

    int grade;

    public Student(String firstName, String lastName, String phoneNumber, int grade)
    {
        super(firstName, lastName, phoneNumber);
        this.grade = grade;
    }


}
