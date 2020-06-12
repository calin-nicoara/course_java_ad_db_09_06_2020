package ro.esolacad.javaad.lab;

public class Game {
    private final int[] rolls = new int[21];
    private int currentRoll = 0;

    public void roll(final int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {
        int score = 0;
        for (int frame = 0, frameIndex = 0; frame < 10; frame++) {
            if (isStrike(frameIndex)) {
                score += 10 + strikeBonus(frameIndex);
                frameIndex++;
            } else if (isSpare(frameIndex)) {
                score += 10 + spareBonus(frameIndex);
                frameIndex += 2;
            } else {
                score += sumOfBallsInFrame(frameIndex);
                frameIndex += 2;
            }
        }

        return score;
    }

    private boolean isStrike(final int frameIndex) {
        return rolls[frameIndex] == 10;
    }

    private int strikeBonus(final int frameIndex) {
        return rolls[frameIndex + 1]
                + rolls[frameIndex + 2];
    }

    private boolean isSpare(final int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1] == 10;
    }

    private int spareBonus(final int frameIndex) {
        return rolls[frameIndex + 2];
    }

    private int sumOfBallsInFrame(final int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1];
    }
}
