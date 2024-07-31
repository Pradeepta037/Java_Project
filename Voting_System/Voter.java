// Voter.java
public class Voter {
    private String voterID;
    private boolean hasVoted;

    public Voter(String voterID) {
        this.voterID = voterID;
        this.hasVoted = false;
    }

    public String getVoterID() {
        return voterID;
    }

    public boolean hasVoted() {
        return hasVoted;
    }

    public void vote() {
        if (!hasVoted) {
            hasVoted = true;
        } else {
            System.out.println("This voter has already voted.");
        }
    }
}
