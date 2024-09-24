package singlyLinkedList;

public class SinglyLinkedList {
	
	private ListNode head;
	
	private static class ListNode {
		private int data;
		private ListNode next;
		
		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	//print elements of singly linked list
	public void printList() {
		ListNode current = head;
		while(current != null) {
			System.out.print(current.data +" --> ");
			current = current.next;
		}
		System.out.print("null");
		System.out.println();
	}
	
	public void display(ListNode head) {
		ListNode current = head;
		while(current != null) {
			System.out.print(current.data +" --> ");
			current = current.next;
		}
		System.out.print("null");
	}
	
	//find length of linked list
	public int length() {
		if(head == null) {
			return 0;
		}
		ListNode current = head;
		int count = 0;
		while(current != null) {
			count++;
			current = current.next;
		}
		return count;
	}
	
	//insert node at beginning of linked list
	public void insertBegin(int data) {
		ListNode newNode = new ListNode(data);
		if(head == null) {
			head = newNode;
		}else {
			newNode.next = head;
			head = newNode;
		}
	}
	
	//insert node at end of linked list
	public void insertEnd(int data) {
		ListNode newNode = new ListNode(data);
		if(head == null) {
			head = newNode;
			return;
		}
		ListNode current = head;
		while(current.next != null) {
			current = current.next;
		}
		current.next = newNode;
	}
	
	//insert node at given position
	public void insertPosition(int data,int position) {
		ListNode newNode = new ListNode(data);
		if(position == 1) {
			newNode.next = head;
			head = newNode;
		}else {
			ListNode previous = head;
			int count = 1;
			while(count < position-1) {
				previous = previous.next;
				count++;
			}
			ListNode current = previous.next;
			newNode.next = current;
			previous.next = newNode;
			
		}
	}
	
	//delete node from start
	
	public ListNode deleteFirst() {
		if(head == null) {
			return null;
		}
		ListNode temp = head;
		head = head.next;
		return temp;
	}
	
	//delete node from end
	public ListNode deleteLast() {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode current = head;
		ListNode previous = null;
		while(current.next != null) {
			previous = current;
			current = current.next;
		}
		previous.next = null;
		return current;
	}
	
	//delete node from given position
	public ListNode deletePosition(int position) {
		if(position == 1) {
			ListNode temp = head;
			head = head.next;
			return temp;
		}else {
			ListNode previous = head;
			int count = 1;
			while(count < position-1) {
				previous = previous.next;
				count++;
			}
			ListNode current = previous.next;
			previous.next = current.next;
			return current;
		}
		
	}
	
	//search an element in singly linked list
	public ListNode find(ListNode head, int key) {
		if(head == null) {
			return null;
		}
		int count = 1;
		ListNode current = head;
		while(current.data != key){
			current = current.next;
			count++;
		}
		System.out.println("Searched Element found at position :"+count);
		return current;
	}
	
	//reverse a singly linked list
	public ListNode reverseList(ListNode head) {
		if(head == null) {
			return null;
		}
		ListNode current = head;
		ListNode previous = null;
		ListNode next = null;
		while(current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current  = next;
		}
		return previous;
	}
	
