public class Main {
    public static void main(String[] args) {
        Player humanPlayer = new HumanPlayer();
        Player computerPlayer = new ComputerPlayer();

        Game game = new Game(humanPlayer, computerPlayer);
        game.play();
    }
}
