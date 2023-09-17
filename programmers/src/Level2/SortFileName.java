package Level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortFileName {

	static class File {
		String upperHead;
		int number;
		int seq;
		String originalString;

		public File(String upperHead, int number, int seq, String originalString) {
			this.upperHead = upperHead;
			this.number = number;
			this.seq = seq;
			this.originalString = originalString;
		}
	}

	static ArrayList<File> list;

	public String[] solution(String[] files) {
		list = new ArrayList<>();

		inputFile(files);
		fileSort();

		String[] answer = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			File f = list.get(i);
			answer[i] = f.originalString;
		}
		return answer;
	}

	static void inputFile(String[] files) {
		for (int i = 0; i < files.length; i++) {
			String file = files[i];
			String head = "";
			String number = "";

			boolean headCheck = false;
			boolean numberCheck = false;

			for (int j = 0; j < file.length(); j++) {
				char ch = file.charAt(j);
				if (ch >= '0' && ch <= '9') {
					headCheck = true;
				}
				if (headCheck && (ch < '0' || ch > '9')) {
					numberCheck = true;
				}
				if (!headCheck) {
					head += ch;
					continue;
				}
				if (headCheck && !numberCheck) {
					number += ch;
					continue;
				}
			}

			int numberInt = Integer.parseInt(number);
			list.add(new File(head.toUpperCase(), numberInt, i, file));
		}
	}

	static void fileSort() {
		Collections.sort(list, new Comparator<File>() {
			public int compare(File f1, File f2) {
				if (f1.upperHead.equals(f2.upperHead)) {
					if (f1.number == f2.number) {
						return f1.seq - f2.seq;
					}
					return f1.number - f2.number;
				}
				return f1.upperHead.compareTo(f2.upperHead);
			}
		});
	}
}