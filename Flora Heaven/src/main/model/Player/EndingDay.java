package main.model.Player;

public class EndingDay {
    private Player player;

    public EndingDay(Player player) {
        this.player = player;
    }

    private void addDay(Player player) {
        player.setDay(player.getDay() + 1);
    }
}