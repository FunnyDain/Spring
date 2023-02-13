package hello.core.singleton;

//어떤 서비스가 있다고 가정
public class StatefulService {

//    private int price;      //상태를 유지하는 필드

    //클라이언트 의도 1. 뭔가를 주문을 해서 값을 저장하고
    public int order(String name, int price) {
        System.out.println("name= " + name +  " price= " + price);
//        this.price = price;     //여기가 문제!
        return price;
    }

    //2. 값을 꺼내오고 싶었다.
//    public int getPrice(){
//        return price;
//    }
}
