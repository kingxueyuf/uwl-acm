package contest_p_3;

import java.util.Scanner;

public class ProblemD {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		while (!line.equals("0 0 0 0")) {
			String[] arr = line.split(" ");
			if (Integer.parseInt(arr[2]) > Integer.parseInt(arr[3])) {
				if (Integer.parseInt(arr[0]) < Integer.parseInt(arr[1])) {
					String tmp = arr[1];
					arr[1] = arr[0];
					arr[0] = tmp;
				}
			} else {
				if (Integer.parseInt(arr[0]) > Integer.parseInt(arr[1])) {
					String tmp = arr[1];
					arr[1] = arr[0];
					arr[0] = tmp;
				}
			}
			double first = Double.parseDouble(arr[0]);
			double second = Double.parseDouble(arr[1]);
			double third = Double.parseDouble(arr[2]);
			double fourth = Double.parseDouble(arr[3]);
			if (first <= third && second <= fourth)
				System.out.println("100%");
			else {
				double res1 = third / first;
				double res2 = fourth / second;
				double min = Math.min(res1, res2);
				int res = (int) (min * 100);
				System.out.println(res + "%");
			}
			line = scan.nextLine();
		}
	}
}
