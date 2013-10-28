public class ListDriver {
    public static void main(String[] args){
	List l = new List();
	String a = "Hej";
	String b = "Hopp";
	System.out.println("Listan: " + l.toString());
	l.prepend(a);
	l.prepend(b);
	l.prepend("Tjena");
	System.out.println("Listan: " + l.toString());
	System.out.println("Does list contain " + a +"? ... " + l.contains(a));
	System.out.println("Does list contain " + a +"? ... " + l.contains("Yo"));

	if(l.toString().equals("[Tjena, Hopp, Hej]")){
	    System.out.println("SUCCESS");
	} else {
	    System.out.println("FAILURE");
	}

	if(l.contains(a) == true){
	    System.out.println("SUCCESS");
	} else {
	    System.out.println("FAILURE");
	}

	if(l.contains("Yo") == false){
	    System.out.println("SUCCESS");
	} else {
	    System.out.println("FAILURE");
	}

	
    }
}