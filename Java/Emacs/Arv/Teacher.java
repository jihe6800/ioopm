/** Teacher contains everything a Person contains and also a subject and workingAt, both
 *  as Strings.
 */

public class Teacher extends Person{
    private String subject;
    private String workingAt;

    public Teacher(String firstName, String lastName, int age, String workingAs, String subject, String workingAt) {
	super(firstName, lastName, age, workingAs);
	this.subject = subject;
	this.workingAt = workingAt;
    }

    /** Prints firstName, lastName, age, workingAs, workingAt and subject to the terminal.
     */
    public void print() {
	super.print();
	System.out.println("Working at: " + workingAt);
	System.out.println("Subject: " + subject);
    }


}