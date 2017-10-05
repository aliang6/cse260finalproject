public class GenericStackExtendsArrayList<E> extends java.util.ArrayList<E> {

	public GenericStackExtendsArrayList(){
		super();
	}

	public int getSize() {
		return super.size();
	}
	public E peek() {
		return super.get(getSize() - 1);
	}
	public void push(E o) {
		super.add(o);
	}
	public E pop() {
		return super.remove(getSize() - 1);
	}
	public boolean isEmpty() {
		return super.isEmpty();
	}
}