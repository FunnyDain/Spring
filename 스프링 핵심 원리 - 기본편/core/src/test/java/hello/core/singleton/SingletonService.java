package hello.core.singleton;

public class SingletonService {

    //SingletonService <- 자기 자신을 내부의 private로 하나 선언하는데, 
    //static영역에 객체를 미리 딱 하나만 생성하여 올려둠.
    //객체를 생성하여 instance 참조로 넣어놈
    private static final SingletonService instance = new SingletonService();

    //조회, 인스턴스 참조를 꺼내는 유일한 방법
    public static SingletonService getInstance() {
        return instance;
    }

    //또 다른 객체 생성을 막기 위해 생성자를 private 막아 만들어놈
    private SingletonService() {
    }
    
    //그냥 로직 하나
    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
