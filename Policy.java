import java.util.Scanner;

public class Policy {
    // Constants
    private static final double BMI_CONSTANT = 703;
    private static final double BASE_POLICY_PRICE = 600;
    private static final double AGE_ADDITIONAL_FEE = 75;
    private static final double SMOKER_ADDITIONAL_FEE = 100;
    private static final double BMI_ADDITIONAL_FEE_RATE = 20;

    private String policyNumber;
    private String providerName;
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private double height;
    private double weight;
    private double bmi;
    private double price;

    // Constructors
    public Policy() {
        this("", "", "", "", 0, "non-smoker", 0, 0);
    }

    public Policy(String policyNumber, String providerName, String firstName, String lastName, int age,
                  String smokingStatus, double height, double weight) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }


    // BMI Calculation
    public double calculateBMI() {
        bmi = (weight * BMI_CONSTANT) / (height * height);
        return bmi;
    }

    // Policy Price Calculation
    public double calculatePrice() {
        price = BASE_POLICY_PRICE;
        if (age > 50) {
            price += AGE_ADDITIONAL_FEE;
        }
        if (smokingStatus.equals("smoker")) {
            price += SMOKER_ADDITIONAL_FEE;
        }
        if (calculateBMI() > 35) {
            double additionalFee = (bmi - 35) * BMI_ADDITIONAL_FEE_RATE;
            price += additionalFee;
        }
        return price;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the Policy Number: ");
        String policyNumber = scanner.nextLine();

        System.out.print("Please enter the Provider Name: ");
        String providerName = scanner.nextLine();

        System.out.print("Please enter the Policyholder’s First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Please enter the Policyholder’s Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Please enter the Policyholder’s Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Please enter the Policyholder’s Smoking Status (smoker/non-smoker): ");
        String smokingStatus = scanner.nextLine();

        System.out.print("Please enter the Policyholder’s Height (in inches): ");
        double height = scanner.nextDouble();

        System.out.print("Please enter the Policyholder’s Weight (in pounds): ");
        double weight = scanner.nextDouble();

        Policy policy = new Policy(policyNumber, providerName, firstName, lastName, age, smokingStatus, height, weight);

        double bmi = policy.calculateBMI();
        double price = policy.calculatePrice();

        System.out.println("\nPolicy Number: " + policy.getPolicyNumber());
        System.out.println("Provider Name: " + policy.providerName);
        System.out.println("Policyholder’s First Name: " + policy.firstName);
        System.out.println("Policyholder’s Last Name: " + policy.lastName);
        System.out.println("Policyholder’s Age: " + policy.age);
        System.out.println("Policyholder’s Smoking Status: " + policy.smokingStatus);
        System.out.println("Policyholder’s Height: " + policy.height + " inches");
        System.out.println("Policyholder’s Weight: " + policy.weight + " pounds");
        System.out.println("Policyholder’s BMI: " + String.format("%.2f", bmi));
        System.out.printf("Policy Price: $%.2f\n", price);


    }
}
