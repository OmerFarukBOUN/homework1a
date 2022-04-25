package quickSort;

import needed.Example;
import java.util.Arrays;

public class QuickSortMain {

	public static int[][] sort(int l) {
		int howMany = l;
		int[][] arrayOfArrays = new int[howMany][8];
		for (int m = 0; m < howMany; m++) {
			Example example = new Example();
			int[] nValues = { 10, 20, 30, 40, 50, 100, 500, 1000 };
			int[] mostlyExecutedBlockArray = new int[8];
			for (int p = 0; p < 8; p++) {
				example.setMostlyExecutedBlock1(0);
				example.setMostlyExecutedBlock2(0);
				int n = nValues[p];
				int[] exampleArray = example.randomExample(n);
				System.out.println(Arrays.toString(quickSort(exampleArray)));
				if (example.getMostlyExecutedBlock1() > example.getMostlyExecutedBlock2()) {
					mostlyExecutedBlockArray[p] = example.getMostlyExecutedBlock1();
				} else {
					mostlyExecutedBlockArray[p] = example.getMostlyExecutedBlock2();
				}
			}
			System.out.println(Arrays.toString(mostlyExecutedBlockArray));

			arrayOfArrays[m] = mostlyExecutedBlockArray;
		}
		return arrayOfArrays;
	}

	public static int[] quickSort(int[] array) {
		Example example = new Example();

		int arrayLenght = array.length;
		if (arrayLenght < 2) {
			return array;
		}

		int insertNewElementHereLesser = 0;
		int insertNewElementHereBigger = 0;
		int firstElement = array[0];
		for (int i = 1; i < arrayLenght; i++) {
			example.setMostlyExecutedBlock1(example.getMostlyExecutedBlock1() + 1);
			if (array[i] < firstElement) {
				insertNewElementHereLesser++;
			} else {
				insertNewElementHereBigger++;
			}

		}
		int[] lesser = new int[insertNewElementHereLesser];
		int lesserLenght = insertNewElementHereLesser;
		insertNewElementHereLesser = 0;
		int[] bigger = new int[insertNewElementHereBigger];
		int biggerLenght = insertNewElementHereBigger;
		insertNewElementHereBigger = 0;
		for (int i = 1; i < arrayLenght; i++) {
			example.setMostlyExecutedBlock2(example.getMostlyExecutedBlock2() + 1);
			if (array[i] < firstElement) {
				lesser[insertNewElementHereLesser] = array[i];
				insertNewElementHereLesser++;
			} else {
				bigger[insertNewElementHereBigger] = array[i];
				insertNewElementHereBigger++;
			}
		}
		System.arraycopy(quickSort(lesser), 0, array, 0, lesserLenght);
		array[lesserLenght] = firstElement;
		System.arraycopy(quickSort(bigger), 0, array, lesserLenght + 1, biggerLenght);
		return array;

	}

}
