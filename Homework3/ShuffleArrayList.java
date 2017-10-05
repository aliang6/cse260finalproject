import java.util.ArrayList;

public class ShuffleArrayList{
	public static <E> void shuffle(ArrayList<E> list){
		for(int i = 0; i < list.size(); i++){
			int random = (int)(Math.random()*(list.size() - 1));
			E temp = list.get(random);
			list.set(random, list.get(i));
			list.set(i, temp);
		}
	}
} 