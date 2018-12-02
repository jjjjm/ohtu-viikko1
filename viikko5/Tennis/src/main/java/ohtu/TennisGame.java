package ohtu;

public class TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == player1Name) {
            player1Score += 1;
        } else {
            player2Score += 1;
        }
    }

    private String getTermForLowScores(Integer score) {
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            default:
                return "Forty";
        }
    }

    private String getTermForHighScores(Integer scoreDifference) {
        if (scoreDifference == 0) {
            return "Deuce";
        }
        String winningPlayer = scoreDifference > 0 ? this.player1Name : this.player2Name;
        if (scoreDifference < -1 || scoreDifference > 1) {
            return "Win for " + winningPlayer;
        } else {
            return "Advantage " + winningPlayer;
        }
    }

    private String getTermForEvenScores(Integer scoreDifference) {
        return "";
    }

    public String getScore() {
        if (player1Score >= 4 || player2Score >= 4) {
            return this.getTermForHighScores(player1Score - player2Score);
        } else if (player1Score == player2Score) {
            return getTermForLowScores(player1Score) + "-All";
        } else {
            return getTermForLowScores(player1Score) + "-" + getTermForLowScores(player2Score);
        }
    }
}
