public class Driver {

    public static void main(String args[]) {

	Person p = new Person ("Jimmy", "Helmersson", 21);
	Teacher t = new Teacher ("Gunnar", "Berg", 62, "Teacher", "Math", "Uppsala Universitet");
	DJ d = new DJ ("Sten", "Rik", 24, "DJ", "House");

	p.print();
	System.out.println("");
	t.print();
	t.workingHours();
	System.out.println("");
	d.print();
	d.workingHours();
	System.out.println("");

	Person p2 = new Person("Moa","Fahlström", 21);
	p2.workingHours();
	p2 = new DJ("Moa", "Fahlström", 21, "DJ", "Funky House");
	p2.workingHours();
	System.out.println("");

	p.setAge(22);
	p.print();
    }


}