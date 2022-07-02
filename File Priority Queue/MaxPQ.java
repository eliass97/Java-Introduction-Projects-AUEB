//ILIAS SETTAS 3150156
//ALEJANDROS JOVARAS 3150171

import java.util.Comparator;

public class MaxPQ {
	
    private PrintJob[] heap;
    private int size=0;
    private PrintJob p;
	
    public MaxPQ(int capacity) {
        if (capacity < 1) throw new IllegalArgumentException();
        this.heap = new PrintJob[capacity+1];
        this.size = 0;
    }
	
    public void insert(PrintJob object) {
        if (object == null) throw new IllegalArgumentException();
        if (size == heap.length-1) throw new IllegalStateException();
		if (size >= (0.75 * (heap.length-1))){
			resize();
		}
        heap[++size] = object;
        swim(size);
    }
	
    public PrintJob getMax() {
        if (size == 0) throw new IllegalStateException();
        PrintJob object = heap[1];
        if (size > 1) heap[1] = heap[size];
        heap[size--] = null;
        sink(1);
        return object;
    }
	
    private void swim(int i) {
        while (i > 1) {
            int p = i/2;
            int result = heap[i].compareTo(heap[p]);
            if (result <= 0) return;
            swap(i, p);
            i = p;
        }
    }
	
    private void sink(int i){
        int left = 2*i, right = left+1, max = left;
        while (left <= size) {
            if (right <= size) {
                max = heap[left].compareTo(heap[right]) < 0 ? right : left;
            }
            if (heap[i].compareTo(heap[max]) >= 0) return;
            swap(i, max);
            i = max; left = 2*i; right = left+1; max = left;
        }
    }
    
	public  void resize(){
		PrintJob[] heapX2;
		heapX2 = new PrintJob [heap.length*2];	
		for (int i=0; i< heap.length; i++){
			heapX2[i] = heap[i];
		}
		heap = heapX2;	
	}
	
    private void swap(int i, int j) {
        PrintJob te = heap[i];
        heap[i] = heap[j];
        heap[j] = te;
    }
	
    public void print() {
        for (int i=1; i<=size; i++){
            heap[i].PrintInfo();
        }
    }
	
    boolean isEmpty(){
        return size == 0;
    }
	
	public int size(){
		return size;
	}
	
	public PrintJob peek(){
		if (!isEmpty()){
			return heap[1];
		}else{
			throw new IllegalStateException();
		}
	}
	
	public void refresh(int time) {
		int i;
		for(i=1;i<size+1;i++) {
			if(time>=heap[i].getArrivalTime()) {
			    heap[i].setWaitingTime(time - heap[i].getArrivalTime());
			    heap[i].setPriority(heap[i].getPriority() + heap[i].getWaitingTime());
			    if(heap[i].getPriority()>127) {
				    heap[i].setPriority(127);
			    }
	        }
		}
		for(i=0;i<size;i++) {
			swim(i+1);
		}
    }
}