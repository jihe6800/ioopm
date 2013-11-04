/** The class Person contains three Strings, one for first name, one for last name and one for
 *  what the person is working as. It also contains a int which contains the age of the Person.
 */

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String workingAs;

    public Person(String firstName,  String lastName, int age){
	this(firstName, lastName, age, "Employment Services");
    }

    public Person(String firstName,  String lastName, int age, String workingAs){
	this.firstName = firstName;
	this.lastName = lastName;
	this.age = age;
	this.workingAs = workingAs;
    }

    /** Sets the current age of the person.
     *
     * @param age The age which the current age will be updated with.
     */

    public void setAge(int age) {
	this.age = age;
    }

    /** Prints firstName, lastName, age and wokringAs to the terminal.
     */

    public void print(){
	System.out.println("First name: " + firstName);
	System.out.println("Last name: " + lastName);
	System.out.println("Age: " + age);
	System.out.println("Working as: " + workingAs);
    }

    /** Prints workingHours to the terminal.
     */

    public void workingHours() {
	System.out.println("Working 08.00 - 17.00");

    }
}