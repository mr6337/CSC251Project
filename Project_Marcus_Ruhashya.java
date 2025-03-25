import java.io.*;
import java.util.*;

public class Project_Marcus_Ruhashya {
    public static void main(String[] args) {
        List<Policy> policies = new ArrayList<>();
        int smokerCount = 0;
        int nonSmokerCount = 0;

        try (Scanner fileScanner = new Scanner(new File("PolicyInformation.txt"))) {
            while (fileScanner.hasNext()) {
                int policyNumber = Integer.parseInt(fileScanner.nextLine());
                String providerName = fileScanner.nextLine();
                String firstName = fileScanner.nextLine();
                String lastName = fileScanner.nextLine();
                int age = Integer.parseInt(fileScanner.nextLine());
                String smokingStatus = fileScanner.nextLine();
                double height = Double.parseDouble(fileScanner.nextLine());
                double weight = Double.parseDouble(fileScanner.nextLine());
                
                Policy policy = new Policy(policyNumber, providerName, firstName, lastName, age, smokingStatus, height, weight);
                policies.add(policy);
                
                if (smokingStatus.equalsIgnoreCase("smoker")) {
                    smokerCount++;
                } else {
                    nonSmokerCount++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: PolicyInformation.txt not found.");
            return;
        }
        
        for (Policy policy : policies) {
            System.out.println("\nPolicy Number: " + policy.getPolicyNumber());
            System.out.println("Provider Name: " + policy.getProviderName());
            System.out.println("Policyholder’s First Name: " + policy.getPolicyholderFirstName());
            System.out.println("Policyholder’s Last Name: " + policy.getPolicyholderLastName());
            System.out.println("Policyholder’s Age: " + policy.getPolicyholderAge());
            System.out.println("Policyholder’s Smoking Status: " + policy.getSmokingStatus());
            System.out.println("Policyholder’s Height: " + policy.getPolicyholderHeight() + " inches");
            System.out.println("Policyholder’s Weight: " + policy.getPolicyholderWeight() + " pounds");
            System.out.printf("Policyholder’s BMI: %.2f\n", policy.calculateBMI());
            System.out.printf("Policy Price: $%.2f\n", policy.calculateInsurancePrice());
        }
        
        System.out.println("\nNumber of Smokers: " + smokerCount);
        System.out.println("Number of Non-Smokers: " + nonSmokerCount);
    }
}
