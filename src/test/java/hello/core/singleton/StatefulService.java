package hello.core.singleton;

public class StatefulService {
    private int price; // 狀態를 維持하는 필드

    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
//        this.price = price; // 여기가 問題！
        return price;
    }

//    public int getPrice() {
//        return price;
//    }
}
