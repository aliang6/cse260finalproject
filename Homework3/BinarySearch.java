public class BinarySearch<E>{
	public static<E extends Comparable<E>> int binarySearch(E[] list, E key){
		int x = (int)(list.length / 2), start = 0, end = list.length - 1; // Pointers

		while(start <= end){
			if(list[x].compareTo(key) == 0){
				return x;
			}
			if(list[x].compareTo(key) < 0){
				start = x + 1;
			}
			else{
				end = x - 1;
			}
			x = (int)((start + end)/2);
		}
		return -1;
	}
}