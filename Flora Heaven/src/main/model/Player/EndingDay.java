package main.model.Player;


public class EndingDay {
    private Player player;

    public EndingDay(Player player) {
        this.player = player;
    }

    public void dayEnd() {
        player.setDay(player.getDay() + 1);
    }
}