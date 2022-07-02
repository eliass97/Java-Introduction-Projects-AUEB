//ILIAS SETTAS 3150156
//ALEJANDROS JOVARAS 3150171

class ListNode {
	
	PrintJob data;
	ListNode nextNode;
	
	ListNode(PrintJob object) {
		this(object, null);
	}
	
	ListNode(PrintJob object, ListNode node) {
		data = object;
		nextNode = node;
	}
	
	PrintJob getObject() {
		return data; 
	}
	
	ListNode getNext() {
		return nextNode; 
	} 
} 