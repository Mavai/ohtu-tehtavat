package ohtu;

public class TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        if (m_score1 == m_score2) {
            return (m_score1 < 4) ? getScore(m_score1) + "-" + "All" : "Deuce";
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            return getCurrentSituation(m_score1 - m_score2);
        } else {
            return getScore(m_score1) + "-" + getScore(m_score2);
        }
    }

    private String getCurrentSituation(int difference) {
        if (difference == 1) return "Advantage player1";
        else if (difference == -1) return "Advantage player2";
        else if (difference >= 2) return "Win for player1";
        else return "Win for player2";
    }

    private String getScore(int points) {
        switch (points) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
        }
        return "";
    }
}