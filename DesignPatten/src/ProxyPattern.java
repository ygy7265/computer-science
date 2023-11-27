interface Power{
    String upgrade();
}
class PowerState implements  Power{

    @Override
    public String upgrade() {
        return "1단진화";
    }
}
// PowerState2 클래스: Power 인터페이스를 구현하며, 프록시 역할을 하는 클래스
class PowerState2 implements Power {
    PowerState powerState; // 실제 객체에 대한 참조를 유지

    @Override
    public String upgrade() {
        System.out.println("2단 진화 진행"); // 2단계 진화 전에 특별한 작업 수행
        powerState = new PowerState(); // 실제 객체 생성
        return powerState.upgrade(); // 실제 객체의 upgrade 메서드 호출
    }
}
public class ProxyPattern {
    public static void main(String[] args) {
        Power power = new PowerState2();
        System.out.println(power.upgrade());

    }
}
