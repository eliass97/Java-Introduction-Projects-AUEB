import java.util.NoSuchElementException;
import java.io.PrintStream;

public class StringQueueWithOnePointer<T> implements StringQueue<T> {
	
	private ListNode<T> pointer;
	private String nameC;
	
	public StringQueueWithOnePointer() {
		this("listQueue");
	}
	
	public StringQueueWithOnePointer(String listName) {
		nameC = listName;
		pointer = null;
	}
    	
	public void put(T item) {
        ListNode<T> node = new ListNode(item);
        if (isEmpty()) {
			pointer = node;
		} else {
            pointer.nextNode = node;
			pointer = node;
		}
    }
	
	 public T get() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException(nameC);
		}
		T Ritem = pointer.nextNode.data;
        if (pointer == pointer.nextNode) {
            pointer = null;
        } else {
            pointer.nextNode = pointer.nextNode.nextNode;
		}
        return Ritem;
    }
	
	public T peek() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException(nameC);
		} else {
			return pointer.nextNode.data;
		}
	}
	
    public int size() {
        int x = 0;
        ListNode<T> current = pointer;
        while(current != null) {
            current = current.getNext();
            x++;     
        }
        return x;
    }
	
	public boolean isEmpty() {
		return pointer == null; 
	} 

	public void printQueue(PrintStream stream) {
		if (isEmpty()) {
			stream.printf("The queue is empty.");
			return;
		}
		stream.printf("The queue is: ");
		ListNode<T> current = pointer;
		while (current != null) {
			stream.print(current.data);
			current = current.nextNode;
			stream.printf(" ");
		}
	    stream.println("\n");
	}
}