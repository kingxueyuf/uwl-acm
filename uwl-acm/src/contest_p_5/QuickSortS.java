package contest_p_5;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class QuickSortS {
	private int[] numbers;
	private int number;
	static int n;

	// quicksort fuction
	private void quicksort(int[] values, int first, int last) {
		// check for empety or null array
		if (values == null || values.length <= 0 || first >= last) {
			return;
		}
		this.numbers = values;
		this.number = last - first + 1;
		// p is pivot, and pivot is first element of array
		int m = 0;
		m = getMiddle(first, last); // pivot is middle element;
		// m=frist; // pivot is first element;
		// m=last; // pivot is last element;
		int p = m;
		swap(first, p);
		p = first;
		// p=first;
		// i,j is point the first element and last element of array which bigger
		// than pivot.
		int i, j, k;
		i = j = k = p + 1;// as same place with pivot
		// using for sort
		boolean test = true;
		while (k <= last) {
			if (numbers[p] <= numbers[k]) {
				if (i == p + 1 && test) {
					i = k;
					test = false;
				}
				j = k;
				++k;
			} else {
				swap(i, k);
				++i;
				j = k;
				++k;
			}
		}
		// change the position of pivot
		int ptemp = 0;
		if (j == p + 1) {
			if (numbers[p] > numbers[last])
				swap(p, last);
			i = j = last;
			ptemp = last;
		} else {
			swap(p, i - 1);
			ptemp = i - 1;
		}
		n += last - first;
		quicksort(numbers, first, ptemp - 1);
		quicksort(numbers, ptemp + 1, last);
	}

	// using for exchange two number
	private void swap(int i, int j) {
		if (i == j)
			return;
		else {
			int temp = this.numbers[i];
			this.numbers[i] = this.numbers[j];
			this.numbers[j] = temp;
		}

	}

	private void printAraay(int arr[]) {
		for (int i = 0; i < arr.length; ++i) {
			System.out.println(arr[i]);
		}
	}

	private int getMiddle(int begin, int over) {
		int temp = 0;
		temp = begin + (over - begin) / 2;
		return temp;
	}

	public static void main(String args[]) {
		try {
			// Open the file that is the first
			// command line parameter
			FileInputStream fstream = new FileInputStream("QuickSort.txt"); // in
																			// this
																			// file
																			// have
																			// some
																			// integers
																			// which
																			// we
																			// want
																			// to
																			// sort,
																			// each
			// integer at one row
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			// in.close();
			String strLine;
			int[] No;
			No = new int[10000];
			// Read File Line By Line
			int i = 0;
			while ((strLine = br.readLine()) != null) {
				// Print the content on the console
				// System.out.println (strLine);
				No[i] = Integer.valueOf(strLine).intValue();
				++i;

			}
			// Close the input stream
			in.close();

			QuickSortS a = new QuickSortS();
			a.quicksort(No, 0, 9999);
			a.printAraay(No);
			System.out.println("---" + n + "----");

		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
}
