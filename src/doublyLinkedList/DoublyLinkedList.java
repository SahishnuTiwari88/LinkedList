package doublyLinkedList;

import java.util.NoSuchElementException;

public class DoublyLinkedList {
	
	private ListNode head; //holds first node
	private ListNode tail; //holds last node
	private int length;
	
	private class ListNode{
		private int data;
		private ListNode previous;
		private ListNode next;
		
		
		public ListNode(int data) {
			this.data = data;
			this.previous = null;
			this.next = null;
		}
	}
	
	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
		this.length = 0;
	}
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	public int length() {
		return length;
	}
	
	//insert at beginning, then tail points to newNode first 
	public void insertFirst(int data) {
		ListNode newNode = new ListNode(data);
		if(isEmpty()) {
			tail = newNode;
		}else {
			head.previous = newNode;
		}
		newNode.next = head;
		head = newNode;
		length++;
	}
	
	//insert at the end of the list, it is mainly done with help of tail
	public void insertLast(int data) {
		ListNode newNode = new ListNode(data);
		if(isEmpty()) {
			head = newNode;
		}else {
			tail.next = newNode;
		}
		newNode.previous = tail;
		tail = newNode;
		length++;
	}
	
	//forward traverse using head pointer
	public void displayForward() {
		if(head == null) {
			return;
		}
		ListNode temp = head;
		while(temp != null) {
			System.out.print(temp.data+" --> ");
			temp = temp.next;
		}
		System.out.print("null");
	}
	
	//backward traverse using tail pointer
	public void displayBackward() {
		if(tail == null) {
			return;
		}
		ListNode temp = tail;
		while(temp != null) {
			System.out.print(temp.data+" --> ");
			temp = temp.previous;
		}
		System.out.print("null");
	}
	
	//delete first node in doubly linked list
	
	public ListNode deleteFirst() {
		if(isEmpty()) {
			return null;
		}
		ListNode temp = head;
		if(head == tail) {
			tail = null;
		}else {
			head.next.previous = null;
		}
		head = head.next;
		temp.next = null;
		return temp;
	}
	
	//delete last node in doubly linked list
	public ListNode deleteLast() {
		if(isEmpty()) {
			throw new NoSuchElementException("Nothing is present to delete");
		}
		ListNode temp = tail;
		if(tail == head) {
			head = null;
		}else {
			tail.previous.next = null;
		}
		tail = tail.previous;
		temp.previous = null;
		length--;
		return temp;
	}

	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
//		dll.insertFirst(1);
//		dll.insertFirst(10);
//		dll.insertFirst(9);
//		dll.insertFirst(15);
//		dll.insertFirst(19);
		
		dll.insertLast(1);
		dll.insertLast(0);
		dll.insertLast(10);
		dll.insertLast(2);
		System.out.println("Forward traverse :");
		dll.displayForward();
		System.out.println();
		System.out.println("Backward traverse :");
		dll.displayBackward();
		System.out.println();
		//System.out.println("delete first element : "+dll.deleteFirst().data);
//		dll.displayForward();
//		dll.displayBackward();
		
		System.out.println("delete last element : "+dll.deleteLast().data);
		System.out.println("delete last element : "+dll.deleteLast().data);
		System.out.println("delete last element : "+dll.deleteLast().data);
		System.out.println("delete last element : "+dll.deleteLast().data);
	//	System.out.println("delete last element : "+dll.deleteLast().data);
	//	dll.deleteLast();
	//	dll.displayForward();
		System.out.println();
		//dll.displayBackward();

	}

}
