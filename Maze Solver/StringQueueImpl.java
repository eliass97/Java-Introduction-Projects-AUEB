import java.util.NoSuchElementException;
import java.io.PrintStream;

public class StringQueueImpl<T> implements StringQueue<T> {
	
	private ListNode<T> head;
	private ListNode<T> tail;
	private String nameQ;
	
	public StringQueueImpl() {
		this("listQueue");
	}
	
	public StringQueueImpl(String listName) {
		nameQ = listName;
		head = tail = null;
	}
	
	public void put(T item) {
		ListNode<T> node = new ListNode<T>(item);
		if (isEmpty()) {
			head = tail = node;
		} else {
			tail.nextNode = node;
			tail = node;
		}
	}
	
	public T get() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException(nameQ);
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
			throw new NoSuchElementException(nameQ);
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

	public void printQueue(PrintStream stream) {
		if (isEmpty()) {
			stream.printf("The queue is empty.");
			return;
		}
		stream.printf("The queue is: ");
		ListNode<T> current = head;
		while (current != null) {
			stream.print(current.data);
			current = current.nextNode;
			stream.printf(" ");
		}
		stream.println("\n");
	} 
}