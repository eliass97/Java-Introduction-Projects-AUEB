//ILIAS SETTAS 3150156
//ALEJANDROS JOVARAS 3150171

class ListNode {
	
	Point data;
	ListNode nextNode;
	
	ListNode(Point object) {
		this(object, null);
	}
	
	ListNode(Point object, ListNode node) {
		data = object;
		nextNode = node;
	}
	
	Point getObject() {
		return data; 
	}
	
	ListNode getNext() {
		return nextNode; 
	} 
} 