package contest_p_6;

import java.util.Scanner;

public class CircuitBuilder {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		while (!line.equals("0 0")) {
			String[] arr = line.split(" ");
			int x = Integer.parseInt(arr[0]);
			int y = Integer.parseInt(arr[1]);
			if (x == 1) {
				System.out.println("("+x+" x "+y+"): "+1);
			} else if (y == 1) {
				System.out.println("("+x+" x "+y+"): "+1);
			} else {
				int xt = x - 1;
				int yt = y - 1;
				long res = C(xt + yt, Math.min(xt, yt));
				System.out.println("("+x+" x "+y+"): "+res);
			}
			line = scan.nextLine();
		}
	}

	private static long C(int i, int x) {
		// TODO Auto-generated method stub
		long up = 1;
		for (int a = 0; a < x; a++) {
			up = up * (i - a);
//			System.out.println(i-a);
		}
//		System.out.println("up"+up);
		long down = 1;
		for (int b = 1; b <= x; b++) {
			down = down * b;
//			System.out.println(b);
		}
//		System.out.println("down"+down);
		return up / down;
	}
	
	
}
