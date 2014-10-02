package contest_p_2;

import java.util.ArrayList;
import java.util.Scanner;

public class ProblemB {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		int shelfLength = Integer.parseInt(line);
		int pointerNum = 1;
		while (shelfLength != -1) {
			line = scan.nextLine();
			ArrayList<book> shelfList = new ArrayList<book>();
			while (!line.equals("E") || !line.equals("E")) {
				String[] commond = line.split(" ");
				if (commond[0].equals("R")) {
					for (int i = 0; i < shelfList.size(); i++) {
						if (shelfList.get(i).ID.equals(commond[1])) {
							shelfList.remove(i);
						}
					}
				}
				if (commond[0].equals("A")) {
					String bookid = commond[1];
					int bookwidth = Integer.parseInt(commond[2]);
					book newBook = new book();
					newBook.ID = bookid;
					newBook.start = 0;
					newBook.end = bookwidth;
					if (newBookCanBeAdd(newBook, shelfList, shelfLength)) {
						addToShelf(newBook, shelfList, shelfLength);
					}
				}
				line = scan.nextLine();
			}
			// ouput res
			System.out.print("PROBLEM " + pointerNum + ":");
			for (book item : shelfList) {
				System.out.print(" " + item.ID);
			}
			System.out.println();
			pointerNum++;
			line = scan.nextLine();
			shelfLength = Integer.parseInt(line);
		}
	}

	private static void addToShelf(book newBook, ArrayList<book> shelfList,
			int shelfLength) {
		book lastBook = newBook;
		if (newBook.ID.equals("15"))
			System.out.println();
		ArrayList<book> fallOffBooks = new ArrayList<book>();
		for (int i = 0; i < shelfList.size(); i++) {
			book item = shelfList.get(i);
			if (item.start < lastBook.end) {
				int move = lastBook.end - item.start;
				item.start = lastBook.end;
				item.end = item.end + move;
				if (item.end > shelfLength) {
					// System.out.println("remove"+item.ID);
					fallOffBooks.add(item);
//					System.out.println(i + " with size " + shelfList.size());
				}
				lastBook = item;
			} else {
				break;
			}
		}
		for (book i : fallOffBooks) {
			shelfList.remove(i);
		}
		shelfList.add(0, newBook);
		// for(book item: shelfList){
		// System.out.print(item.ID);
		// }
		// System.out.println();
	}

	private static boolean newBookCanBeAdd(book newBook,
			ArrayList<book> shelfList, int shelfLength) {
		if (shelfLength < newBook.end)
			return false;
		for (book item : shelfList) {
			if (item.ID.equals(newBook.ID))
				return false;
		}
		return true;
	}

}

class book {
	String ID;
	int start;
	int end;

	public boolean equals(book obj) {
		return ID.equals(obj.ID);
	}
}
