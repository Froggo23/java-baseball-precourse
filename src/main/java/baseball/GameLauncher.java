package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameLauncher {
    private boolean playAgain;

    public void launch() {
        do {
            NumberBaseballGame game = new NumberBaseballGame();
            game.play();

            // Read input from the console
            String input = Console.readLine();

            // Check if the input is "end" to end the game launcher
            if (input.equalsIgnoreCase("end")) {
                playAgain = false;
            }
        } while (playAgain);

        System.out.println("Thanks for playing!");
    }
}
