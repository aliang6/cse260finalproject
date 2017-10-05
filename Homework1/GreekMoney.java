/*
	Andy Liang
	111008856
	CSE260/261
	Homework #1
*/

public class GreekMoney{
	public static int howManyOboloi(int talents, int minae, int drachmae, int oboloi){
		int total;
		total = talents * 60 + minae;
		total = total * 70 + drachmae;
		total = total * 6 + oboloi;
		return total;
	}

	/*public static void main(String[] args){
		System.out.println(howManyOboloi(2, 32, 59, 3));
	}*/
}