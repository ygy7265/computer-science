public class Singleton {

    //생성자
    private static Singleton instance = new Singleton();

    //외부에서 호출 못하게 막기
    private Singleton(){

    }

    //생성자 반환해주기
    public static Singleton getInstance(){
        return instance;
    }

    //테스트용 메서드
    public void test(){
        System.out.println("Singleton Test");
    }
}
