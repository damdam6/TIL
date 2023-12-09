package BasicStudy;

import java.util.Arrays;

public class Algo0922 {
	
	static int N;
	static int p[];
	
	private static void make() {
		p = new int[N];
		for(int i=0; i<N;i++) {
			p[i] = i;
		}
	}
	
	private static int find(int a) {
		
		if(a == p[a]) return a;
		
		//return find(p[a]);
		
		//path compression 적용시
		return p[a] = find(p[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		//같은 집합인 경우 빼기
		if(aRoot == bRoot) return false;
		
		//union처리 
		p[bRoot] = aRoot;		
		return true;
	}
	
	public static void main(String[] args) {
		
		N = 5;
		make();
		
		System.out.println(Arrays.toString(p));
		System.out.println(union(0,1));
		System.out.println(Arrays.toString(p));
		System.out.println(union(2,1));
		System.out.println(Arrays.toString(p));
		System.out.println(union(3,2));
		System.out.println(Arrays.toString(p));
		
		System.out.println("find ==========");
		System.out.println(find(4));
		System.out.println(Arrays.toString(p));
		System.out.println(find(3));
		System.out.println(Arrays.toString(p));
		System.out.println(find(2));
		System.out.println(Arrays.toString(p));
		System.out.println(find(1));
		System.out.println(Arrays.toString(p));
		System.out.println(find(0));
	}

}
