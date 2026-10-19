class Prefix {
  String[] t;

  final static String start = "<START>", end = "<END>", par = "<PAR>";

  Prefix(int n){ 
	  t = new String[n];
	  for(int i=0;i<n;i++) t[i] = start;
  }
  
  public Prefix(String[] newt) {
	t = newt;
}

  static boolean eq(Prefix p1, Prefix p2){
	  if(p1 == null && p2 == null)return true;
	  if((p1 == null && p2!= null) || (p2 == null && p1!= null))return false;
	  if(p1.t.length!= p2.t.length)return false;
	  for (int i = 0; i<p1.t.length;i++) {
		  if(!(p1.t[i].equals(p2.t[i]))) return false;
	  }
	  return true;
  }

  Prefix addShift(String w) {
	    String[] newt = new String[t.length]; 

	    for (int i = 0; i < t.length - 1; i++) {
	        newt[i] = t[i + 1];
	    }

	    newt[t.length - 1] = w;

	    return new Prefix(newt);
	}
  public int hashCode() {
	  int h = 0;
	  for (int i = 0; i< t.length;i++) h = 37*h + t[i].hashCode();
	  return h;
  }
  int hashCode(int n) {
	  int hash1 = hashCode();
	  int i = hash1%n;
	  return i >= 0 ? i:i+n;
  }

}