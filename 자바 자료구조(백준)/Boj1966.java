package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1966 {
    static LinkedList<Integer> list = new LinkedList<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Queue<document> q = new LinkedList<document>();
        StringTokenizer st;
        int test_case = Integer.parseInt(bf.readLine());//테스트 케이스를 말함
        while(test_case-->0){
            q.clear();
            list.clear();
            st = new StringTokenizer(bf.readLine());
            int doc_count = Integer.parseInt(st.nextToken());//문서의 개수
            int index = Integer.parseInt(st.nextToken());//찾고자 하는 문서의 위치
            st = new StringTokenizer(bf.readLine());
            for(int i = 0;i<doc_count;i++){
                int priority = Integer.parseInt(st.nextToken());
                q.offer(new document(i,priority));
                list.add(priority);
            }
            int count = 1;
            while(!q.isEmpty()){
                int max = getMax();
                document d = q.poll();
                if(d.priority==max){//최대값과 중요도가 일치하는 경우
                    if(d.number==index){//내가 찾고자 하는 큐의 위치와 일치하는 경우
                        System.out.println(count);
                        break;
                    }
                    count++;
                    list.remove(list.indexOf(max));
                    continue;
                }
                q.offer(d);
            }



        }

    }
    public static int getMax(){
        int max = 0;
        for(int i = 0;i<list.size();i++){
            if(max<list.get(i)){
                max = list.get(i);
            }
        }
        return max;
    }
    static class document{
        int number;
        int priority;

        public document(int number, int priority) {
            this.number = number;
            this.priority = priority;
        }
    }
}
