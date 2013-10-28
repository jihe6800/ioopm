public class Main {
    public static void main(String[] args) {
	FiveDices d = new FiveDices();
	d.roll();
	System.out.println(d.toString());

	d.saveFirst();
	d.saveThird();
	d.roll();
	System.out.println(d.toString());
    }
}