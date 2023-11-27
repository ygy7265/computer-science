import java.util.ArrayList;
import java.util.List;

interface Partty{
    // 집으로 알림보내기
    void goHome(State state);
    //알림 끄기
    void sleep(State state);
    void stateMsg(String msg);
}
interface State{
    void update(String msg);
}

class Leader implements Partty{
    private List<State> states = new ArrayList<>();

    public void Critical(){
        stateMsg("뜸");
    }

    @Override
    public void goHome(State state) {
        states.add(state);
    }

    @Override
    public void sleep(State state) {
        states.remove(state);
    }

    @Override
    public void stateMsg(String msg) {
        states.forEach(states -> states.update(msg));
    }
}
class Mother implements State{
    @Override
    public void update(String msg) {
        System.out.println("엄크 : " + msg);
    }
}
class Father implements State{
    @Override
    public void update(String msg) {
        System.out.println("아크 : " + msg);
    }
}
public class ObserverPattern {
    public static void main(String[] args) {
        Leader leader = new Leader();
        State mother = new Mother();
        State father = new Father();
        leader.goHome(mother);
        leader.goHome(father);
        leader.Critical();
        leader.stateMsg("화남");
        System.out.println("===========================");
        leader.sleep(father);
        leader.Critical();

    }
}
