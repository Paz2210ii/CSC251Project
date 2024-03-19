import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        List<Policy> policies = new ArrayList<>();

        try {
            // Read from the text file
            File file = new File("PolicyInformation.txt");
            Scanner scanner = new Scanner(file);

            // Read policy information from the file and create Policy objects
            while (scanner.hasNextLine()) {
                String policyNumber = scanner.nextLine();
                String providerName = scanner.nextLine();
                String firstName = scanner.nextLine();
                String lastName = scanner.nextLine();
                int age = Integer.parseInt(scanner.nextLine());
                String smokingStatus = scanner.nextLine();
                double height = Double.parseDouble(scanner.nextLine());
                double weight = Double.parseDouble(scanner.nextLine());

                // Create Policy object and add it to the list
                Policy policy = new Policy(policyNumber, providerName, firstName, lastName, age, smokingStatus, height, weight);
                policies.add(policy);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        // Display policy details
        for (Policy policy : policies) {
            System.out.println("Policy Number: " + policy.getPolicyNumber());
            System.out.println("Provider Name: " + policy.getProviderName());
            System.out.println("Policyholder's First Name: " + policy.getPolicyholderFirstName());
            System.out.println("Policyholder's Last Name: " + policy.getPolicyholderLastName());
            System.out.println("Policyholder's Age: " + policy.getPolicyholderAge());
            System.out.println("Policyholder's Smoking Status: " + policy.getPolicyholderSmokingStatus());
            System.out.println("Policyholder's Height: " + policy.getPolicyholderHeight() + " inches");
            System.out.println("Policyholder's Weight: " + policy.getPolicyholderWeight() + " pounds");
            System.out.printf("Policyholder's BMI: %.2f\n", policy.calculateBMI());
            System.out.printf("Policy Price: $%.2f\n", policy.calculatePolicyPrice());
            System.out.println();
        }
    }
}
