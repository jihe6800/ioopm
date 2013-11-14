public class Person {
    private int day;
    private int month;
    private int year;
    private int lastFour[];

    public Person(int year, int month, int day, int lastFour[]) {
	this.day = day;
	this.month = month;
	this.year = year;
	this.lastFour = lastFour;
    }

    public int[] getLastFourCopy() {
	return lastFour.clone();
    }

    public int[] getLastFour() {
	return lastFour;
    }

    public String getBirthOfDate() {
	return this.year + "-" + this.month + "-" + this.day;
    }


}