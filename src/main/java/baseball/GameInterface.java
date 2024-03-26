package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameInterface {
    List<Integer> guess = new ArrayList<>();

    public void getGuess() {
        String a = Console.readLine();

        // Validate input: exactly 3 digits
        if (!a.matches("\\d{3}")) {
            throw new IllegalArgumentException("Input must be exactly 3 digits.");
        }

        for (int i = 0; i < a.length(); i++) {
            // Convert character to integer and add to the list
            guess.add(Character.getNumericValue(a.charAt(i)));
        }
    }
}

