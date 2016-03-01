public class DLinkedList {

    private int _size;
    private DNode _header, _trailer; // dummy

    public DLinkedList() {
	_size = 0;
	_header = new DNode(null, null, null);
	_trailer = new DNode(null, _header, null);
	_header.setNext(_trailer);
    }

    public boolean isEmpty() {
	return size() == 0;
    }

    public int size() {
	return _size;
    }

    // returns the node before current
    // throws Illegal Argument Exception if current == header
    public DNode getPrevious(DNode current) {
	if (current == _header)
	    throw new IllegalArgumentException("cannot move back of header");
	return current.getPrevious();
    }

    // returns the node after current
    // throws Illegal Argument Exception if current == _trailer
    public DNode getNext(DNode current) {
	if (current == _trailer)
	    throw new IllegalArgumentException("cannot move forwad of trailer");
	return current.getNext();
    }

    // pre: b refers to a node in the list
    //      throws an exception if b refers to the _header
    // post: inserts node a before node b
    public void addBefore(DNode b, DNode a) {
	if (b == _header)
	    throw new IllegalArgumentException("cannot add before header");
	a.setNext(b);
	a.setPrevious(getPrevious(b));
	b.setPrevious(a);
	a.getPrevious().setNext(a);
	_size++;
    }

    public void addLast(DNode x) {
	addBefore(_trailer, x);
    }

    public void addLast(String value) {
	addLast(new DNode(value, null, null));
    }

    public String toString() {
	String ans = "[ ";
	if (_size < 1) return ans + "]";
	DNode current = _header.getNext();
	while (current != _trailer) {
	    ans += current.getValue() + ", ";
	    current = current.getNext();
	}
	int len = ans.length();
	ans = ans.substring(0, len - 2);
	return ans + "]";
    }

    public static void main(String[] args) {
	DLinkedList L = new DLinkedList();
	System.out.println("size " + L.size());
	L.addLast("Jane");
	System.out.println("size " + L.size());
    }

}
