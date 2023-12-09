package BasicStudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Algo0922_PRIM {
	
	static int V, adjMatrix[][];
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		V = Integer.parseInt(in.readLine());
		adjMatrix = new int[V][V]; //인접행렬
		
		//라인 단위로 입력하세용 --입력 받는거 생략
		
		
		
		//방문정점(트리정점 표시)
		
		boolean[] visited = new boolean[V];
		int[] minEdge = new int[V]; //자신과 트리의 정점들 간 최소 간선 비용
		
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		
		minEdge[0] = 0; //임의의 0정점을 트리 구성의 시작으로 하기 위해 세팅
		
		int result = 0; //최소 신장 트리 비용
		int min = 0, minVertex =0;
		
		for(int c = 0; c < V ;c++) {
			minVertex = -1;
			min = Integer.MAX_VALUE;
			
			//미방문(비트리) 정점 중 최소간선비용의 정점을 선택
			for(int i =0;i<V;i++) {
				if(!visited[i] && min > minEdge[i]) {
					minVertex = i;
					min = minEdge[i];
				}
			}
			
			//방문(트리) 정점에 추가
			visited[minVertex] = true;
			result += min; // 신장트리 비용 누적
			
			// 트리에 추가된 새로운 정점 기준으로 비트리 정점과 간선 비용 고려 
			for (int i = 0; i < V; i++) {
				if(!visited[i] && adjMatrix[minVertex][i] != 0 && minEdge[i] > adjMatrix[minVertex][i]) {
					minEdge[i] = adjMatrix[minVertex][i];
				}
			}
			
			
		}
	}

}
