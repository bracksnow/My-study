package hello.core.lifecycle;

public class NetworkClient {

    private String url;

    public NetworkClient(String url) {
        System.out.println(url);
    }

    public void setUrl(String url) {
        this.url = url;
    }
    //서비스 시작
    public void connect() {
        System.out.println("connect: " + url);
    }
    public void call(String message) {
        System.out.println("call: " + url + " message = " + message);
    }
    //서비스 종료시 호출
    public void disconnect() {
        System.out.println("close: " + url);
    }
}
