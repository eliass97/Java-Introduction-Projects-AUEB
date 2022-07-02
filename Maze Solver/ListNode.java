class ListNode<T> {
	
	T data;
	ListNode<T> nextNode;

	ListNode(T data) {
		this(data, null);
	}

	ListNode(T data, ListNode<T> node) {
		this.data = data;
		nextNode = node;
	} 

	T getObject() {
		return data; 
	} 

	ListNode<T> getNext() {
		return nextNode; 
	}
} 