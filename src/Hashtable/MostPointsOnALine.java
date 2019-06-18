package Hashtable;

/*
 * class Point {
 *   public int x;
 *   public int y;
 *   public Point(int x, int y) {
 *     this.x = x;
 *     this.y = y;
 *   }
 * }
 */
/**
 Method:
 HashMap key = <k, b>, value = a hashSet of points that are on this line
 for for P1, P2, compute the fomula of the line that passes P1 and P2
 ax + by + c = 0
 hashMap[<k, b>].add(P1)
 hashMap[<k, b>].add(P2)
 **/
public class MostPointsOnALine {
	public int most(Point[] points) {
		// Write your solution here.
		Set<Point> set = new HashSet<>();
		Map<RegularParameter, Set<Point>> = new HashMap<>();
		for (int i = 0; i < points.length; i++) {
			for (int j = 1; j < points.length; j++) {
				RegularParameter para = calParameter(points, i, j);
			}
		}
		return 0;
	}
	// ax + by + c = 0
	private RegularParameter calParameter(Point[] points, int i, int j) {
		int a = 0;
		int b = 0;
		int c = 0;
		// if verticle slope
		if (points[i].x == points[j].x) {
			a = 1;
			b = 0;
			c = 0 - points[i].x;
		} else if (points[i].y == points[j].y) {
			// if horizontal slope
			a = 0;
			b = 1;
			c = 0 - points[i].y;
		} else {
			// 2ax + 2by + 2c = 0 equals 3ax + 3by + 3c = 0
			// (y2 - y1) / (x2 - x1) = (-a) / b
      double (points[j].y - points[i].y)
		}
		RegularParameter para = new RegularParameter();
	}
	static class RegularParameter {
		int a;
		int b;
		int c;
		public RegularParameter(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
}
