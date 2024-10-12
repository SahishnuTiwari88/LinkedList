package queue;

import java.util.NoSuchElementException;

public class Queue {
	
	private ListNode rear;
	private ListNode front;
	private int length;
	
	private class ListNode{
		private int data;
		private ListNode next;
		
		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public Queue() {
		rear = null;
		front = null;
		length = 0;
	}
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	public int length() {
		return length;
	}
	
	//insert element in queue
	public void enqueue(int data) {
		ListNode newNode = new ListNode(data);
		if(isEmpty()) { //front-->null and rear-->null
			front = newNode;
		}else {
			rear.next = newNode;
		}
		rear = newNode;
		length++;
	}
	
	//print element of queue
	public void display() {
		if(isEmpty()) {
			return;
		}
		ListNode current = front;
		while(current != null) {
			System.out.print(current.data +" --> ");
			current = current.next;
		}
		System.out.print("null");
	}
	
	//remove element from queue
	public int deQueue() {
		if(isEmpty()) {
			throw new NoSuchElementException("No element to delete");
		}
		int result = front.data;
		front = front.next;
		if(front == null) {
			rear = null;
		}
		return result;
	}
	//show first element i.e. front
	public void first() {
		if(isEmpty()) {
			throw new NoSuchElementException("No element");
		}
		System.out.println(front.data);
	}
	
	//show last element i.e. rear
		public void last() {
			if(isEmpty()) {
				throw new NoSuchElementException("No element");
			}
			System.out.println(rear.data);
		}


	public static void main(String[] args) {
		Queue qu = new Queue();
		qu.enqueue(1);
		qu.enqueue(10);
		qu.enqueue(15);
		qu.enqueue(2);
		
		qu.display();
		System.out.println();
		System.out.println("Removed element : "+qu.deQueue());
		qu.first();
		qu.last();
		System.out.println("Removed element : "+qu.deQueue());
		qu.first();
		qu.last();

	}

}
