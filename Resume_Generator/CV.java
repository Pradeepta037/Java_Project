public class CV {
    private Person person;
    private Education[] educationList;
    private WorkExperience[] workExperienceList;
    private int educationCount;
    private int workExperienceCount;

    // Constructor
    public CV(Person person, int maxEducations, int maxWorkExperiences) {
        this.person = person;
        this.educationList = new Education[maxEducations];
        this.workExperienceList = new WorkExperience[maxWorkExperiences];
        this.educationCount = 0;
        this.workExperienceCount = 0;
    }

    // Add education
    public void addEducation(Education education) {
        if (educationCount < educationList.length) {
            educationList[educationCount++] = education;
        }
    }

    // Add work experience
    public void addWorkExperience(WorkExperience workExperience) {
        if (workExperienceCount < workExperienceList.length) {
            workExperienceList[workExperienceCount++] = workExperience;
        }
    }

    // Method to return the complete CV as a string
    public String generateCV() {
        StringBuilder cv = new StringBuilder();
        cv.append(person.getDetails()).append("\n\n");

        cv.append("Education:\n");
        for (int i = 0; i < educationCount; i++) {
            cv.append(educationList[i].getDetails()).append("\n\n");
        }

        cv.append("Work Experience:\n");
        for (int i = 0; i < workExperienceCount; i++) {
            cv.append(workExperienceList[i].getDetails()).append("\n\n");
        }

        return cv.toString();
    }
}
