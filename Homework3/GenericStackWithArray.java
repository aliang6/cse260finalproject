public class GenericStackWithArray<E>{
	private E[] list;
	private int pointer;

	public GenericStackWithArray(){
		list = (E[])(new Object[1]);
		pointer = 0;
	}

	public int getSize() {
		return pointer;
	}
	public E peek() {
		if(pointer == 0){
			return null;
		}
		return list[getSize() - 1];
	}
	public void push(E o) {
		if(pointer == list.length){
			E[] newList = (E[])(new Object[pointer*2]);
			System.arraycopy(list, 0, newList, 0, pointer);
			list = newList;
		}
		list[pointer++] = o;
		System.out.println(pointer);
	}
	public E pop() {
		if(getSize() == 0){
			return null;
		}
		E o = list[--pointer];
		list[pointer] = null;
		return o;
	}
	public boolean isEmpty() {
		return getSize() == 0;
	}
	@Override // Java annotation: also used at compile time to
	public String toString() { // detect override errors
		String ret = "stack: ";
		for(E element : list){
			if(element != null)
				ret += element.toString() + " ";
		}
		ret += "\n";
		return ret;
	}
}