import java.awt.event.MouseEvent;

interface Sports {
    public void shoot();
}
class SoccerStrategy implements Sports{
    @Override
    public void shoot() {
        System.out.println("축구");
    }
}
class BasketBallStrategy implements Sports{
    @Override
    public void shoot() {
        System.out.println("농구");
    }
}

class SportsChange{
    private Sports sports;

    public void shoot(){
        sports.shoot();
    }

    public void setSportsStrategy(Sports sports){
        this.sports = sports;
    }
}
class Soccer extends SportsChange {

}

class Basketball extends SportsChange {

}

public class StrategyPattern {

    public static void main(String[] args) {
       SportsChange soccer = new Soccer();
       SportsChange basketball = new Basketball();

       soccer.setSportsStrategy(new SoccerStrategy());
       basketball.setSportsStrategy(new BasketBallStrategy());

       soccer.shoot();
       basketball.shoot();

       soccer.setSportsStrategy(new BasketBallStrategy());
       soccer.shoot();


    }
}
