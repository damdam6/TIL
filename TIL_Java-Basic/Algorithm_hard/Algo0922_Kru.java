package BasicStudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo0922_Kru {

	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {

			return Integer.compare(this.weight, o.weight);
		}

	}

	static Edge[] edgeList;
	static int V, E;
	static int[] p;

	static void make() {
		p = new int[V];
		for (int i = 0; i < V; i++) {
			p[i] = i;
		}

	}

	static int find(int a) {
		if (p[a] == a)
			return a;

		return p[a] = find(p[a]);
	}

	static boolean union(int a, int b) {
		int aR = find(a);
		int bR = find(b);

		if (aR == bR)
			return false;

		//Rank체킹은 안했으니 알아서 함 해봐야함
		p[bR] = aR;
		return true;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		//여기에 간선 받는 코드
		
		make();
		
		
		int result = 0;
		int count = 0;
		
		for(Edge edge : edgeList) {
			if(union(edge.from, edge.to)) {
				result += edge.weight;
				if(++count==V-1)break;
			}
		}
	}

}
