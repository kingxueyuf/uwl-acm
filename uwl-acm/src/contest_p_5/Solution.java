package contest_p_5;

import java.util.Scanner;

public class Solution {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		int num = Integer.parseInt(line);
		for (int i = 0; i < num; i++) {
			String number = scan.nextLine();
			if (number.equals("0")) {
				System.out.println("Optimal train swapping takes 0 swaps.");
				continue;
			}

			String[] arrString = scan.nextLine().split(" ");
			int[] arr = new int[arrString.length];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = Integer.parseInt(arrString[j]);
			}
			int num1 = bubbleSort(arr);
			System.out.println("Optimal train swapping takes " + num1
					+ " swaps.");
		}
	}

	public static int bubbleSort(int[] arr) {
		int count = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] > arr[i]) {
				int tmp = arr[i - 1];
				arr[i - 1] = arr[i];
				arr[i] = tmp;
				count++;
				for (int j = i - 1; j >= 1; j--) {
					if (arr[j - 1] > arr[j]) {
						tmp = arr[j - 1];
						arr[j - 1] = arr[j];
						arr[j] = tmp;
						count++;
					} else
						break;
				}
			}
		}
		return count;
	}

}
