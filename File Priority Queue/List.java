//ILIAS SETTAS 3150156
//ALEJANDROS JOVARAS 3150171

public class List {
	
	private ListNode firstNode;
	private ListNode lastNode;
	private String name;
	private int size;
	
	public List() {
		this("list");
		size = 0;
	}
	
	public List(String listName) {
		name = listName;
		firstNode = lastNode = null;
		size = 0;
	}
	
	public void insertAtFront(PrintJob insertItem) {
		ListNode node = new ListNode(insertItem);
		if (isEmpty())
			firstNode = lastNode = node;
		else {
			node.nextNode = firstNode;
			firstNode = node;
		}
		size++;
	}
	
	public void insertAtBack(PrintJob insertItem) {
		ListNode node = new ListNode(insertItem);
		if (isEmpty())
			firstNode = lastNode = node;
		else {
			lastNode.nextNode = node;
			lastNode = node;
		}
		size++;
	}
	
	public PrintJob removeFromFront() throws EmptyListException {
		if (isEmpty()) {
			throw new EmptyListException(name);
		}
		PrintJob removedItem = firstNode.data;
		if (firstNode == lastNode) {
			firstNode = lastNode = null;
		}
		else {
			firstNode = firstNode.nextNode;
		}
		size--;
		return removedItem;
	}
	
	public PrintJob removeFromBack() throws EmptyListException {
		if (isEmpty()) {
			throw new EmptyListException(name);
		}
		PrintJob removedItem = lastNode.data;
		if (firstNode == lastNode) {
			firstNode = lastNode = null;
		}
	    else {
			ListNode current = firstNode;
			while (current.nextNode != lastNode) {
				current = current.nextNode;
			}
			lastNode = current;
			current.nextNode = null;
		}
		size--;
		return removedItem;
	}
	
	public boolean isEmpty() {
		return firstNode == null;
	}
	
	public int getSize() {
		return size;
	}
	
	public void print() {
		if (isEmpty()) {
			System.out.printf("Empty %s\n", name);
			return;
		}
		System.out.printf("The %s is: ", name);
		ListNode current = firstNode;
		while (current != null) {
			System.out.printf("%s ", current.data);
			current = current.nextNode;
		}
		System.out.println("\n");
	}
}