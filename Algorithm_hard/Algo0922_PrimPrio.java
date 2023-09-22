package BasicStudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Algo0922_PrimPrio {

	static class Vertex implements Comparable<Vertex> {
		int no, weight; // 정점 번호, 트리정점과 연결했을때의 간선비용

		public Vertex(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}

		public int compareTo(Vertex o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	static int V, adjMatrix[][];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		V = Integer.parseInt(in.readLine());
		adjMatrix = new int[V][V]; // 인접행렬

		// 라인 단위로 입력하세용 --입력 받는거 생략

		// 방문정점(트리정점 표시)

		boolean[] visited = new boolean[V];
		int[] minEdge = new int[V]; // 자신과 트리의 정점들 간 최소 간선 비용

		PriorityQueue<Vertex> pQu = new PriorityQueue<>();

		Arrays.fill(minEdge, Integer.MAX_VALUE);

		minEdge[0] = 0; // 임의의 0정점을 트리 구성의 시작으로 하기 위해 세팅

		pQu.offer(new Vertex(0, minEdge[0]));

		int result = 0; // 최소 신장 트리 비용
		int min = 0, minVertex = 0, cnt = 0;

		while (!pQu.isEmpty()) {

			// 미방문(비트리) 정점 중 최소 간선 비용의 정점을 선택
			Vertex cur = pQu.poll();

			minVertex = cur.no;
			min = cur.weight;
			
			
			//이미 방문 -> 제거
			if(visited[minVertex]) continue;

			// 방문(트리) 정점에 추가
			visited[minVertex] = true;
			result += min; // 신장트리 비용 누적
			if (++cnt == V)
				break;

			// 트리에 추가된 새로운 정점 기준으로 비트리 정점과 간선 비용 고려
			for (int i = 0; i < V; i++) {
				if (!visited[i] && adjMatrix[minVertex][i] != 0 && minEdge[i] > adjMatrix[minVertex][i]) {
					minEdge[i] = adjMatrix[minVertex][i];
					pQu.offer(new Vertex(i, minEdge[i])); // 추가
					// 있는 것 변경 x -> 그냥 새로운 노드 추가 -> 최소힙 유지하므로 뒷값은 의미 x 따라서 ㄱㅊ
				}
			}

		}
	}

}
