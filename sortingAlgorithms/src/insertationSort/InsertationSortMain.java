package insertationSort;
import java.time.Duration;
import java.time.Instant;
import needed.Example;
import java.util.Arrays;

public class InsertationSortMain {

	public static long[][] sort(int l) {
		int howMany = l;
		int[][] arrayOfArrays = new int[howMany][8];
		long[][] second = new long[howMany][8];
			for (int m = 0; m < howMany; m++) {
			Example example = new Example();
			int[] nValues = { 10, 20, 30, 40, 50, 100, 500, 1000 };
			int[] mostlyExecutedBlockArray = new int[8];
			long[] durationarray = new long[8];

			for (int p = 0; p < 8; p++) {
				long startTime = System.nanoTime();
				int n = nValues[p];
				example.setMostlyExecutedBlock1(0);
				example.setMostlyExecutedBlock2(0);
				int[] nonsortedExample = example.randomExample(n);
				for (int i = 1; i < n; i++) {
					int recentlyGettingSorted = nonsortedExample[i];
					int thePartThatDoesntShift = -1;
					for (int j = i - 1; j > -1; j--) {
						example.setMostlyExecutedBlock1(example.getMostlyExecutedBlock1() + 1);
						if (nonsortedExample[j] <= nonsortedExample[i]) {
							thePartThatDoesntShift = j;
							break;
						}
					}
					for (int k = i - 1; thePartThatDoesntShift < k; k--) {
						example.setMostlyExecutedBlock2(example.getMostlyExecutedBlock2() + 1);
						nonsortedExample[k + 1] = nonsortedExample[k];

					}
					nonsortedExample[thePartThatDoesntShift + 1] = recentlyGettingSorted;
				}
				if (example.getMostlyExecutedBlock1() > example.getMostlyExecutedBlock2()) {
					mostlyExecutedBlockArray[p] = example.getMostlyExecutedBlock1();
				} else {
					mostlyExecutedBlockArray[p] = example.getMostlyExecutedBlock2();
				}
				System.out.println(Arrays.toString(nonsortedExample));
				long endTime = System.nanoTime();
				long duration = ((endTime - startTime));
				durationarray[p] = duration;
				

			}

			arrayOfArrays[m] = mostlyExecutedBlockArray;
			second[m] = durationarray;

		}
		return second;
	}
}
