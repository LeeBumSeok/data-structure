// Lab 008	: Graph Floyd Algorithm 
// Name : leebumseok
// Student ID : 20171664

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
		CostAdj[v1][v2] = cost;
	}


	String OutPath(int i) { 
		String str = "";
		int tmp;
		tmp = i;

		while(p[tmp] != -1) {
			str = tmp + " " + str;
			tmp = p[tmp];
		}

		for(int j = 0; j < numofnodes; j++) {
			if(p[j] == -1) {
				str = j + " " + str;
				break;
			}
		}
		return str;
	}

	void BellmanFord(int v) { 
		for(int i = 0; i < numofnodes; i++) {
			dist[i] = LargeCost;
			p[i] = -1;
		}
		dist[v] = 0;

		for(int i = 0; i < numofnodes; i++) {
			for(int j = 0; j < numofnodes; j++) {
				for(int k = 0; k < numofnodes; k++) {
					if(dist[j] + CostAdj[j][k] < dist[k]) {
						dist[k] = dist[j] + CostAdj[j][k];
						p[k] = j;
					}
				}
			}
		}
	}
}




