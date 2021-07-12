package main;

import abstractions.Set;
import abstractions.BinaryTreeSet;
import abstractions.Greater;

public class Main {
       private static int a[]={1,2,3,3,2,1,100,101};

       public static void main(String[] args) {
               /* Part 1 */
               // this is an example of anonymous class
                Greater comp = new Greater(){
                    public boolean gt(Object left, Object right){
                         if (left instanceof Integer && right instanceof Integer){
                            Integer l=(Integer)left, r=(Integer)right;
                            return l.intValue()>r.intValue();
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
		System.out.println("In the end, set contains "+set.size()+" elements.");
                set.remove(1);
                set.remove(1);
                set.remove(2);
                set.remove(101);
                set.remove(100);
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

