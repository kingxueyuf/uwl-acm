package contest_p_5;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class AgeSort {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();

		while (!line.equals("0")) {
			String[] arrString = scan.nextLine().split(" ");
			int[] arr = new int[101];
			for (int i = 0; i < arrString.length; i++) {
				int a = Integer.parseInt(arrString[i]);
				arr[a]++;
			}

			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i]; j++) {
					System.out.print(i+" ");
				}
			}
			System.out.println();
			line = scan.nextLine();
		}
	}
}
