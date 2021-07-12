package abstractions;

public class Point {
	private int x;
	private int y;
	public Point(int x, int y) {
		x = x;
		y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public String toString() { // string concatenation to represent Point: "("+x+","+y+")"
		String string1 = ("("+x+","+y+")");
		return string1;
	}
	public boolean equals(Object o) { 		 // need to test o is instance of Point; cast o to Point object-- Point p = (Point)o; then access x and y of p and compare them with x and y of this object
		Point p = (Point)o;
		if (x == p.getX() && y == p.getY()) {
			return true;
		}
		else {
			return false;
		}
	}
}
