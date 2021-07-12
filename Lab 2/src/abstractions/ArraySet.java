package abstractions;

public class ArraySet implements Set{
private Object elems[]; 
private int index; 
private static int initialSize=2;

public ArraySet() {
	elems=new Object[initialSize];
	index=0;
}

/**
 * @return set elements as array
 */
public Object[] elements() {
	Object a[] = new Object[index];
	System.arraycopy(elems,0, a, 0, index);
	return a;
}

/**
 * @return the number of integers in set
 */
public int size() {
	return index;
}
/**
 * @param x the object to be checked
 * @return true if x is in this set
 */
public boolean contains(Object x) {
	return getIndex(x)>-1;
}
/**
 * @param x the object to be inserted
 * EFFECTS: if x is in the set, nothing happens;
 *          otherwise, x is added into this set.
 */
public void insert(Object x) {
	int xIndex = getIndex(x);
	if (xIndex<0) {
           growSize();  elems[index++]=x;
	}
}
private int getIndex(Object x) {
	for (int i=0; i<index; ++i) {
	if (elems[i].equals(x)) { return i;}
	}
	return -1;
}
private void growSize() {
	if (index==elems.length) {
	Object tmp[]=new Object[elems.length*2];
	System.arraycopy(elems,0,tmp,0,elems.length);	elems = tmp;
	}
}

/**
 * @param x the integer to be removed
 * EFFECTS: removes x from this set if it is in it.
 */
public void remove(Object x) {
	int xIndex = getIndex(x);
	if (xIndex<0) {	return;
	}
	for (int i=xIndex; i<index-1;++i) {
		elems[i]=elems[i+1];
	}
	--index;
}

// return a string representation suitable for printing.
public String toString() {
	String tmp="{";
	for (int i=0; i<index-1;++i) {
		tmp += elems[i]+",";
	}
	if (index>0) {
		tmp += elems[index-1];
	}
	tmp+="}"; return tmp;
}
}
