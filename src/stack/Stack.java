package stack;

import java.util.EmptyStackException;

public class Stack {

	private ListNode top;
	private int length;
	
	private class ListNode{
		private int data;
		private ListNode next;
		
		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public Stack() {
		top = null;
		length = 0;
	}
	
	public int length() {
		return length;
	}
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	//insert element in stack
	public void push(int data) {
		ListNode newNode = new ListNode(data); 
		newNode.next = top;
		top = newNode;
		length++;
	}
	
	// delete data from stack
	public ListNode pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		ListNode temp = top;
		top = top.next;
		length--;
		return temp;
	}
	
	//return top element of stack
	
	public int peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		return top.data;
	}
	
	//traverse elements of stack
	public void displayStackElement() {
		ListNode temp = top;
		while(temp != null) {
			System.out.print(temp.data+" --> ");
			temp = temp.next;
		}
		System.out.print("null");
	}
	
	public static void main(String[] args) {
		Stack stk = new Stack();
		stk.push(15);
		stk.push(11);
		stk.push(8);
		stk.push(10);
		
		System.out.println("Length of stack : "+stk.length);
		stk.displayStackElement();
		System.out.println();
		System.out.println("Top element "+stk.peek());
		System.out.println("Deleted element "+stk.pop().data);
		stk.displayStackElement();

	}

}
