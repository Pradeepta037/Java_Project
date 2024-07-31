public class WorkExperience {
    private String jobTitle;
    private String company;
    private int startYear;
    private int endYear;

    // Constructor
    public WorkExperience(String jobTitle, String company, int startYear, int endYear) {
        this.jobTitle = jobTitle;
        this.company = company;
        this.startYear = startYear;
        this.endYear = endYear;
    }

    // Getters and Setters
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    // Method to return work experience details as a string
    public String getDetails() {
        return "Job Title: " + jobTitle + "\nCompany: " + company + "\nStart Year: " + startYear + "\nEnd Year: " + endYear;
    }
}
