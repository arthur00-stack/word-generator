
public class HMap {

	EntryList[] t;
	int nbEntries;
	final int defaut = 20;
	
	HMap(int n){
		t = new EntryList[n];
		nbEntries = 0;
	}
	HMap() {
		t = new EntryList[defaut];
		nbEntries = 0;
	}
	WordList find(Prefix Key) {
		int index = Key.hashCode(t.length);
		EntryList curr = t[index];
		while(curr!= null) {
			if (Key.eq(curr.head.key, Key)) { 
	            return curr.head.value;   
	        }
	        curr = curr.next;
		}
		return null;
		
	}
	
	void rehash(int n) {
	    EntryList[] ancien = t;     
	    t = new EntryList[n];          
	    nbEntries = 0;                 

	    for (int i = 0; i < ancien.length; i++) {
	        EntryList cur = ancien[i];

	        while (cur != null) {
	            Prefix key = cur.head.key;
	            WordList value = cur.head.value;

	            int nouvelIndex = key.hashCode(n);

	            t[nouvelIndex] = new EntryList(new Entry(key, value), t[nouvelIndex]);
	            nbEntries++;

	            cur = cur.next;
	        }
	    }
	}
	
	void addSimple(Prefix key, String w) {
	    WordList wl = find(key);
	    if (wl != null) {
	        wl.addLast(w); 
	    } else {
	        WordList newList = new WordList();
	        newList.addLast(w);
	        int index = key.hashCode(t.length);
	        t[index] = new EntryList(new Entry(key, newList), t[index]);
	        nbEntries++;
	    }
	}
	
	void add(Prefix key, String w) {
		WordList wl = find(key);
	    if (wl != null) {
	   		wl.addLast(w);  	
	    }else {
	    	WordList newList = new WordList();
	        newList.addLast(w);
	        int index = key.hashCode(t.length);
	        t[index] = new EntryList(new Entry(key, newList), t[index]);
	        nbEntries++;
	    }
	    if (nbEntries > (3 * t.length) / 4) {
            rehash(t.length * 2);
        }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
