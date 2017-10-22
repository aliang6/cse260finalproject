import java.util.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.regex.Pattern;

public class SyntaxHighlighting{
	public static void main(String[] args){
		String[] one = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "continue", "default", 
		"do", "double", "else", "enum", "extends", "final", "finally", "float", "for", "if", "implements", "import", "instanceof", 
		"int", "interface", "long", "native", "new", "package", "private", "protected", "public", "return", "short", "static", 
		"strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "voltaile", "while"};
		HashSet<String> keywords = new HashSet<String>(Arrays.asList(one));
		File input = new File(args[0]);
		File output = new File(args[1]);
		Scanner sc;
		try{
			sc = new Scanner(input);
		} catch(FileNotFoundException e){
			System.out.println("Invalid input file name");
			return;
		}
		try{
			FileReader source = new FileReader(input);
			FileWriter html = new FileWriter(output);
			html.write("<html>\n<head>\n\t<title>" + args[1] + "</title>\n</head>\n<body>\n<p>");
			String next = "";
			boolean literal = false;
			boolean comment = false;
			boolean string = false;

			while(sc.hasNext()){
				next = sc.next();
				Pattern p;

				if(keywords.contains(next) && !string && !comment){
					html.write(" <span style=\"color:Navy;font-weight:bold\">" + next + "</span> ");
				}
				else if(next.length() > 3 && (next.charAt(next.length() - 1) == ']' || next.charAt(next.length() - 2) == ']')){
					int startOfArr = -1;
					for(int i = 0; i < next.length(); i++){
						if(next.charAt(i) == '['){
							startOfArr = i;
							break;
						}
					}
					if(startOfArr != -1){
						if(keywords.contains(next.substring(0, startOfArr)) && !string){
							html.write(" <span style=\"color:Navy;font-weight:bold\">" + next.substring(0, startOfArr) + "</span>" + next.substring(startOfArr, next.length()));
						}
					}
				}
				else if(next.equals("//") || (next.length() >= 2 && next.substring(0,2).equals("//")) && !string){
					html.write(" <span style=\"color:green\">" + next + sc.nextLine() + "</span></br>");
				}
				else{
					if(next.length() == 1){
						if(next.equals("\"") && string && !comment){
							html.write(next + "</span> ");
							string = false;
						}
						else if(next.equals("\"") && !string && !comment){
							html.write(" <span style=\"color:blue\">" + next + " ");
							string = true;
						}
						else{
							html.write(" " + next + " ");
						}
					}
					else if(next.length() == 2){
						if(next.equals("/*")){
							html.write(" <span style=\"color:green\">" + next + " ");
							comment = true;
						}
						else if(next.equals("*/")){
							html.write(" " + next + "</span> ");
							comment = false;
						}
						else if(next.charAt(0) == '\"' && string && !comment){
							html.write(" " + next + "</span> ");
							string = false;
						}
						else if(next.charAt(0) == '\"' && string && !comment){
							html.write(" " + next + "</span> ");
							string = false;
						}
						else if(next.charAt(1) == '\"' && !string && !comment){
							html.write(" <span style=\"color:blue\">" + next);
							string = true;
						}
						else if(next.charAt(1) == '\"' && !string && !comment){
							html.write(" <span style=\"color:blue\">" + next);
							string = true;
						}
						else{
							html.write(" " + next + " ");
						}
					}
					else{
						if(next.length() >= 4 && next.substring(0, 2).equals("/*") && next.substring(next.length() - 2, next.length()).equals("*/")){
							html.write(" <span style=\"color:green\">" + next + "</span> ");
						}
						else if(next.length() >= 3 && next.substring(0, 2).equals("/*")){
							html.write(" <span style=\"color:green\">" + next + " ");
							comment = true;
						}
						else if(next.length() >= 3 && next.substring(next.length() - 2, next.length()).equals("*/")){
							html.write(" " + next + "</span> ");
							comment = false;
						}
						else if((next.charAt(0) == '\"' || next.charAt(1) == '\"' || (next.length() > 3 && next.charAt(2) == '\"')) 
							&& (next.charAt(next.length() - 1) == '\"' || next.charAt(next.length() - 2) == '\"' || (next.length() > 3 && next.charAt(next.length() - 3) == '\"'))){
							html.write(" <span style=\"color:blue\">" + next + "</span> ");
						}
						else if(next.charAt(0) == '\"' || next.charAt(1) == '\"'){
							html.write(" <span style=\"color:blue\">" + next + " ");
							string = true;
						}
						else if(next.charAt(next.length() - 1) == '\"' || next.charAt(next.length() - 2) == '\"'){
							html.write(" " + next + "</span> ");
							string = false;
						}
						else if(next.length() >= 4){
							if(next.substring(0,3).equals("for")){
								html.write(" <span style=\"color:Navy;font-weight:bold\">" + next.substring(0, 3) + "</span>");
								if(next.length() >= 7 && next.substring(4, 7).equals("int")){
									html.write("(<span style=\"color:Navy;font-weight:bold\">" + next.substring(4, next.length()) + "</span>");
								}
								else{
									html.write(" " + next.substring(3, next.length()) + " ");
								}
							}
							else if(next.length() >= 6 && next.substring(0, 5).equals("while")){
								html.write(" <span style=\"color:Navy;font-weight:bold\">" + next.substring(0, 5) + "</span>");
								if(next.length() >= 9 && next.substring(6, 9).equals("int")){
									html.write("(<span style=\"color:Navy;font-weight:bold\">" + next.substring(6, next.length()) + "</span>");
								}
								else{
									html.write(" " + next.substring(5, next.length()) + " ");
								}
							}
							else{
								html.write(" " + next + " ");
							}
						}
						else{
							html.write(" " + next + " ");
						}
					}
				}
			}

			html.write("</p></body>\n</html>");
			html.flush();
		} catch(IOException e){
			System.out.println("Invalid file names");
			return;
		}
		/*HashSet<String> keywords = new HashSet<String>(one);
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a java file name: ");
		File file = new File(sc.next());*/

	}
}