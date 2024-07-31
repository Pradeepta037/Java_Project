class Education {
    private String degree;
    private String institution;
    private int yearOfPassing;

    // Constructor
    public Education(String degree, String institution, int yearOfPassing) {
        this.degree = degree;
        this.institution = institution;
        this.yearOfPassing = yearOfPassing;
    }

    // Getters and Setters
    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public int getYearOfPassing() {
        return yearOfPassing;
    }

    public void setYearOfPassing(int yearOfPassing) {
        this.yearOfPassing = yearOfPassing;
    }

    // Method to return education details as a string
    public String getDetails() {
        return "Degree: " + degree + "\nInstitution: " + institution + "\nYear of Passing: " + yearOfPassing;
    }
}
