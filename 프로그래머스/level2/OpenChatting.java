package DataStructure;

import java.util.HashMap;
import java.util.StringTokenizer;

public class OpenChatting {
    public String[] solution(String[] record) {
        HashMap<String, String> user = new HashMap<>();
        String[] logState = new String[100000];
        String[] logId = new String[100000];
        int index = 0;
        for(int i = 0;i< record.length;i++){
            String sentence = record[i];
            StringTokenizer st = new StringTokenizer(sentence," ");
            String state = st.nextToken();//입출력, 변경까지를 의미함
            if(state.equals("Enter")){
                String id = st.nextToken();
                String name = st.nextToken();
                user.put(id,name);//->해시에 id, name를 저장
                logId[index] = id;
                logState[index] = "님이 들어왔습니다";
                index++;
            }
            else if(state.equals("Leave")){
                String id = st.nextToken();
                logId[index] = id;
                logState[index] = "님이 나갔습니다.";
                index++;
            }
            else{
                String id = st.nextToken();
                String name = st.nextToken();
                user.put(id,name);
            }
        }
        String answer[] = new String [index];
        for(int i=0; i<index; i++){
            answer[i] = user.get(logId[i])+logState[i];
        }
        return answer;
    }
}
