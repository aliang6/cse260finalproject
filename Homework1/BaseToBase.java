/*
	Andy Liang
	111008856
	CSE260/261
	Homework #1
*/

public class BaseToBase{

	public static String base2base(String n, int b1, int b2){
		String ret = "";
		int base10 = convertToBase10(n, b1);
		if(base10 == -1){
			System.out.println("String contains an invalid sybmol.");
		}
		else{
			ret = convertFromBase10(base10, b2);
		}

		return ret;
	}

	public static int convertToBase10(String n, int b1){
		int base10 = 0;
		for(int i = 0; i < n.length(); i++){
			char x = n.charAt(i);
			int numValue = Character.getNumericValue(x);
			if(numValue >= 0 && numValue < 36){
				base10 = base10 * b1 + numValue;
			}
			else{
				return -1;
			}
		}
		return base10;
	}

	public static String convertFromBase10(int base10Value, int b2){
		String ret = "";
		while(base10Value != 0){
			ret = Character.toString(intToASCII(base10Value%b2)) + ret;
			base10Value /= b2;
		}
		return ret;
	}

	public static char intToASCII(int x){
		if(x >= 0 && x < 10){
			x += 48;
		}
		else{
			x += 55;
		}
		return (char)x;
	}

	/*public static void main(String[] args){
		System.out.println(base2base("12345", 6, 8));
		//Return: ‘‘3511’’

		System.out.println(base2base("STONY", 36, 19));
		//Return: ‘‘10A998F

		System.out.println(base2base("832K1", 26, 15));
		//Return: ‘‘4D45A9’’
	}*/

}