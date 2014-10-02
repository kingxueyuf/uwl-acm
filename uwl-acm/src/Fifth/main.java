import java.util.ArrayList;
import java.util.Scanner;

public class main {

	static int[] arr_x;
	static int[] arr_y;

	public static void main(String args[]) {

		ArrayList list = new ArrayList();
		Scanner scan = new Scanner(System.in);
		while (true) {

			int count = scan.nextInt();
			if (count == 0) {
				System.exit(0);
			}
			arr_x = new int[count];
			arr_y = new int[count];
			for (int i = 0; i < count; i++) {
				arr_x[i] = scan.nextInt();
				arr_y[i] = scan.nextInt();
			}
			// find the max of arr_x
			int maxX = findMax(arr_x);
			int maxY = findMax(arr_y);
			int minX = findMin(arr_x);
			int minY = findMin(arr_y);

			int minlength = 999999999;
			int length = 0;
			int resX = 0;
			int resY = 0;
			for (int x = minX; x < maxX + 1; x++) {
				for (int y = minY; y < maxY + 1; y++) {
					length = calculate(x, y, count);
					if (length < minlength) {
						resX = x;
						resY = y;
						minlength = length;
					}
				}
			}

			// int maxPoint = 0;
			// for(int i = 0;i<list.size() ;i++)
			// {
			// if( (int)list.get(maxPoint)<(int)list.get(i) )
			// {
			// maxPoint = i;
			// }
			// }
			System.out.println("Case 1: " + "(" + resX + "," + resY + ")" + " "
					+ minlength);
		}
	}

	public static int calculate(int x, int y, int count) {
		int distance = 0;
		for (int i = 0; i < count; i++) {
			distance += Math.abs(x - arr_x[i]) + Math.abs(y - arr_y[i]);
		}
		return distance;
	}

	public static int findMax(int[] array) {
		int point = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[point] < array[i]) {
				point = i;
			}
		}
		return array[point];
	}

	public static int findMin(int[] array) {
		int point = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[point] > array[i]) {
				point = i;
			}
		}
		return array[point];
	}
}
