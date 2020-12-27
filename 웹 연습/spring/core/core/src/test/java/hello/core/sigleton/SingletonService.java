package hello.core.sigleton;

public class SingletonService {

    private static SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService() {//private로 지정해 외부에서 생성하지 못하도록 만든다
    }
    public void login(){
        System.out.println("싱글톤 객체 로직 호출!!");
    }
}
