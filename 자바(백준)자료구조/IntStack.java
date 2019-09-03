package DataStructure;

public class IntStack {
    private int max; //스택의 용량
    private int ptr; //스택 포인터
    private int[] stk;//스택 본체

    public class EmptyIntStackException extends RuntimeException{
        public EmptyIntStackException(){}
    }
    public class OverflowIntstacksException extends RuntimeException{
        public OverflowIntstacksException(){}
    }

}
