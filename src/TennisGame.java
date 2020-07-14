public class TennisGame {

    public static String getScore(String firstPlayerName, String secondPlayerName, int firstPlayerScore, int secondPlayerScore) {
        String scoreOfPlayer = "";
        int tempScore = 0;
        if (firstPlayerScore == secondPlayerScore) {
            scoreOfPlayer = getNameScoreWhenTwoPlayerTie(firstPlayerScore);
        } else if (firstPlayerScore >= 4 || secondPlayerScore >= 4) {
            scoreOfPlayer = checkAdvantageOrWin(firstPlayerScore, secondPlayerScore);
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = firstPlayerScore;
                else {
                    scoreOfPlayer += "-";
                    tempScore = secondPlayerScore;
                }
                scoreOfPlayer = getScoreName(scoreOfPlayer, tempScore);
            }
        }
        return scoreOfPlayer;
    }

    private static String checkAdvantageOrWin(int firstPlayerScore, int secondPlayerScore) {
        String scoreOfPlayer;
        int minusResult = firstPlayerScore - secondPlayerScore;
        if (minusResult == 1) scoreOfPlayer = "Advantage player1";
        else if (minusResult == -1) scoreOfPlayer = "Advantage player2";
        else if (minusResult >= 2) scoreOfPlayer = "Win for player1";
        else scoreOfPlayer = "Win for player2";
        return scoreOfPlayer;
    }

    private static String getScoreName(String scoreOfPlayer, int tempScore) {
        switch (tempScore) {
            case 0:
                scoreOfPlayer += "Love";
                break;
            case 1:
                scoreOfPlayer += "Fifteen";
                break;
            case 2:
                scoreOfPlayer += "Thirty";
                break;
            case 3:
                scoreOfPlayer += "Forty";
                break;
        }
        return scoreOfPlayer;
    }

    private static String getNameScoreWhenTwoPlayerTie(int firstPlayerScore) {
        String scoreOfPlayer;
        switch (firstPlayerScore) {
            case 0:
                scoreOfPlayer = "Love-All";
                break;
            case 1:
                scoreOfPlayer = "Fifteen-All";
                break;
            case 2:
                scoreOfPlayer = "Thirty-All";
                break;
            case 3:
                scoreOfPlayer = "Forty-All";
                break;
            default:
                scoreOfPlayer = "Deuce";
                break;
        }
        return scoreOfPlayer;
    }
}
