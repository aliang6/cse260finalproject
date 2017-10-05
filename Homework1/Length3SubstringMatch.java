/*
	Andy Liang
	111008856
	CSE260/261
	Homework #1
*/

public class Length3SubstringMatch{

	public static int stringMatch3(String a, String b){
		int matches = 0;
		if(a.length() < 3 || b.length() < 3){
			return matches;
		}
		for(int i = 0; i <= a.length() - 3; i++){
			String substringOne = a.substring(i, i + 3);
			String substringTwo = b.substring(i, i + 3);
			if(substringOne.equals(substringTwo)){
				matches++;
			}
		}
		return matches;
	}

	/*public static void main(String[] args){
		System.out.println(stringMatch3("sdgndsgyudsaiufb", "sadufygyudsafbnsaicgaf"));
		System.out.println(stringMatch3("banana", "bananas"));
	}*/
}