	//find middle node in list
	public ListNode findMiddle() {
		if(head == null) {
			return null;
		}
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	//find nth node from end of list
	
	public ListNode getNthNodeFromEnd(int n) {
		if(head == null) {
			return null;
		}
		ListNode refPtr = head;
		ListNode mainPtr = head;
		int count = 0;
		while(count < n) {
			refPtr = refPtr.next;
			count++;
		}
		while(refPtr != null) {
			refPtr = refPtr.next;
			mainPtr = mainPtr.next;
		}
		return mainPtr;
	}
	
	//remove duplicates from sorted list
	public void removeDuplicates() {
		if(head == null) {
			return;
		}
		ListNode current = head;
		while(current != null && current.next != null) {
		if(current.data != current.next.data) {
			current = current.next;
		}else {
		ListNode currentNext = current.next;
		current.next = currentNext.next;
		}
	}
	}
	
	//insert node in sorted list
	public void insertNode(int data) {
		ListNode newNode = new ListNode(data);
		if(head == null) {
			head = newNode;
		}
		ListNode current = head;
		ListNode temp = null;
		while(current != null && current.data < newNode.data) {
			temp = current;
			current = current.next;
		}
		newNode.next = current;
		temp.next = newNode;
	}
	
	//remove key/data from list
	public void deleteNode(int data) {
		if(head == null) {
			return;
		}
		ListNode current = head;
		if(current != null && current.data == data) {
			head = current.next;
			return;
		}
		
		ListNode temp = null;
		while(current != null && current.data != data) {
			temp = current;
			current = current.next;
		}
		temp.next = current.next;
	}
	
	//detect loop in linked list
	//if there is a loop in list then slowptr meets fastptr at some point while traversing
	// fastPtr.next to check null pointer exception
	
	public boolean containsLoop() {
		ListNode slowPtr = head;
		ListNode fastPtr = head;
		while(fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			if(fastPtr == slowPtr) {
				return true;
			}
		}
		return false;
	}
	
	//create list having loop
	public void createListWithLoop() {
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode fourth = new ListNode(4);
		ListNode fifth = new ListNode(5);
		ListNode sixth = new ListNode(6);
		
		head = first;
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		sixth.next = third;
	}
	
	//find starting point of the loop
	public ListNode startNodeInLoop() {
		ListNode slowPtr = head;
		ListNode fastPtr = head;
		while(fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			if(fastPtr == slowPtr) {
				return getStartingNode(slowPtr);
			}
		}
		return null;
		
	}
	
	private ListNode getStartingNode(ListNode slowPtr) {
		ListNode temp = head;
		while(temp != slowPtr) {
			slowPtr = slowPtr.next;
			temp = temp.next;
		}
		return temp;
	}
	
	//remove loop from list
	public void removeLoopFromList() {
		ListNode slowPtr = head;
		ListNode fastPtr = head;
		while(fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			if(fastPtr == slowPtr) {
				removeLoop(slowPtr);
			}
		}	
		
	}
	
	private void removeLoop(ListNode slowPtr) {
		ListNode temp = head;
		while(temp.next != slowPtr.next) {
			slowPtr = slowPtr.next;
			temp = temp.next;
		}
		slowPtr.next = null;
		
	}
	
	//Merge two sorted list i.e. SinglyList a = 1-->4-->8-->null and  SinglyList b = 3-->6-->null 
	//after merging it will look like 1-->3-->4-->6-->8-->null
	//for doing this we need to create a dummy list so that it can store merge list, then we assign that dummy list
	//to a ListNode tail for further operation and return that tail node.
	//suppose if any list got ended first the rest will be appended
	//in below method we provide head of the both ListNode
	
	public static ListNode mergeList(ListNode a, ListNode b) {
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		while(a != null && b != null) {
			if(a.data < b.data) {
				tail.next = a;
				a = a.next;
			}else {
				tail.next = b;
				b = b.next;
			}
			tail = tail.next;
		}
		if(a == null) {
			tail.next = b;
		}else {
			tail.next = a;
		}
		return dummy.next;
		//we return dummy.next as dummy holds nothing it is created for our simplicity, so that we can store data	
	}
	
	//Add two singly linked list
	//In this case to find the number we need to read list from last to front, same goes for result
	//result also from end to front, here also we have to consider dummy list
	
	public static ListNode addList(ListNode a, ListNode b) {
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		int carry = 0;
		while(a != null || b != null) {
			int x = (a != null) ? a.data : 0;
			if(a != null) {
			a = a.next;
			}
			int y = (b != null) ? b.data : 0;
			if(b != null) {
				b = b.next;
			}
			
			int sum = carry+x+y;
			carry = sum/10;
			tail.next = new ListNode(sum%10);
			tail = tail.next;
			
		}
		if(carry > 0) {
			tail.next = new ListNode(carry);
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		/*
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.head = new ListNode(10);
		ListNode second = new ListNode(1);
		ListNode third = new ListNode(8);
		ListNode fourth = new ListNode(11);
		
		//connect each ListNode to form a chain
		
		sll.head.next = second;
		second.next = third;
		third.next = fourth;
		
		sll.insertEnd(1);
		sll.insertEnd(8);
		sll.insertEnd(10);
		sll.insertEnd(18);
		
		sll.printList();
		System.out.println();
		sll.insertPosition(5, 2);
		sll.printList();
		System.out.println();
		System.out.println("Length is : "+sll.length());
		
		System.out.println("Delete element from start is :"+sll.deleteFirst().data);
		sll.printList();
		System.out.println();
		System.out.println("Delete element from end is :"+sll.deleteLast().data);
		System.out.println("Delete element from end is :"+sll.deleteLast().data);
		sll.printList();
		System.out.println();
		System.out.println("Delete element from given Position is :"+sll.deletePosition(1).data);
		System.out.println("Delete element from given Position is :"+sll.deletePosition(3).data);
		
		System.out.println("Searched Element is found :"+ sll.find(sll.head, 8).data);
		sll.printList();
		System.out.println();
		ListNode reverseList = sll.reverseList(sll.head);
		sll.display(reverseList);
		System.out.println();
		sll.insertNode(9);
		sll.insertNode(5);
		sll.insertNode(19);
		sll.printList();
		System.out.println("After deleting given key :");
		sll.deleteNode(19);
//		sll.deleteNode(10);
//		sll.deleteNode(9);
		//sll.deleteNode(1);
		sll.printList();
		System.out.println();
		System.out.println("Middle element is :"+sll.findMiddle().data);
		System.out.println("After removing duplicates :");
		sll.removeDuplicates();
		sll.printList();
		System.out.println();
		System.out.println("Nth element is :"+sll.getNthNodeFromEnd(3).data);
		System.out.println();
		System.out.println("Length is : "+sll.length());
		
		
		sll.createListWithLoop();
		System.out.println("Contains loop or not : "+sll.containsLoop());
		System.out.println(sll.startNodeInLoop().data);
		sll.removeLoopFromList();
		sll.printList();*/
		
		SinglyLinkedList sll1 = new SinglyLinkedList();
		sll1.insertEnd(7);
		sll1.insertEnd(4);
		sll1.insertEnd(9);
		
		sll1.printList();
		
		
		SinglyLinkedList sll2 = new SinglyLinkedList();
		sll2.insertEnd(1);
		sll2.insertEnd(5);
		System.out.println();
		sll2.printList();
		
		SinglyLinkedList sll = new SinglyLinkedList();
		
//		ListNode mergeListResult = mergeList(sll1.head, sll2.head);
//		sll.display(mergeListResult);
		//use above or below both works in same way
		
		sll.head = addList(sll1.head, sll2.head);
		sll.printList();
		
	}
}
