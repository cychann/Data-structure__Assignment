// Lab 009	: Graph Floyd Algorithm 
// Name :
// Student ID :

import java.util.*;


class Graph {
	int numofnodes;  // the number of nodes in the graph
	private int[][] CostAdj; // Adjacency matrix
	private int[] dist; // dist array
	private int[] p; // p array

	final int LargeCost = 999999;

	Graph() { 
		// Graph constructor. 
		numofnodes = 0;
	}


	void Init(int n) { 
		numofnodes = n;
		// now create 2 dimensional array of numofnodes * numofnodes
		CostAdj = new int[numofnodes][numofnodes];
		dist = new int[numofnodes];
		p = new int[numofnodes];

		for(int i = 0; i < numofnodes; i++) {
			// initialize all entries to 0
			for(int j = 0; j < numofnodes; j++)
				CostAdj[i][j] = LargeCost;  // initialize the adjacency matrix
			CostAdj[i][i] = 0;
		}
	}
	public String toString() { 
		String str;
		int i = 0;
		str = "Dist : ";
		for(i = 0; i < numofnodes; i++)
			str +=  dist[i] + " ";
		str += "\n";
	
		str += "P    : ";
		for( i = 0; i < numofnodes; i++)
			str += p[i] + " ";
		str += "\n";
	
		// show the paths to all the destinations
		for( i = 0; i < numofnodes; i++) {
			str += "Path => " + i + " : ";
			str += OutPath(i);	
			str += "\n";
		}
		return str;
	}



	void Edge(int v1, int v2, int cost) { 
		// NEED TO IMPLEMENT
		CostAdj[v1][v2] = cost;
	}


	String OutPath(int i) {
		String str = "";

		// NEED TO IMPLEMENT
		
		if(p[i] == -1) {
			str = i + str;
		}
		else {
			str = OutPath(p[i]) + " " + i;
		}
		return str;
		
	}

	void BellmanFord(int v) { 
		// NEED TO IMPLEMENT
		for(int i=0; i<numofnodes; i++) {
			dist[i] = LargeCost;
			p[i] = -1;
		}
		dist[v] = 0;
		for(int n=0; n<numofnodes; n++) {
			for(int ptr=0; ptr<numofnodes; ptr++) {
				for(int i=0; i<numofnodes; i++) {
					if(dist[ptr] != LargeCost && dist[i] > dist[ptr] + CostAdj[ptr][i]) {
						dist[i] = dist[ptr] + CostAdj[ptr][i];
						p[i] = ptr;
					}
				}
			}
		}
	}
}




