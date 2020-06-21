package Refactoring.BaiTap.Refactoring;

public class TennisGame {

    public static final int LOVE = 0;
    public static final int FIFTEEN_ALL = 1;
    public static final int THIRTY_ALL = 2;
    public static final int FORTY_ALL = 3;

    public static String getScore(String player1Name, String player2Name, int play1Score, int play2Score) {
        String score = "";
        boolean isSameScore = play1Score == play2Score;
        if (isSameScore) {
            score = getSameScore(play1Score);
        } else if (play1Score >= 4 || play2Score >= 4) {
            score = getPlayerWin(play1Score, play2Score);
        } else {
            score = getRatio(play1Score, play2Score, score);
        }
        return score;
    }

    public static String getRatio(int play1Score, int play2Score, String score) {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = play1Score;
            else {
                score += "-";
                tempScore = play2Score;
            }
            switch (tempScore) {
                case LOVE:
                    score += "Love";
                    break;
                case FIFTEEN_ALL:
                    score += "Fifteen";
                    break;
                case THIRTY_ALL:
                    score += "Thirty";
                    break;
                case FORTY_ALL:
                    score += "Forty";
                    break;
            }
        }
        return score;
    }

    public static String getPlayerWin(int play1Score, int play2Score) {
        String score;
        int ratioDifference = play1Score - play2Score;
        if (ratioDifference == 1) score = "Advantage player1";
        else if (ratioDifference == -1) score = "Advantage player2";
        else if (ratioDifference >= 2) score = "Win for player1";
        else score = "Win for player2";
        return score;
    }

    public static String getSameScore(int play1Score) {
        String score;
        switch (play1Score) {
            case LOVE:
                score = "Love-All";
                break;
            case FIFTEEN_ALL:
                score = "Fifteen-All";
                break;
            case THIRTY_ALL:
                score = "Thirty-All";
                break;
            case FORTY_ALL:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;
        }
        return score;
    }
}
