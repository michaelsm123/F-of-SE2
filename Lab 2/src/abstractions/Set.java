package abstractions;

public interface Set {

/**
 * @return set elements as array
 */
public Object[] elements();

/**
 * @return the number of integers in set
 */
public int size();

/**
 * @param x the object to be checked
 * @return true if x is in this set
 */
public boolean contains(Object x);

/**
 * @param x the object to be inserted
 * EFFECTS: if x is in the set, nothing happens;
 *          otherwise, x is added into this set.
 */
public void insert(Object x) ;

/**
 * @param x the integer to be removed
 * EFFECTS: removes x from this set if it is in it.
 */
public void remove(Object x);

// return a string representation suitable for printing.
public String toString();
}
