package abstractions;

public class BinaryTreeSet implements Set {

// Node is a nested class inside BinaryTreeSet
private class Node {
Node l, r, p; // left and right child, parent
Object data;
}

private Node root; // root of binary tree
private Greater comp; // functional object that compares the data in two nodes
private int size; // number of tree nodes
public BinaryTreeSet(Greater gt){
   root = null;
   size = 0;
   comp=gt;
}

/**
 * @return set elements as array
 * width-first traversal of tree
 */
public Object[] elements(){
   Object tmp [] = new Object[size];
   if (root!=null){
     int index=0;
     int beg=0, end=0;
     tmp[0]=root; 
     while (beg<=end){
       Node n = (Node)tmp[beg];
       tmp[index++]=n.data;
       beg++;
       if (n.l!=null){
          end++;
          tmp[end]=n.l;
       }
       if (n.r!=null){
          end++;
          tmp[end]=n.r;
       }
     }
   }
   return tmp;
}

/**
 * @return the number of integers in set
 */
public int size(){
  return size;
}

/**
 * @param x the object to be checked
 * @return true if x is in this set
 */
public boolean contains(Object x){
  Node current = root;
  while (current!=null){
      if (current.data.equals(x)){
         return true;
      }
      else
      if (comp.gt(current.data, x)){
         current = current.l;
      }
      else {
         current = current.r;
      }
  }
  return false;
}

/**
 * @param x the object to be inserted
 * EFFECTS: if x is in the set, nothing happens;
 *          otherwise, x is added into this set.
 */
public void insert(Object x) {
   if (null==root) {
      root = new Node();
      root.data = x;
      size = 1;
      return;
   }
   Node p = root;
   while (!p.data.equals(x)){
      if (comp.gt(p.data,x)){
         if (null==p.l) {
            p.l = new Node();
            p.l.data = x;
            p.l.p = p;
            ++size;
            return;
         }
        else p = p.l;
      }
      else {
         if (null==p.r) {
            p.r = new Node();
            p.r.data = x;
            p.r.p = p;
            ++size;
            return;
         }
        else p = p.r;
      }
   }
}

/**
 * @param x the integer to be removed
 * EFFECTS: removes x from this set if it is in it.
 */
public void remove(Object x){
//  Node current = root;
//  while (current!=null){
//      if (current.data.equals(x)){
//         --size;
//         Node p=current.p;
//         Node min = smallest(current.r), max = largest(current.l);
//         Node newRoot=null;
//         if (null!=min){
//            newRoot = min;
//            newRoot.l=current.l; if (current.l!=null) current.l.p=newRoot;
//            if (newRoot.p!=null) {newRoot.p.l=newRoot.r; if (newRoot.r!=null) newRoot.r.p = newRoot.p;}
//            if (newRoot!=current.r) {newRoot.r=current.r; if (current.r!=null) current.r.p=newRoot;}
//         }
//         else if (null!=max){
//            newRoot = max;
//            newRoot.r=current.r; if (current.r!=null) current.r.p=newRoot;
//            if (newRoot.p!=null) {newRoot.p.r=newRoot.l; if (newRoot.l!=null) newRoot.l.p=newRoot.p;}
//            if (newRoot!=current.l) {newRoot.l=current.l; if (current.l!=null) current.l.p=newRoot;}
//         }
//         if (root==current){
//            root = newRoot;
//         }
//         else {
//           if (p.l==current) {
//            p.l = newRoot;
//           }
//           else {
//            p.r = newRoot;
//           }
//         }
//         if (null==newRoot){
//            return;
//         }
//         newRoot.p = p; 
//         return;
//      }
//      else
//      if (comp.gt(current.data, x)){
//         current = current.l;
//      }
//      else {
//         current = current.r;
//      }
//  }
	  Node current = root;
	  while (current!=null){

    if (current.data.equals(x)){
       --size;
       Node min = smallest(current.r), max = largest(current.l);
       if (null!=min){
      	 min.l = current.l; 
      	 if (current.l!=null){
      		 current.l.p = min;
      	 }
      	 
      	 if (min!=current.r){
          	 min.p.l = min.r;
          	 if (min.r!=null) min.r.p = min.p;
          	 
      		 min.r = current.r;
	        	 if (current.r!=null){
	        		 current.r.p = min;
	        	 }
      	 }
      	 if (current.p==null){
      		 root = min;
      	 }
      	 else if (current==current.p.l) {
      		 current.p.l = min;
      	 }
      	 else if (current==current.p.r) {
      		 current.p.r = min;
      	 }
  		 min.p = current.p;
       }
       else if (null!=max){
      	 if (max!=current.l){
      		 max.p.r = max.l;
      		 if (max.l!=null) max.l.p = max.p;
      		 
      		 max.l = current.l;
	        	 if (current.l!=null){
	        		 current.l.p = max;
	        	 }
      	 }
      	 
      	 max.r = current.r;
      	 if (current.r!=null){
      		 current.r.p = max;
      	 }

      	 if (current.p==null){
      		 root = max;
      	 }
      	 else if (current==current.p.l){
      		 current.p.l = max;
      	 }
      	 else if (current==current.p.r){
      		 current.p.r = max;
      	 }
      	 max.p = current.p;
       }
       else {
      	 if (current.p==null){
      		 root = null;
      		 return;
      	 }
      	 if (current.p.l==current) {
      		 current.p.l = null;
//	        	 balance(current.p.r);
      	 }
      	 else if (current.p.r==current) {
      		 current.p.r = null;
//	        	 balance(current.p.l);
      	 }
       }
       current.r=current.l=current.p = null;
       return;
    }
    else
    if (comp.gt(current.data, x)){
       current = current.l;
    }
    else {
       current = current.r;
    }
   }
}
private Node smallest(Node root){
    if (null!=root){
       while (root.l!=null){
           root = root.l;
       }
    }
    return root;
}
private Node largest(Node root){
    if (null!=root){
       while (root.r!=null){
           root = root.r;
       }
    }
    return root;
}

// return a string representation suitable for printing.
public String toString(){
//   String str="{";
//   Object tmp [] = new Object[size];
//   if (root!=null){
//     int index=0;
//     int beg=0, end=0;
//     tmp[0]=root; 
//     while (beg<=end){
//       Node n = (Node)tmp[beg];
//       str+=n.data; // n.data should define a toString().
//       beg++;
//       if (n.l!=null){
//          end++;
//          tmp[end]=n.l;
//       }
//       if (n.r!=null){
//          end++;
//          tmp[end]=n.r;
//       }
//       if (n.l!=null || n.r!=null || beg<=end) str+=" ";
//     }
//   }
//   str += "}";
//   return str;
	   String str="{";
	   Object tmp [] = new Object[size];
	   if (root!=null){
	     int beg=0, end=0;
	     tmp[0]=root; 
	     while (beg<=end){
	       Node n = (Node)tmp[beg];
	       str+=n.data; // n.data should define a toString().
	       beg++;
	       if (n.l!=null){
	          end++;
	          tmp[end]=n.l;
	       }
	       if (n.r!=null){
	          end++;
	          tmp[end]=n.r;
	       }
	       if (n.l!=null || n.r!=null || beg<=end) str+=" ";
	     }
	   }
	   str += "}";
	   return str;
}
}
