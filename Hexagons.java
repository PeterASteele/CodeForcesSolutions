import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

//http://codeforces.com/contest/615/problem/E
public class Hexagons {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long n = input.nextLong();
		if(n == 0){
			System.out.println("0 0");
			System.exit(0);
		}
		long temp = n/6; // trim the edges
		long completedRows = highestRow(temp);
		long cellsInInnerRows = completedRows * (completedRows + 1)*3;
		long left = n - cellsInInnerRows;
		if(left == 0){
			System.out.println(completedRows*2 + " " + 0);
		}
		else{
			Point p = new Point(completedRows*2, 0);
			left--;
			p.moveUpRight(1);
			if(left == 0){
				print(p);
			}
			long way = completedRows+1;
			if(left < way-1){
				p.moveLeftUp(left);
				print(p);
			}
			p.moveLeftUp(way-1);
			left-= way-1;
			if(left < way){
				p.moveLeft(left);
				print(p);
			}
			p.moveLeft(way);
			left-= way;
			if(left < way){
				p.moveLeftDown(left);
				print(p);
			}
			p.moveLeftDown(way);
			left-= way;
			if(left < way){
				p.moveRightDown(left);
				print(p);
			}
			p.moveRightDown(way);
			left-= way;
			if(left < way){
				p.moveRight(left);
				print(p);
			}
			p.moveRight(way);
			left-= way;
			p.moveUpRight(left);
			print(p);
		}
	}
	public static void print(Point p){
		System.out.println(p.x + " " + p.y);
		System.exit(0);
	}
	private static class Point{
		long x;
		long y;
		public Point(long x2, long y2){
			x = x2;
			y = y2;
		}
		public void moveUpRight(long left){
			x = x + left;
			y = y + 2*left;
		}
		public void moveLeft(long n){
			x -= 2*n;
		}
		public void moveLeftDown(long n){
			x = x - n;
			y =  y - 2*n;
		}
		public void moveRightDown(long n){
			x = x + n;
			y =  y - 2*n;
		}
		public void moveRight(long n){
			x += 2*n;
		}
		public void moveLeftUp(long n){
			x = x - n;
			y = y + 2*n;
		}
		public String toString(){
			return x + " " + y;
		}
	}
	private static long highestRow(long temp) {
		long attempt = (long) Math.pow(2, 30);
		long delta = (long) Math.pow(2, 29);
		while(delta != 0){
			if((attempt * (attempt+1))/2 < temp){
				attempt += delta;
			}
			else if((attempt * (attempt+1))/2 > temp){
				attempt -= delta;
			}
			delta = delta/2;
		}
		if((attempt * (attempt+1))/2 > temp){
			attempt--;
		}
		return attempt;
	}
}
