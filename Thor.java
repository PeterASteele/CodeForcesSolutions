import java.io.*;
import java.util.*;
//http://codeforces.com/problemset/problem/704/A
public class Thor {
	private static class Notification {
		boolean read = false;
		int index;
		int app;

		Notification(int index, int app) {
			this.index = index;
			this.app = app;
		}
	}

	public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer line = new StringTokenizer(input.readLine());

		int n = Integer.parseInt(line.nextToken());
		int q = Integer.parseInt(line.nextToken());
		ArrayList<Notification> all = new ArrayList<Notification>(q);
		ArrayList<ArrayDeque<Notification>> queues = new ArrayList<ArrayDeque<Notification>>(n);
		StringBuilder output = new StringBuilder();
		String newline = System.lineSeparator();

		for (int i = 0; i < n; i++) {
			queues.add(new ArrayDeque<Notification>());
		}
		int nextIndex = 0;
		int readUpTo = 0;
		int unread = 0;

		for (int i = 0; i < q; i++) {
			line = new StringTokenizer(input.readLine());
			int type = Integer.parseInt(line.nextToken());

			if (type == 1) {
				int x = Integer.parseInt(line.nextToken()) - 1;
				Notification notification = new Notification(nextIndex, x);
				all.add(notification);
				queues.get(notification.app).offer(notification);
				nextIndex++;
				unread++;
			} else if (type == 2) {
				int x = Integer.parseInt(line.nextToken()) - 1;
				for (Notification no : queues.get(x)) {
					if (!no.read) {
						unread--;
						no.read = true;
					}
				}
				queues.get(x).clear();
			} else {
				int t = Integer.parseInt(line.nextToken());
				if (t > readUpTo) {
					for (int j = readUpTo; j < t; j++) {
						if (!all.get(j).read) {
							unread--;
							all.get(j).read = true;
						}
					}
					readUpTo = t;
				}
			}
			output.append(unread + newline);
		}
		System.out.print(output.toString());
	}
}