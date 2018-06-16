package joker.ds;

public class Stack {
	Element<Integer> top;

	public Stack() {
	}

	public void push(Integer data) {
		if (null == top) {
			top = new Element<Integer>(data, null);
		} else {
			Element<Integer> e = new Element<Integer>(data, top);
			top = e;
		}
	}

	public Integer peek() {
		if (null != top) {
			return top.getData();
		}
		throw new RuntimeException("No data.");
	}

	public void print() {
		Element<Integer> temp;
		temp = top;
		while (null != temp) {
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
	}

	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(12);
		s.push(11);
		s.push(14);
		s.push(123);
		System.out.println("peek :" + s.peek());

		s.print();
		s.print();
	}

}

class Element<T> {
	T data;
	Element<T> next;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Element<T> getNext() {
		return next;
	}

	public void setNext(Element<T> next) {
		this.next = next;
	}

	public Element(T data, Element<T> next) {
		super();
		this.data = data;
		this.next = next;
	}

}
