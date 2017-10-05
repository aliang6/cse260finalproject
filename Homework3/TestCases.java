import java.util.ArrayList;
import java.util.Scanner;

public class TestCases{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		GenericStackExtendsArrayList stack1 = new GenericStackExtendsArrayList();
		GenericStackExtendsArrayList stack2 = new GenericStackExtendsArrayList();
		System.out.println("Enter five numbers");
		for(int i = 0; i < 5; i++){
			stack1.push(scanner.nextInt());
		}
		while(!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}
		System.out.println(stack2.toString());


		/*GenericStackWithArray<Integer> stack1 = new GenericStackWithArray();
		System.out.println(stack1.getSize());
		stack1.push(8);
		System.out.println(stack1.getSize());
		stack1.push(10);
		System.out.println(stack1.getSize());
		stack1.push(14);
		stack1.push(16);
		stack1.push(2313);
		System.out.println(stack1.toString());
		System.out.println("Size is " + stack1.getSize());
		while(!stack1.isEmpty()){
			System.out.println(stack1.pop());
			System.out.println(stack1.isEmpty());
		}
		System.out.println(stack1.pop());
		System.out.println(stack1.peek());

		ArrayList<Integer> stack2 = new ArrayList();
		for(int i = 0; i < 20; i++){
			stack2.add(i);
		}
		stack2.add(2);
		stack2.add(13);
		stack2.add(2);
		stack2.add(2);
		stack2.add(25);
		stack2.add(2);
		stack2.add(5);
		stack2.add(2);
		stack2.add(3);
		stack2.add(7);
		stack2.add(1);
		System.out.println(stack2.toString());
		RemoveDuplicates remDup = new RemoveDuplicates();
		stack2 = remDup.removeDuplicates(stack2);
		System.out.println(stack2.toString());

		ShuffleArrayList shuffle = new ShuffleArrayList();
		shuffle.shuffle(stack2);
		System.out.print(stack2);

		Integer[] arr = new Integer[25];
		for(int i = 0; i < 25; i++){
			arr[i] = i;
		}
		Max max = new Max();
		System.out.println("Array Max is " + max.max(arr));

		Integer[][] matrix = new Integer[25][25];
		for(int i = 0; i < 25; i++){
			for(int j = 0; j < 25; j++){
				matrix[i][j] = i * j;
			}
		}
		MaxMatrix maxMatrix = new MaxMatrix();
		System.out.println("Matrix max is " + maxMatrix.max(matrix));

		System.out.println("Linear Search");
		LinearSearch linSearch = new LinearSearch();
		for(int i = 0; i < 27; i++){
			System.out.println(i + " is found at index " + linSearch.linearSearch(arr, i));
		}

		System.out.println("Binary Search");
		BinarySearch binSearch = new BinarySearch();
		for(int i = 0; i < 27; i++){
			System.out.println(i + " is found at index " + binSearch.binarySearch(arr, i));
		}*/
	}
}