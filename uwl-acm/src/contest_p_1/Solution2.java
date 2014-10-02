package one;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String args[]) {
		Solution s = new Solution();
		s.twoSumSmallest();
	}

	public void twoSumSmallest() {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		while (num != 0) {
			int[] arr = new int[num];
			for (int i = 0; i < num; i++) {
				arr[i] = scan.nextInt();
			}
			int res = findSmallest(num, arr);
			System.out.println(res);
			num = scan.nextInt();
		}
	}

	public int findSmallest(int num, int[] arr) {
		Arrays.sort(arr);
		//  ou shu ge
		int numOfZero = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0)
				numOfZero++;
			else
				break;
		}
		if (numOfZero > 0) {
			int numOfNonZero = num - numOfZero;
			// exit 0
			int one = 0;
			int two = 0;
			for (int i = numOfZero; i < num; i++) {
				if (i % 2 == 0)
					one = one * 10 + arr[i];
				else
					two = two * 10 + arr[i];
			}
			String oneS = one + "";
			String twoS = two + "";
//			System.out.println(numOfZero);
//			System.out.println(oneS);
//			System.out.println(twoS);
			int oneLength = oneS.length();
			int twoLength = twoS.length();
			for (int i = 0; i < numOfZero; i++) {
				if (oneLength < twoLength) {
					// insert into one first
					if (i % 2 == 0)
						oneS = insertZero(oneS);
					else
						twoS = insertZero(twoS);
				} else if (oneLength >= twoLength) {
					if (i % 2 == 0) {
						twoS = insertZero(twoS);
					} else {
						// a++;
						oneS = insertZero(oneS);

					}
				}
			}
			// System.out.println(a);
//			System.out.println(oneS);
//			System.out.println(twoS);
			// 9 0 1 2 3 4 0 1 2 3

			// 14 1 9 0 0 0 0 0 0 0 0 0 0 0 0
			one = Integer.parseInt(oneS);
			two = Integer.parseInt(twoS);
			return one + two;
		} else {
			int one = 0;
			int two = 0;
			for (int i = 0; i < num; i++) {
				if (i % 2 == 0) {
					one = one * 10 + arr[i];
				} else {
					two = two * 10 + arr[i];
				}
			}
			return one + two;
		}

	}

	public String insertZero(String one) {
		char[] arr = one.toCharArray();
		char[] newArr = new char[arr.length + 1];
		newArr[0] = arr[0];
		newArr[1] = '0';
		for (int i = 1; i < arr.length; i++) {
			newArr[i + 1] = arr[i];
		}
		return new String(newArr);
	}
}
