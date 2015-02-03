package contest_p_6;

import java.util.Scanner;

public class Problem6 {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String line = scan.nextLine();
			String a = line.split(" ")[0];
			String b = line.split(" ")[1];
			char[] arr1 = a.toCharArray();
			char[] arr2 = b.toCharArray();
			long a1res = 0;
			int powN = 0;
			for (int i = arr1.length - 1; i > -1; i--) {
				if (arr1[i] == 'A') {
					a1res += 10 * Math.pow(12, powN);
				} else if (arr1[i] == 'B') {
					a1res += 11 * Math.pow(12, powN);
				} else {
					a1res += Integer.parseInt(arr1[i] + "") * Math.pow(12, powN);
				}
				powN++;
			}
			
			long a2res = 0;
			powN = 0;
			for (int i = arr2.length - 1; i > -1; i--) {
				if (arr2[i] == 'A') {
					a2res += 10 * Math.pow(12, powN);
				} else if (arr2[i] == 'B') {
					a2res += 11 * Math.pow(12, powN);
				} else {
					a2res += Integer.parseInt(arr2[i] + "") * Math.pow(12, powN);
				}
				powN++;
			}
			long res = a1res + a2res;
			System.out.println(Long.toString(res,12).toUpperCase());
			
		}
	}
}
