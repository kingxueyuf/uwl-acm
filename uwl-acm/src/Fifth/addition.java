package Fifth;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class addition {

	static HashMap map = new HashMap<String, Integer>();
	Integer t;
	static Stack stack;

	public static void main(String args[]) {

		map.put("0", 0);
		map.put("1", 1);
		map.put("2", 2);
		map.put("3", 3);
		map.put("4", 4);
		map.put("5", 5);
		map.put("6", 6);
		map.put("7", 7);
		map.put("8", 8);
		map.put("9", 9);
		map.put("A", 10);
		map.put("B", 11);

		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			stack = new Stack<String>();

			String oneLine = scan.nextLine();
			String[] line = oneLine.split(" ");
			String one = line[0];
			String two = line[1];
			getAdd(one, two);
			int size = stack.size();
			for (int i = 0; i < size; i++) {
				System.out.print(stack.pop());
			}
			System.out.println();
		}
	}

	public static void getAdd(String one, String two) {
		int oneLength = one.length();
		int twoLength = two.length();
		int length;
		int longerLength;
		String longerString = null;
		if (oneLength > twoLength) {
			length = twoLength;
			longerLength = oneLength;
			longerString = one;
		} else if (oneLength < twoLength) {
			length = oneLength;
			longerLength = twoLength;
			longerString = two;
		} else {
			length = oneLength;
			longerLength = twoLength;
		}
		int jinwei = 0;
		String currentDigit;
		for (int i = 0; i < length; i++) {
			String oneChar = one.charAt(one.length() - 1 - i) + "";
			String twoChar = two.charAt(two.length() - 1 - i) + "";
//			System.out.println(i);
			int oneDigit = (int) map.get(oneChar);
			int twoDigit = (int) map.get(twoChar);

			// System.out.println(oneDigit + " " + twoDigit);
			int addition = oneDigit + twoDigit + jinwei;
			jinwei = 0;
			if (addition < 12) {
				if (addition == 11) {
					currentDigit = "B";
				} else if (addition == 10) {
					currentDigit = "A";
				} else {
					currentDigit = addition + "";
				}

			} else {
				jinwei = 1;
				addition = addition - 12;
				if (addition == 10) {
					currentDigit = "A";
				} else if(addition == 11){
					currentDigit="B";
				}else{
					currentDigit = addition + "";
				}
			}
			// System.out.println(currentDigit);
			stack.push(currentDigit);
		}
		if (jinwei == 1) {
			if (length == longerLength) {
				// System.out.print(1);
				stack.push(1);
				jinwei = 0;
				return;
			}
		}
		for (int i = length; i < longerLength; i++) {
			int digit = (int) map.get(longerString.charAt(longerString.length()
					- 1 - i)
					+ "");
			int add = jinwei + digit;
			if (add == 12) {
				jinwei = 1;
				add = 0;
				// System.out.print(add);
				stack.push(add);
			} else {
				if (add == 10) {
					stack.push("A");
					// System.out.print("A");
				} else if (add == 11) {
					// System.out.print("B");
//					System.out.println(add);
					stack.push("B");
				} else {
//					 System.out.print(digit+"");
					stack.push(add);
				}
				jinwei = 0;
			}
		}

		if (jinwei == 1) {
			stack.push(1);
		}
	}
}
