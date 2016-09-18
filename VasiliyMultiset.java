import java.util.Scanner;
//http://codeforces.com/problemset/problem/706/D
public class VasiliyMultiset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int q = input.nextInt();
		XorLazyNodingSegmentTree lazyNodingTree = new XorLazyNodingSegmentTree(
				0, Integer.MAX_VALUE);
		lazyNodingTree.insert(0);
		for (int a = 0; a < q; a++) {
//			System.out.println(lazyNodingTree);

			String queryType = input.next();
			int val = input.nextInt();
			if (queryType.equals("+")) {
				lazyNodingTree.insert(val);
			}
			if (queryType.equals("-")) {
				lazyNodingTree.remove(val);
			}
			if (queryType.equals("?")) {
				int ans = lazyNodingTree.XORQUERY(val);
				System.out.println(ans);
			}
		}
	}

	public static class XorLazyNodingSegmentTree {
		XorLazyNodingSegmentTree left;
		XorLazyNodingSegmentTree right;
		int leftIdx;
		int rightIdx;
		int frequency;

		public XorLazyNodingSegmentTree(int l, int r) {
			left = null;
			right = null;
			leftIdx = l;
			rightIdx = r;
		}

		public void insert(int insertThis) {
			if (insertThis < leftIdx || insertThis > rightIdx) {
				return;
			}
			frequency++;
			if (leftIdx == rightIdx) {
				return;
			} else {
				if (left == null) {
					left = new XorLazyNodingSegmentTree(leftIdx,
							(leftIdx + rightIdx) / 2);
				}
				if (right == null) {
					right = new XorLazyNodingSegmentTree(
							(leftIdx + rightIdx) / 2 + 1, rightIdx);
				}

				if (insertThis <= (leftIdx + rightIdx) / 2) {
					left.insert(insertThis);
				} else {
					right.insert(insertThis);
				}
			}
		}

		public void remove(int removeThis) {
			if (removeThis < leftIdx || removeThis > rightIdx) {
				return;
			}
			frequency--;
			if (leftIdx == rightIdx) {
				return;
			} else {
				if (left == null) {
					left = new XorLazyNodingSegmentTree(leftIdx,
							(leftIdx + rightIdx) / 2);
				}
				if (right == null) {
					right = new XorLazyNodingSegmentTree(
							(leftIdx + rightIdx) / 2 + 1, rightIdx);
				}

				if (removeThis <= (leftIdx + rightIdx) / 2) {
					left.remove(removeThis);
				} else {
					right.remove(removeThis);
				}
			}
		}

		public int XORQUERY(int query) {
//			System.out.println("Calling xorQuery" + query + " " + leftIdx + " "
//					+ rightIdx);
			if (leftIdx == rightIdx) {
				return query ^ leftIdx;
			}
			
			if ((query ^ leftIdx) >= (query ^ rightIdx) && left.frequency > 0) {
				return left.XORQUERY(query);
			} else {
				if(!(right.frequency > 0)){
					return left.XORQUERY(query);
				}
				return right.XORQUERY(query);
			}
		}

		public String toString() {
			if (leftIdx != rightIdx) {
				return leftIdx + " " + rightIdx + " : " + frequency + "\n "
						+ left + " \n " + right;
			} else {
				return leftIdx + " " + rightIdx + " : " + frequency;
			}
		}
	}

}