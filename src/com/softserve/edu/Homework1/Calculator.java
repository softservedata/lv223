package testPackage;

public class Calculator {

	public double getElementN(int n) {
		int a = 1;
		for (int k = 1; k <= n; k++) {
			a = k * a + 1 / k;
		}
		return a;
	}

	public double getElem(int n) {
		if (n == 0) {
			return 1;
		} else {
			return n * getElem(n - 1) + 1 / n;
		}
	}

	public int[] randomArray(int n) {
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = (int) (Math.random() * 201 - 100);
		}
		return array;
	}

	public void printArray(int[] array) {
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+"\t");
		}
	}
	
	public String isElementPositive(int[] array) {
		String message = "All elements are zero";
		for (int i = 0; i < array.length; i++) {
			if (array[i] != 0 && array[i] < 0) {
				message = "First nonzero element is negative";
				return message;
			}
			if (array[i] != 0 && array[i] > 0) {
				message = "First nonzero element is positive";
				return message;
			}
		}
		return message;
	}
}
