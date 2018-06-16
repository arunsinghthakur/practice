package joker.ds;

import java.lang.reflect.Array;

public class CircularQueue<T> {
	T[] q = null;

	int intial = -1;
	int head = intial;
	int tail = intial;

	public CircularQueue(Class<T> clazz, int size) {
		q = (T[]) Array.newInstance(clazz, size);
	}

	public void enqueue(T data) {
		if (isFull()) {
			throw new RuntimeException();
		}
		tail = (tail + 1) % q.length;
		q[tail] = data;
		if (head == intial) {
			head = tail;
		}
	}

	public T dequeue() {
		if (isEmpty()) {
			throw new RuntimeException();
		}
		T data = q[head];

		if (head == tail) {
			head = intial;
		} else {
			head = (head + 1) % q.length;
		}
		return data;
	}

	public boolean isFull() {
		int next = (tail + 1) % q.length;
		return next == head;
	}

	public boolean isEmpty() {
		return head == intial;
	}

	public static void main(String[] args) {
		CircularQueue<Integer> q = new CircularQueue<>(Integer.class, 3);

		q.enqueue(1);
		q.enqueue(22);
		q.enqueue(221);

		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		// System.out.println(q.dequeue());
	}

}
