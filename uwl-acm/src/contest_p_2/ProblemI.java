package contest_practice_3;

import java.util.Scanner;

public class ProblemI {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		while (!line.equals("#")) {
			String[] arr = line.split(" ");
			if (isSuspicious(arr)) {
				System.out.println("suspicious");
			} else {
				System.out.println("OK");
			}
			line = scan.nextLine();
		}
	}

	private static boolean isSuspicious(String[] arr) {
		// TODO Auto-generated method stub
		String punctutations = ".,:;[]_'!";
		for (String s : arr) {
			char[] arr1 = s.toCharArray();
			if (arr1.length == 1) {
				if (arr1[0] != 'a' || arr1[0] != 'A' || arr1[0] != 'I') {

				} else
					return true;
			} else {
				for (int i = 0; i < arr1.length - 1; i++) {
					if (Character.isUpperCase(arr1[i])
							&& Character.isUpperCase(arr1[i + 1])) {
						return true;
					}
					if (Character.isDigit(arr1[i])
							&& Character.isLetter(arr1[i + 1])) {
						return true;
					}
					if (Character.isLetter(arr1[i])
							&& Character.isDigit(arr1[i + 1])) {
						return true;
					}
					if(punctutations.contains(arr1[i]+"") &&punctutations.contains(arr1[i+1]+"")){
						return true;
					}
				}
			}
		}
		return false;
	}
}
