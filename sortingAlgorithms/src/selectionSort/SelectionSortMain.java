package selectionSort;

import needed.Example;
import java.util.Arrays;

public class SelectionSortMain {

	public static int[][] sort(int l) {
		int howMany = l;
		int[][] arrayOfArrays = new int[howMany][8];
		for (int m = 0; m < howMany; m++) {
			Example example = new Example();
			int[] nValues = { 10, 20, 30, 40, 50, 100, 500, 1000 };
			int[] mostlyExecutedBlockArray = new int[8];
			for (int p = 0; p < 8; p++) {
				int n = nValues[p];
				example.setMostlyExecutedBlock1(0);
				int[] unsortedArray = example.randomExample(n);
				for (int i = 0; i < n - 1; i++) {
					int now = unsortedArray[i];
					int min = now;
					int minPos = i;
					for (int j = i + 1; j < n; j++) {
						example.setMostlyExecutedBlock1(example.getMostlyExecutedBlock1() + 1);
						if (min > unsortedArray[j]) {
							min = unsortedArray[j];
							minPos = j;
						}
					}
					unsortedArray[i] = min;
					unsortedArray[minPos] = now;

				}
				mostlyExecutedBlockArray[p] = example.getMostlyExecutedBlock1();
				System.out.println(Arrays.toString(unsortedArray));
			}

			arrayOfArrays[m] = mostlyExecutedBlockArray;
		}
		return arrayOfArrays;
	}

}
