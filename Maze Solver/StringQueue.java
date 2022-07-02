import java.io.PrintStream;import java.util.NoSuchElementException; 
public interface StringQueue<T> {		public boolean isEmpty();
		public void put(T item);	public T get() throws NoSuchElementException;	public T peek() throws NoSuchElementException;	public void printQueue(PrintStream stream);	public int size();}