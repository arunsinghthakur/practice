package joker.ds;

public class Queue<T> {

	int size = 0;
	int limit = 4;

	QElement<T> head;

	public void enqueue(T data) {
		if (isFull()) {
			throw new RuntimeException();
		}
		if (null == head) {
			head = new QElement<T>(data, null);
		} else {
			QElement<T> temp = head; // TODO
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(new QElement<T>(data, null));
			head = temp;
		}
		++size;
	}

	public T dequeue() {
		if (isEmpty()) {
			throw new RuntimeException();
		}
		T data = head.getData();
		head = head.getNext();
		--size;
		return data;
	}

	public void print() {
		if (isEmpty()) {
			throw new RuntimeException();
		}
		QElement<T> temp = head;
		while (temp != null) {
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
	}

	public boolean isFull() {
		return size == limit;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public static void main(String[] args) {
		Queue<Integer> q = new Queue<>();

		q.enqueue(12);
		q.enqueue(13);
		q.enqueue(121);
		q.enqueue(112);

		q.print();

		// System.out.println(q.dequeue());
		// System.out.println(q.dequeue());
		// System.out.println(q.dequeue());
		// System.out.println(q.dequeue());
	}

}

class QElement<T> {
	T data;
	QElement<T> next;

	QElement(T data, QElement<T> next) {
		super();
		this.data = data;
		this.next = next;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public QElement<T> getNext() {
		return next;
	}

	public void setNext(QElement<T> next) {
		this.next = next;
	}

}
