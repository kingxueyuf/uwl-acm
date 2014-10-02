package contest_p_4;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		while (!line.equals("0")) {
			String[] arr = line.split(" ");
			int colorTypes = Integer.parseInt(arr[0]);
			int gray = Integer.parseInt(arr[arr.length - 1]);
			int[] colorNeed = new int[arr.length - 2];
			for (int i = 0; i < colorNeed.length; i++) {
				colorNeed[i] = Integer.parseInt(arr[i + 1]);
			}
			Arrays.sort(colorNeed);
			int max = colorNeed[colorNeed.length - 1];
			int kits = max / 50 + ((max % 50 == 0) ? 0 : 1);
			for (int i = 0; i < colorNeed.length; i++) {
				colorNeed[i] = kits * 50 - colorNeed[i];
			}
			boolean find = false;
			if (gray == 0) {
				System.out.println(kits);
				line = scan.nextLine();
				continue;
			}
			while (!find) {
				Arrays.sort(colorNeed);
				find = false;
				while (colorNeed[colorNeed.length - 3] != 0) {
					colorNeed[colorNeed.length - 1]--;
					colorNeed[colorNeed.length - 2]--;
					colorNeed[colorNeed.length - 3]--;
					gray--;
					if (gray == 0) {
						find = true;
						break;
					}
					Arrays.sort(colorNeed);
				}
				if (find)
					System.out.println(kits);
				else {
					kits++;
					for (int i = 0; i < colorNeed.length; i++) {
						colorNeed[i] += 50;
					}
				}
			}
			line = scan.nextLine();
		}
	}
}
