/** DJ contains everything a Person contains and also a musicStyle, as a string.
 */
public class DJ extends Person{
    private String musicStyle;

    public DJ(String firstName, String lastName, int age, String workingAs, String musicStyle){
	super(firstName, lastName, age, workingAs);
	this.musicStyle = musicStyle;
    }

    /** Prints firstName, lastName, age, workingAs, musicStyle to the terminal.
     */

    public void print() {
	super.print();
	System.out.println("Music Style: " + musicStyle);
    }

    /** Prints workingHours to the terminal.
     */

    public void workingHours() {
	System.out.println("Working 22.00 - 04.00");
    }
}