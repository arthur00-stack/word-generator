class Node {
	
  String head;
  Node next;

  Node(String head, Node next) {
    this.head = head;
    this.next = next;
  }
  
  static int lengthRec(Node l) {
	    if (l == null) {
	    	return 0;
	    }else {
	    	return lengthRec(l.next)+1;
	    }
	  }
  
  static int length(Node l) {
	  int i = 0;
	  for (Node cur = l; cur != null; cur = cur.next) {
		    i++;
		  }
	  return i;
  }
  
  static String makeString(Node l) {
	  String a = new String("[");
	    for (Node cur = l; cur != null; cur = cur.next) {
		    if (cur.next == null) {
		    	a+=cur.head;
		    }else {
		    	a += cur.head + ", ";
		    }
		    
		  }
	    a+="]";
	    return a;
	  }
  static void addLast(String s, Node l) {
	  for (Node cur = l; cur != null; cur = cur.next) {
		    if (cur.next == null) {
		    	cur.next = new Node(s, null);
		    	break;
		    }else {
		    	continue;
		    }
		    
		  }
  }
  
  static Node copy(Node l) {
	    if (l == null) {
	        return null;
	    }
	    return new Node(l.head, copy(l.next));
	}
	  
  
  static Node insert(String s, Node l) {
	    if (l == null || s.compareTo(l.head) <= 0) {
	        return new Node(s, l);
	    }
	    Node cur = l;
	    while (cur.next != null && cur.next.head.compareTo(s) < 0) {
	        cur = cur.next;
	    }
	    Node newNode = new Node(s, cur.next);
	    cur.next = newNode;

	    return l;
	}
  
  static Node insertionSort(Node l) {
	  if(length(l)<=1) {
		  return l;
	  }
	  Node sorte = new Node(l.head, null); 
	  Node current = l.next;
	  while (current != null) {
	        Node nextNode = current.next;
	        sorte = insert(current.head, sorte);
	        current = nextNode;
	    }
	    return sorte;
  }
  static Node merge(Node l1, Node l2) {
	    if (l1 == null) return copy(l2);
	    if (l2 == null) return copy(l1);

	    Node resultHead = null;
	    Node current = null;

	    Node ptr1 = l1;
	    Node ptr2 = l2;

	    while (ptr1 != null || ptr2 != null) {
	        String nextValue;

	        if (ptr1 != null && (ptr2 == null || ptr1.head.compareTo(ptr2.head) <= 0)) {
	            nextValue = ptr1.head;
	            ptr1 = ptr1.next;
	        } else {
	            nextValue = ptr2.head;
	            ptr2 = ptr2.next;
	        }

	        if (resultHead == null) {
	            resultHead = new Node(nextValue, null);
	            current = resultHead;
	        } else {
	            current.next = new Node(nextValue, null);
	            current = current.next;
	        }
	    }
	    return resultHead;
	}
  
	  public static void main(String[] args) {
			  Node foobar = new Node("foo", new Node("bar", new Node("baz", null)));
			 //System.out.println(lengthRec(foobar));
			  //System.out.println(makeString(foobar));
			  //addLast("qux", foobar);
			  //System.out.println(makeString(foobar));
			  foobar = insert("a",foobar);
			  foobar = insert("basta", foobar);
			  System.out.println(makeString(foobar));
			  foobar = insertionSort(foobar);
			  System.out.println(makeString(foobar));
		  
	  }
  
}