/**
 * The Policy class represents an insurance policy.
 * It stores details about the policyholder and calculates insurance costs.
 */
public class Policy {
    private int policyNumber;
    private String providerName;
    private String policyholderFirstName;
    private String policyholderLastName;
    private int policyholderAge;
    private String smokingStatus;
    private double policyholderHeight;
    private double policyholderWeight;

    /**
     * Default constructor initializes fields with default values.
     */
    public Policy() {
        this.policyNumber = 0;
        this.providerName = "Unknown";
        this.policyholderFirstName = "Unknown";
        this.policyholderLastName = "Unknown";
        this.policyholderAge = 0;
        this.smokingStatus = "non-smoker";
        this.policyholderHeight = 0.0;
        this.policyholderWeight = 0.0;
    }

    /**
     * Parameterized constructor initializes the policy with given values.
     * @param policyNumber Policy number
     * @param providerName Insurance provider name
     * @param firstName Policyholder's first name
     * @param lastName Policyholder's last name
     * @param age Policyholder's age
     * @param smokingStatus Smoking status ("smoker" or "non-smoker")
     * @param height Policyholder's height in inches
     * @param weight Policyholder's weight in pounds
     */
    public Policy(int policyNumber, String providerName, String firstName, String lastName,
                  int age, String smokingStatus, double height, double weight) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyholderFirstName = firstName;
        this.policyholderLastName = lastName;
        this.policyholderAge = age;
        this.smokingStatus = smokingStatus;
        this.policyholderHeight = height;
        this.policyholderWeight = weight;
    }

    /**
     * @return The policy number
     */
    public int getPolicyNumber() { return policyNumber; }

    /**
     * @return The insurance provider name
     */
    public String getProviderName() { return providerName; }

    /**
     * @return Policyholder's first name
     */
    public String getPolicyholderFirstName() { return policyholderFirstName; }

    /**
     * @return Policyholder's last name
     */
    public String getPolicyholderLastName() { return policyholderLastName; }

    /**
     * @return Policyholder's age
     */
    public int getPolicyholderAge() { return policyholderAge; }

    /**
     * @return Smoking status ("smoker" or "non-smoker")
     */
    public String getSmokingStatus() { return smokingStatus; }

    /**
     * @return Policyholder's height in inches
     */
    public double getPolicyholderHeight() { return policyholderHeight; }

    /**
     * @return Policyholder's weight in pounds
     */
    public double getPolicyholderWeight() { return policyholderWeight; }

    /**
     * Calculates and returns the BMI of the policyholder.
     * @return The calculated BMI
     */
    public double calculateBMI() {
        return (policyholderWeight * 703) / (policyholderHeight * policyholderHeight);
    }

    /**
     * Calculates the insurance policy price based on age, smoking status, and BMI.
     * @return The calculated insurance price
     */
    public double calculateInsurancePrice() {
        double price = 600; // Base fee
        if (policyholderAge > 50) {
            price += 75;
        }
        if (smokingStatus.equalsIgnoreCase("smoker")) {
            price += 100;
        }
        double bmi = calculateBMI();
        if (bmi > 35) {
            price += (bmi - 35) * 20;
        }
        return price;
    }
}
