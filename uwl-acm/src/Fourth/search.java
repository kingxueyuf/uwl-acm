import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class search {

	public static void main(String args[]) {
		new search().run();
	}

	HashMap<String, Node> map;
	HashSet<String> set;
	ArrayList<String> result;
	int time = 0;
	int caseNum = 1;

	public void run() {
		Scanner scan = new Scanner(System.in);

		while (scan.hasNext()) {
			time = 0;
			String endPoint = scan.nextLine();

			map = new HashMap<String, Node>();
			set = new HashSet<String>();
			result = new ArrayList<String>();
			while (true) {
				String oneLine = scan.nextLine();
				if (oneLine.equals("0 0"))
					break;
				String[] arr = oneLine.split(" ");
				Node node = null;
				Node node1 = null;
				if (map.get(arr[0]) == null) {
					node = new Node(arr[0]);
					map.put(arr[0], node);

				} else {
					node = map.get(arr[0]);
				}
				if (map.get(arr[1]) == null) {
					node1 = new Node(arr[1]);
					map.put(arr[1], node1);
				} else {
					node1 = map.get(arr[1]);
				}
				// set connection between arr[0] and arr[1]
				// set arr[0];
				node.list.add(node1);
				node1.list.add(node);
			}
			Node node = this.map.get("1");
			System.out.println("CASE " + this.caseNum + ":");
			caseNum++;
			if (endPoint.equals("1")) {
				System.out.println(1);
			} else {
				solve(node, endPoint);
			}
			System.out.println("There are " + this.time
					+ " routes from firestation to streetcorner " + endPoint);
		}
	}

	public void solve(Node node, String endPoint) {
		this.result.add(node.number);
		this.set.add(node.number);
		if (node.number.equals(endPoint)) {
			this.time++;
			output();
		}
		ArrayList<Node> list = node.list;
		for (int i = 0; i < list.size(); i++) {
			Node nextNode = list.get(i);
			if (set.contains(nextNode.number)) {
				continue;
			} else {
				solve(nextNode, endPoint);

			}
		}
		if ( time == 0 && node.number.equals(1)) {
			System.out.println("no path");
			return;
		}
		this.result.remove(node.number);
		this.set.remove(node.number);
	}

	public void output() {
		for (int i = 0; i < this.result.size(); i++) {
			System.out.print(result.get(i) + " ");
		}
		System.out.println();
	}

	class Node {
		String number;
		ArrayList<Node> list;

		Node(String num) {
			this.number = num;
			list = new ArrayList<Node>();
		}

	}
}

//6
//1 2
//1 3
//3 4
//3 5
//4 6
//5 6
//2 3
//2 4
//0 0

// 4
// 2 3
// 3 4
// 5 1
// 1 6
// 7 8
// 8 9
// 2 5
// 5 7
// 3 1
// 1 8
// 4 6
// 6 9
// 0 0
