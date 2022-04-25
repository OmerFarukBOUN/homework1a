package needed;

import java.util.Random;

public class Example {
	public static int mostlyExecutedBlock1;
	public static int mostlyExecutedBlock2;

	public int getMostlyExecutedBlock1() {
		return mostlyExecutedBlock1;
	}

	public void setMostlyExecutedBlock1(int mostlyExecutedBlock1) {
		Example.mostlyExecutedBlock1 = mostlyExecutedBlock1;
	}

	public int getMostlyExecutedBlock2() {
		return mostlyExecutedBlock2;
	}

	public void setMostlyExecutedBlock2(int mostlyExecutedBlock2) {
		Example.mostlyExecutedBlock2 = mostlyExecutedBlock2;
	}

	public int[] randomExample(int n) {
		Random random = new Random();
		int[] newArray = new int[n];
		for (int i = 0; i < n; i++) {
			newArray[i] = random.nextInt(10000);
		}
		return newArray;
	}

	public int[] worstCaseExample(int n) {
		int[] newArray = new int[n];
		for (int i = 0; i < n; i++) {
			newArray[i] = n - i;
		}
		return newArray;
	}

	public int[] bestCaseExample(int n) {
		int[] newArray = new int[n];
		for (int i = 0; i < n; i++) {
			newArray[i] = i;
		}
		return newArray;
	}
}
