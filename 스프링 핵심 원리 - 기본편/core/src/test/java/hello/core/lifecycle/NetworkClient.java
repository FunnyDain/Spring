package hello.core.lifecycle;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient{

    private String url;

    //생성자
    public NetworkClient(){
        System.out.println("생성자 호출, url = " + url);
    }

    //url은 외부에서 넣을 수 있도록
    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작시 호출 메서드
    public void connect(){
        System.out.println("connect : " + url);
    }

    //연결한 서버에 메세지
    public void call(String message) {
        System.out.println("call : "+ url + " message = " + message);
    }

    //서비스 종료시 호출 메서드
    public void disconnect(){
        System.out.println("close : " + url);
    }

    @PostConstruct
    public void init(){     //Properties 세팅이 끝나면, 즉 의존관계 주입이 끝나면
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결메세지");
    }

    @PreDestroy
    public void close(){
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
