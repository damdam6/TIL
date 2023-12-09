package BasicStudy;

import java.util.Arrays;

public class Algo0922_Dijkstra {
	
	static class Node{
		int vertex, weight;
		Node next;
		
		public Node(int vertex, int weight, Node next) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
	
		public String toString() {
			String more;
			if(next != null) {
				more = next.toString();
			}else {
				more ="";
			}
			return "goto: "+this.vertex+" weight: "+weight +" next : "+more+ " | ";
		}
	}
	
	public static void main(String[] args) {
		
		int V=6; //노드수(정점수)
		int E=9; //간선수
		//정점, 간선
		// 시작 번호 - 끝번호
		int start = 0;
		int end =5;
		
		Node[] adjList = new Node[V];
		int[] dis = new int[V];
		
		boolean[] visited = new boolean[V];
		
		//간선 설정하기
		
		adjList[0] = new Node(1,1,adjList[0]);
		
		adjList[1] = new Node(2,3,adjList[1]);
		adjList[1] = new Node(3,2,adjList[1]);
		adjList[1] = new Node(4,1,adjList[1]);
		
		adjList[2] = new Node(3,2,adjList[2]);
		adjList[2] = new Node(4,4,adjList[2]);
		
		adjList[3] = new Node(4,1,adjList[3]);
		adjList[3] = new Node(5,2,adjList[3]);
		
		adjList[4] = new Node(5,6,adjList[4]);
		//간선 설정하기
		

		for(Node n:adjList) {
			System.out.println(n.toString());
		}
		

		
		final int INF = Integer.MAX_VALUE;
		Arrays.fill(dis, INF);
		
		dis[start] = 0;
		int min=0, stopOver=0;
		for (int i = 0; i < V; i++) {
			
			
			//미방문 정점 중 출발지에서 가장 가까운 정점을 경유지로 선택
			stopOver = -1;
			min = INF;
			
			for (int j = 0; j < V; j++) {
				if(!visited[j] && min > dis[j]) {
					min = dis[j];
					stopOver = j;
				}
				
			}
			
			//경유지가 없으면 멈춤
			if(stopOver == -1)break;
			
			
			//방문처리
			visited[stopOver] = true;
			//상황에 따라 처리 : 경유지가 곧 도착지면 끝내기
			if(stopOver == end)break;
			
			
			//경유지를 이용하여 미방문 정점들의 출발지에서 자신으로의 최소 비용 고려
			
			for(Node temp = adjList[stopOver]; temp != null; temp = temp.next) {
				//해당 정점이 방문 정점이 아니고 현재 정점에서 갈 수 있는 정점의 경우
				//최소거리 정점을 거쳐서 해당 정점으로 갈 경우 토탇 가중치와 기존까지 계산된 해당 정점까지의 토탈 가중치를 비교하여 최소값을 만족하는 값을 저장
				
				if(!visited[temp.vertex]&&dis[temp.vertex] > min+temp.weight) {
					dis[temp.vertex] = min+temp.weight;
				}
			}

		}
		
		System.out.println(dis[end]);
		//dis[end]를 찍으면 된다.
		
	}

}
