// Lab 007	: Disjoint Sets
// Name :
// Student ID :

import java.util.*;


class DisjointSets {
	int numofelements;  // the total number of elements in all the disjoint sets
	private int[] parent; // maintains the parent pointer of each element in the disjoint sets
	private int[] weight; // maintains the weight of each set


	DisjointSets() { 
		// DisjointSets constructor. 
	}

	public String toString() { // Show all the element in sequence
		String str = new String();
	    // Show the array elements in parent[]

		str = "parent[]: - ";
		for(int i = 1; i <= numofelements; i++)
			str += parent[i] + " ";
		return str;
	}

	void InitSet(int n) { 
		// Initialize the array parent[] and weight[]
		numofelements = n;
		parent = new int[n+1];
		weight = new int[n+1];
		for(int i=1; i<=numofelements; i++) {
			parent[i] = 0;
			weight[i] = 1;
		}

	}

	boolean Union(int i, int j) { 
	// Union the set that contains i and the set that contains j
	// the set that has larger weight is the new root of the unioned set
	// when the weights are the same, choose the root of smaller value

		// first find the root of i and j
		int rooti = SimpleFind(i);
		int rootj = SimpleFind(j);
		
		if(rooti == rootj)	return false;
		
		if(weight[rooti] < weight[rootj]) {
			parent[rooti] = rootj;
			weight[rootj] += weight[rooti];
		}
		else if(weight[rooti] > weight[rootj]) {
			parent[rootj] = rooti;
			weight[rooti] += weight[rootj];
		}
		else {
			if(rooti<rootj) {
				parent[rooti] = rootj;
				weight[rootj] += weight[rooti];
			}
			else if(rooti>rootj) {
				parent[rootj] = rooti;
				weight[rooti] += weight[rootj];
			}
		}
		
		return true;
	}

	int SimpleFind(int i) {
	// return the root node that contains the element i

		
		if(parent[i] == 0)	return i;
		
		else {
			return SimpleFind(parent[i]);
			/*int root = SimpleFind(parent[i]);
			parent[i] = root;
			return root;*/
		}
	
	}
}

