
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class ProblemG {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		String num = scan.nextLine();
		for (int a = 0; a < Integer.parseInt(num); a++) {
			String line = scan.nextLine();
			String[] arr = line.split(" ");
			int n = Integer.parseInt(arr[0]);
			int d = Integer.parseInt(arr[1]);
			int b = Integer.parseInt(arr[2]);
			int e = Integer.parseInt(arr[3]);
			BigDecimal n1 = new BigDecimal(n);
			BigDecimal d1 = new BigDecimal(d);
			BigDecimal res = n1.divide(d1, e + 1, RoundingMode.CEILING);

			StringBuilder sb = new StringBuilder();
			int amount = 0;
			while (amount <= e) {
				res = res.subtract(new BigDecimal(res.intValue()));
				res = res.multiply(new BigDecimal("7"));
				sb.append(res.intValue());
				amount++;
			}
			char[] resArr = sb.toString().toCharArray();
			StringBuilder sb2 = new StringBuilder();
			for (int i = b; i <= e; i++) {
				sb2.append(resArr[i]);
			}
			System.out.println(sb2.toString());
		}
	}
}
