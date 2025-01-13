import Characters.Dealer;
import Characters.Player;

public class TestMain {
    public static void main(String[] args) {
        Dealer dealer = new Dealer();
        dealer.shuffle();

        Player player = new Player("me", dealer);

        player.initializeHand();

        System.out.println(player.hand);

        player.hit();

        System.out.println(player.hand);

        player.resetHand();

        System.out.println(player.hand);

        dealer.shuffle();
        player.initializeHand();
        player.hit();
        player.hit();

        System.out.println(player.hand);
        System.out.println(player.calculateHandTotal());
    }
}
