import java.awt.*;
interface lollipop {
    void wifi();
}
interface jewelry{
    void bluetooth();
}

abstract class Phone{
    public abstract String getInfo();

    @Override
    public String toString() {
        return "Phone = "+this.toString();
    }
}

class Apple extends Phone {
    private String type;
    private int price;

    public Apple(String type,int price){
        this.type = type;
        this.price = price;
    }

    @Override
    public String getInfo() {
        String info = "type = "+ type + ", Price = " + price;
        return info;
    }
}

class Samsung extends  Phone{
    private String type;
    private int price;

    public Samsung(String type,int price){
        this.type = type;
        this.price = price;
    }

    @Override
    public String getInfo() {
        String info = "type = "+ type + ", Price = " + price;
        return info;
    }
}
// 인터페이스 구현
class PhoneFactory implements lollipop,jewelry{
    public PhoneFactory(){

    }
    public static Phone getPhone(String type, int price){
        if("Samsung".equals(type)){
            return new Samsung(type,price);
        }
        else{
            return new Apple(type,price);
        }
    }

    @Override
    public void wifi() {
        System.out.println("와이파이");
    }

    @Override
    public void bluetooth() {
        System.out.println("블루투스");
    }
}

public class InterAbst {
    public static void main(String[] args){
          Phone phone = PhoneFactory.getPhone("Samsung",6000000);
          PhoneFactory phoneFactory = new PhoneFactory();
          String info  = phone.getInfo();
          System.out.println(info);
          phoneFactory.wifi();
          phoneFactory.bluetooth();
    }

}
