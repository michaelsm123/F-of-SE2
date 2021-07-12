package main;

import abstractions.Set;
import abstractions.BinaryTreeSet;
import abstractions.Greater;

public class Main_String {
       private static String a[]={"1","2","3","3","2","1","100","101"};

       public static void main(String[] args) {
               /* Part 1 */
               // this is an example of anonymous class
                Greater comp = new Greater(){
                    public boolean gt(Object left, Object right){
                         if (left instanceof String && right instanceof String){
                            String l=(String)left, r=(String)right;
                            return l.compareTo(r)>0;
                         }
                         return false;
                    }
                };

		Set set=new BinaryTreeSet(comp);
		for (int i=0; i<a.length;++i)
		{
			set.insert(a[i]);
			System.out.println(set);
		}
                set.remove("1");
                set.remove("1");
		System.out.println(set);
                set.remove("101");
		System.out.println(set);
                set.remove("2");
		System.out.println(set);
                set.remove("3");
		System.out.println(set);
                set.remove("100");
                set.insert("100");
                set.remove(102);
                set.remove(101);
		System.out.println("In the end, set contains "+set.size()+" elements.");
		System.out.println(set);

               /* Part 2 */
		System.out.println("In the array a, the following integers are duplicated:");
		Set dupSet=new BinaryTreeSet(comp);
		for (int i=0; i<a.length;++i)
		{
			if (dupSet.contains(a[i])){
			   System.out.print(a[i]+" ");            
			}
			dupSet.insert(a[i]);
		}
	    System.out.println();
	}
}

