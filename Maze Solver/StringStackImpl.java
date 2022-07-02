import java.util.NoSuchElementException;
import java.io.PrintStream;

public class StringStackImpl<T> implements StringStack<T> {
	
    private ListNode<T> head;
	private ListNode<T> tail;
	private String nameS;
	
	public StringStackImpl() {
		this("listStack");
	}
	
	public StringStackImpl(String listName) {
		nameS = listName;
		head = tail = null;
	}
	
	public void push(T item) {
		ListNode<T> node = new ListNode<T>(item);
		if (isEmpty()) {
			head = tail = node;
		} else {
			node.nextNode = head;
			head = node;
		}
	}
	
	public T pop() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException(nameS);
		}
		T Ritem = head.data; 
		if (head == tail) {
			head = tail = null;
		} else {
			head = head.nextNode;
		}
		return Ritem;
	}

	public T peek() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException(nameS);
		} else {
			return head.data;
		}
	}
	
    public int size() {
        int x = 0;
        ListNode<T> current = head;
        while(current != null) {
            current = current.getNext();
            x++;     
        }
        return x;
    }
	
	public boolean isEmpty() {
		return head == null; 
	} 

	public void printStack(PrintStream stream) {
		if (isEmpty()) {
			stream.printf("The stack is empty.");
			return;
		}
		stream.printf("The stack is: ");
		ListNode<T> current = head;
		while (current != null) {
			stream.print(current.data);
			current = current.nextNode;
			stream.printf(" ");
		}
		stream.println("\n");
	}	
}