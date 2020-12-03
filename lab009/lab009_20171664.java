// Lab 010	: Natural Merge
// Name : lee bumseok
// Student ID : 20171664

import java.util.*;


class NaturalMerge {
	int noe;  // the number of elements
	private int[] inputArray; // input array 
	int[] outputArray; // output array 


	NaturalMerge() { 
		noe = 0;
	}

	void Init(int [] arr, int n) { 
		noe = n;
		inputArray = new int[noe];
		System.arraycopy(arr, 0, inputArray, 0, n);

		outputArray = new int[noe];
	}

	void Merge() { 
		int m = 0;

		for(int i = 0; i < noe; i++) {
			if(inputArray[i] > inputArray[i + 1]) {
				m = i + 1;
				break;
			}
		}
		
		System.out.println("m = " + m + ", n = " + noe);

		int[] firstArr = new int[m];
		int[] secondArr = new int[noe - m];

		System.arraycopy(inputArray, 0, firstArr, 0,  m);
		System.arraycopy(inputArray, m, secondArr, 0, noe - m);

		int firstIdx = 0;
		int secondIdx = 0;
		int totalIdx = 0;

		while(firstIdx < firstArr.length && secondIdx < secondArr.length) outputArray[totalIdx++] = firstArr[firstIdx] < secondArr[secondIdx] ? firstArr[firstIdx++] : secondArr[secondIdx++];
		while(firstIdx < firstArr.length) outputArray[totalIdx++] = firstArr[firstIdx++];
		while(secondIdx < secondArr.length) outputArray[totalIdx++] = secondArr[secondIdx++];
	}
}


