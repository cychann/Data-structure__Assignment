// Lab 010	: Natural Merge
// Name :
// Student ID :

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
		int chk = 0;
		for(int i=0; i<noe; i++) {
			if(chk > inputArray[i]) {
				m = i;
			}
			chk = inputArray[i];
		}
		int[] arr1 = new int[m];
		int[] arr2 = new int[noe-m];
		for(int i=0; i<m; i++) {
			arr1[i] = inputArray[i];
		}
		for(int i=m; i<noe; i++) {
			arr2[i-m] = inputArray[i];
		}
		int pos1 = 0;
		int pos2 = 0;
		int pos3 = 0;
		
		while(pos1 < m && pos2 < noe-m) {
			if(arr1[pos1] >= arr2[pos2]) {
				outputArray[pos3] = arr2[pos2];
				pos2++;
				pos3++;
			}
			else if(arr1[pos1] < arr2[pos2]) {
				outputArray[pos3] = arr1[pos1];
				pos1++;
				pos3++;
			}
		}
		for(; pos1 < m; pos1++) {
			outputArray[pos3] = arr1[pos1];
			pos3++;
		}
		for(; pos2 < noe-m; pos2++) {
			outputArray[pos3] = arr2[pos2];
			pos3++;
		}
		
		
		
		

		System.out.println("m = " + m + ", n = " + noe);

		// NEED TO IMPLEMENT


	}
}


