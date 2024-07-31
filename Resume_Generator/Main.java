import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input personal information
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        System.out.println("Enter your address:");
        String address = scanner.nextLine();
        System.out.println("Enter your phone number:");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter your email:");
        String email = scanner.nextLine();

        Person person = new Person(name, address, phoneNumber, email);

        // Input the number of educational qualifications and work experiences
        System.out.println("Enter the maximum number of educational qualifications:");
        int maxEducations = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the maximum number of work experiences:");
        int maxWorkExperiences = Integer.parseInt(scanner.nextLine());

        CV cv = new CV(person, maxEducations, maxWorkExperiences);

        // Input education details
        for (int i = 0; i < maxEducations; i++) {
            System.out.println("Enter degree (or type 'done' to finish):");
            String degree = scanner.nextLine();
            if (degree.equalsIgnoreCase("done")) break;
            System.out.println("Enter institution:");
            String institution = scanner.nextLine();
            System.out.println("Enter year of passing:");
            int yearOfPassing = Integer.parseInt(scanner.nextLine());
            Education education = new Education(degree, institution, yearOfPassing);
            cv.addEducation(education);
        }

        // Input work experience details
        for (int i = 0; i < maxWorkExperiences; i++) {
            System.out.println("Enter job title (or type 'done' to finish):");
            String jobTitle = scanner.nextLine();
            if (jobTitle.equalsIgnoreCase("done")) break;
            System.out.println("Enter company:");
            String company = scanner.nextLine();
            System.out.println("Enter start year:");
            int startYear = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter end year:");
            int endYear = Integer.parseInt(scanner.nextLine());
            WorkExperience workExperience = new WorkExperience(jobTitle, company, startYear, endYear);
            cv.addWorkExperience(workExperience);
        }

        // Print the generated CV
        System.out.println("\nGenerated CV:");
        System.out.println(cv.generateCV());

        scanner.close();
    }
}
