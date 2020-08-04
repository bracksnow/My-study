package DataStructure;
//DFS문제
//연결된 노드를 찾는 문제이기 때문에 DFS를 적용함

class Solution_DBFS_h2 {
    static boolean visited[][];
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n][n];

        for(int i = 0 ; i < computers.length; i++) {
            if(!visited[i][i]) {//노드를 의미함
                answer++;
                dfs(computers, i, n);
            }
        }
        return answer;
    }
    public static void dfs(int[][] computers, int index, int n) {
        for(int i = 0;i<n;i++){
            if(!visited[index][i] && computers[index][i]==1){
                visited[index][i]=true;
                visited[i][index] = true;
                dfs(computers,i,n);
            }
        }

    }
}
