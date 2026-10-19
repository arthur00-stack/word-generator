class WordList {
	
  Node content;

  WordList() {
    content = null;
  }
  
  WordList(Node cnt){
	  content = cnt;
  }
  
WordList(String[] t){
	if(t.length<1) {
		content = null;
	}else {
		Node ctn = new Node(t[t.length-1],null);
		int i = t.length - 2;
		while(i>=0) {
			ctn = new Node(t[i],ctn);
			i--;
		}
		content = ctn;
	}
	
}
  
  int length() {
	  int i = 0;
	  Node cur = content;
	  while(cur!=null) {
		  i+=1;
		  cur = cur.next;
	  }
	  return i;
  }
  
  public String toString() {
	  String a = new String("[");
	    for (Node cur = content; cur != null; cur = cur.next) {
		    if (cur.next == null) {
		    	a+=cur.head;
		    }else {
		    	a += cur.head + ", ";
		    }
		    
		  }
	    a+="]";
	    return a;
	  }
  
  void addFirst(String w) {
	  content = new Node(w, content);
  }
  
  void addLast(String w) {
      if (content == null) {
          addFirst(w);
          return;
      }
      Node t = content;
      while (t.next != null) {
          t = t.next;
      }
      t.next = new Node(w, null);
  }
  
  String removeFirst() {
	  if(content == null) {
		  content = null;
	  }
	  String retour = content.head;
	  content = content.next;
	  return retour;
  }
  
  String removeLast() {
      if (content == null) {
          return null;
      }
      if (content.next == null) {
          String retour = content.head;
          content = null;
          return retour;
      }
      Node t = content;
      while (t.next.next != null) {
          t = t.next;
      }
      String retour = t.next.head;
      t.next = null;
      return retour;
  }
  
  void insert(String s) {
	  if (content == null || s.compareTo(content.head) <= 0) {
	        content = new Node(s, content);
	        return;
	    }
	    Node cur = content;
	    while (cur.next != null && cur.next.head.compareTo(s) < 0) {
	        cur = cur.next;
	    }
	    Node newNode = new Node(s, cur.next);
	    cur.next = newNode;
  }
  
  void insertionSort() {
	    if (content == null || content.next == null) {
	        return;
	    }

	    WordList sortedList = new WordList();

	    Node current = content;
	    while (current != null) {
	        sortedList.insert(current.head);
	        current = current.next;
	    }
	    this.content = sortedList.content;
	}
}