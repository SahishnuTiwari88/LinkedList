package circularLinkedList;

import java.util.NoSuchElementException;

public class CircularLinkedList {
	
	private ListNode last;
	private int length;
	
	private class ListNode{
		private ListNode next;
		private int data;
		
		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public CircularLinkedList() {
		last = null;
		length = 0;
	}
	
	public int length() {
		return length;
	}
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	//creating circular list
	public void createCircularList() {
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(8);
		ListNode third = new ListNode(10);
		ListNode fourth = new ListNode(16);
		
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = first;
		
		last = fourth;
	}
	
	//traversing circular list
	public void displayCircularList() {
		if(last == null) {
			return;
		}
		ListNode first = last.next; //last.next point to first element
		while(first != last) {
			System.out.print(first.data +"-->");
			first = first.next;
		}
		System.out.print(first.data);	
	}
	
	//insert node at beginning of circular linked list
	public void insertFirst(int data) {
		ListNode newNode = new ListNode(data);
		//ListNode first = last.next;
		if(last == null) {
			last = newNode;
		}else {
			newNode.next = last.next;
		}
		last.next = newNode;
		length++;
	}
	
	//insert node at end of circular linked list
	public void insertLast(int data) {
		ListNode newNode = new ListNode(data);
		if(last == null) {
			last = newNode;
			last.next = last;
		}else {
			newNode.next = last.next;
			last.next = newNode;
			last = newNode;
		}
		length++;
	}
	
	//remove first node from circular linked list
	public ListNode deleteFirst() {
		if(isEmpty()) {
			throw new NoSuchElementException("No element to delete");
		}
		ListNode first = last.next;
		if(last.next == last ) {
			last = null;
		}else {
			last.next = first.next;
			first.next = null;
			length--;
		}
		
		return first;
	}
	
	public static void main(String[] args) {
		CircularLinkedList cll = new CircularLinkedList();
		//cll.createCircularList();
		
		cll.insertFirst(2);
		cll.insertFirst(5);
		cll.insertFirst(9);
		
		cll.insertLast(0);
		cll.insertLast(1);
		cll.displayCircularList();
		System.out.println();
		System.out.println("Length before deletion "+cll.length);
		System.out.println("Deleted element "+cll.deleteFirst().data);
		System.out.println("Deleted element "+cll.deleteFirst().data);
		System.out.println("Length after deletion "+cll.length);
		cll.displayCircularList();

	}

}
