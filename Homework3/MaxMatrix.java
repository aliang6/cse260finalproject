public class MaxMatrix<E>{
	public static <E extends Comparable<E>> E max(E[][] list){
		if(list.length == 0 || list[0].length == 0){
			return null;
		}
		boolean nullMatrix = true;
		for(E[] array : list){
			for(E element : array){
				if(element != null){
					nullMatrix = false;
					break;
				}
			}
		}

		if(nullMatrix){
			return null;
		}

		E max = list[0][0];
		for(E[] array : list){
			for(E element : array){
				if(element.compareTo(max) > 0){
					max = element;
				}
			}
		}
		return max;
	}
}