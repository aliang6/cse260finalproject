/*
	Andy Liang
	111008856
	CSE260/261
	Homework #1
*/

public class RunLengthEncoding{

	public static String encode(String message, char delimiter){
		String encoded = "";
		int i = 0;
		int counter = 1;
		while(i + counter <= message.length()){
			char x = message.charAt(i);
			if(i + counter < message.length() && x == message.charAt(i + counter)){
				counter++;
			}
			else{
				i += counter;
				if(counter > 3){
					encoded += delimiter + Character.toString(x) + counter;
				}
				else{
					while(counter > 0){
						encoded += Character.toString(x);
						counter--;
					}
				}
				counter = 1;
			}
		}
		return encoded;
	}

	/*public static void main(String[] args){
		System.out.println(encode("XYZAAAAAAGGTCCCCCCTTTAAAAAAAAAAAAAAKK", '*'));
		System.out.println(encode("KKKKKKKKKKKKKBCCDDDDDDDDDDDDDDDKKKKKMNUUUGGGGG", '$'));

	}*/
}