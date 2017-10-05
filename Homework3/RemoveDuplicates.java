import java.util.ArrayList;

public class RemoveDuplicates<E>{
	public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
		ArrayList<E> ret = new ArrayList<E>();
		for(E element : list){
			if(ret.isEmpty() || ret.indexOf(element) == -1){
				ret.add(element);
			}
		}
		return ret;
	}	
}