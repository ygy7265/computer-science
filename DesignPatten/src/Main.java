public class Main {

    public static void main(String[] args) {
        Singleton singleton1 =  Singleton.getInstance();
        Singleton singleton2 =  Singleton.getInstance();

        NoSingleton noSingleton1 = new NoSingleton();
        NoSingleton noSingleton2 = new NoSingleton();

        System.out.println(singleton1.equals(singleton2));
        System.out.println(noSingleton1.equals(noSingleton2));

    }
}