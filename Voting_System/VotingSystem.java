import java.util.Scanner;

public class VotingSystem {
    private Candidate[] candidates;
    private Voter[] voters;
    private int candidateCount;
    private int voterCount;

    public VotingSystem(int maxCandidates, int maxVoters) {
        candidates = new Candidate[maxCandidates];
        voters = new Voter[maxVoters];
        candidateCount = 0;
        voterCount = 0;
    }

    public void addCandidate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter candidate name: ");
        String name = scanner.nextLine();

        if (candidateCount < candidates.length) {
            candidates[candidateCount++] = new Candidate(name);
            System.out.println("Candidate added: " + name);
        } else {
            System.out.println("Cannot add more candidates.");
        }
    }

    public void registerVoter() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter voter ID: ");
        String voterID = scanner.nextLine();

        if (voterCount < voters.length) {
            voters[voterCount++] = new Voter(voterID);
            System.out.println("Voter registered: " + voterID);
        } else {
            System.out.println("Cannot register more voters.");
        }
    }

    public void vote() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter voter ID: ");
        String voterID = scanner.nextLine();
        System.out.print("Enter candidate name: ");
        String candidateName = scanner.nextLine();

        Voter voter = findVoter(voterID);
        if (voter == null) {
            System.out.println("Voter not registered.");
            return;
        }

        if (voter.hasVoted()) {
            System.out.println("This voter has already voted.");
            return;
        }

        Candidate candidate = findCandidate(candidateName);
        if (candidate == null) {
            System.out.println("Candidate not found.");
            return;
        }

        candidate.addVote();
        voter.vote();
        System.out.println("Vote cast for " + candidateName);
    }

    private Voter findVoter(String voterID) {
        for (int i = 0; i < voterCount; i++) {
            if (voters[i].getVoterID().equals(voterID)) {
                return voters[i];
            }
        }
        return null;
    }

    private Candidate findCandidate(String candidateName) {
        for (int i = 0; i < candidateCount; i++) {
            if (candidates[i].getName().equals(candidateName)) {
                return candidates[i];
            }
        }
        return null;
    }

    public void showResults() {
        System.out.println("Voting Results:");
        for (int i = 0; i < candidateCount; i++) {
            System.out.println(candidates[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter maximum number of candidates: ");
        int maxCandidates = scanner.nextInt();
        System.out.print("Enter maximum number of voters: ");
        int maxVoters = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over

        VotingSystem system = new VotingSystem(maxCandidates, maxVoters);

        while (true) {
            System.out.println("\n1. Add Candidate");
            System.out.println("2. Register Voter");
            System.out.println("3. Vote");
            System.out.println("4. Show Results");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over

            switch (choice) {
                case 1:
                    system.addCandidate();
                    break;
                case 2:
                    system.registerVoter();
                    break;
                case 3:
                    system.vote();
                    break;
                case 4:
                    system.showResults();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
