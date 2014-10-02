
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Solution {

	/*
	 * 8 UVWXYZNOPQRSTHIJKLMABCDEFG ANTLER ANY COW HILL HOW HOWEVER WHATEVER
	 * ZONE
	 */
	public static void main(String args[]) {
		Solution s = new Solution();
		s.sort();
	}

	public void sort() {
		LinkedHashMap<String, ArrayList<String>> map = new LinkedHashMap<String, ArrayList<String>>();

		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		while (num != 0) {
			map = new LinkedHashMap<String, ArrayList<String>>();
			String table = scan.next();
			char[] arr = table.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				map.put(arr[i] + "", new ArrayList<String>());
				// System.out.println(arr[i]);
			}
			String current = null;
			for (int i = 0; i < num; i++) {
				current = scan.next();
				ArrayList<String> currentList = map.get(current.charAt(0) + "");
				addToList(arr, currentList, current);
				map.put(current.charAt(0) + "", currentList);
			}
			// System.out.println("here");
			for (String key : map.keySet()) {
				ArrayList<String> list = map.get(key);
				// System.out.println(list.size());
				if (list.size() != 0) {
					for (int i = 0; i < list.size(); i++) {
						System.out.println(list.get(i));
					}
				}
			}
			num = scan.nextInt();
		}
	}

	public void addToList(char[] order, ArrayList<String> list, String newString) {
		if (list.size() == 0) {
			list.add(0, newString);
			return;
		}

		for (int i = 0; i < list.size(); i++) {
			char[] newArr = newString.toCharArray();
			char[] itemArr = list.get(i).toCharArray();
			int minLength = Math.min(newArr.length, itemArr.length);
			boolean balance = true;
			for (int j = 0; j < minLength; j++) {
				if (newArr[j] == itemArr[j])
					continue;
				if (isBigger(newArr[j] + "", itemArr[j] + "", order)) {
					list.add(i, newString);
					return;
				} else {
					balance = false;
					break;
				}
			}
			if (balance) {
				if (newArr.length == minLength) {
					list.add(i, newString);
				}
			}
		}
	}

	public boolean isBigger(String newS, String itemS, char[] order) {

		ArrayList<String> orderS = new ArrayList<String>();
		for (int i = 0; i < order.length; i++) {
			orderS.add(order[i] + "");
		}
		if (orderS.indexOf(newS) < orderS.indexOf(itemS))
			return true;
		return false;
	}
}
