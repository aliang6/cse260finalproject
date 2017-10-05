public class Max<E>{
	public static <E extends Comparable<E>> E max(E[] list){
		if(list.length == 0){
			return null;
		}
		boolean nullArray = true;
		for(E element : list){
			if(element != null){
				nullArray = false;
				break;
			}
		}

		if(nullArray){
			return null;
		}

		E max = list[0];
		for(E element : list){
			if(element.compareTo(max) > 0){
				max = element;
			}
		}
		return max;
	}
}