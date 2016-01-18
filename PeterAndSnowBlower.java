import java.util.ArrayList;
import java.util.Scanner;


public class PeterAndSnowBlower {
	//http://codeforces.com/contest/614/problem/C
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		Point p = new Point(input.nextInt()+0.0, input.nextInt()+0.0);
		Point[] inputPoints = new Point[n];
		for(int a = 0; a < n; a++){
			inputPoints[a] = new Point(input.nextInt()+0.0, input.nextInt()+0.0);
		}
		//find maxDistance
		double maxDistance = -1;
		for(int a = 0; a < n; a++){
			double distance = getDistance(p, inputPoints[a]);
			if(distance > maxDistance){
				maxDistance = distance;
			}
		}		

		//find mindistance
		double minDistance = Integer.MAX_VALUE;
		for(int a = 0; a < n; a++){
			double distance = getMinDistance(inputPoints[a], inputPoints[(a+1)%n], p);
			if(distance < minDistance){
				minDistance = distance;
			}
		}
		System.out.println(maxDistance * maxDistance * Math.PI - minDistance * minDistance * Math.PI);
	}
	private static double getMinDistance(Point point, Point point2, Point p) {
		Point closestPoint = ternarySearch(point, point2, p);
		return getDistance(closestPoint, p);
	}
	private static double getDistance(Point p, Point point) {
		double dx = p.x-point.x;
		double dy = p.y-point.y;
		if(dx * dx + dy * dy < 0){
			return 0;
		}
		return Math.sqrt(dx * dx + dy * dy);
	}

	public static Point ternarySearch(Point left, Point right, Point goal){
		Point leftMiddle = new Point(left.x + (right.x-left.x)*1/3.0, left.y + (right.y-left.y)*1/3.0);
		Point rightMiddle = new Point(left.x + (right.x-left.x)*2/3.0, left.y + (right.y-left.y)*2/3.0);
		if(getDistance(left, right) < .000000001){
			return left;
		}
		double distanceLeft = getDistance(left, goal);
		double distanceRight = getDistance(right, goal);
		if(distanceLeft > distanceRight){
			return ternarySearch(leftMiddle, right, goal);
		}
		else{
			return ternarySearch(left, rightMiddle, goal);
		}
	}
	public static class Point{
		double x;
		double y;
		public Point(double x2, double y2){
			x = x2;
			y = y2;
		}
	}
}
