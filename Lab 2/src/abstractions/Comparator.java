package abstractions;

public class Comparator implements Greater {
    public boolean gt(Object o1, Object o2){
        if (o1 instanceof Point && o2 instanceof Point){
           Point p1 = (Point)o1;
           Point p2 = (Point)o2;
           return p1.getX()>p2.getX() || (p1.getX()==p2.getX() && p1.getY()>p2.getY());
        }
       return false;
   }
}
