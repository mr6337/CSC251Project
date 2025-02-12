public class Policy {
    // Attributes
    private int policyNumber;
    private String providerName;
    private String policyholderFirstName;
    private String policyholderLastName;
    private int policyholderAge;
    private String smokingStatus;
    private double policyholderHeight;
    private double policyholderWeight;

    // No-argument constructor with default values
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

    // Parameterized constructor
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

    // Getters and Setters
    public int getPolicyNumber() { return policyNumber; }
    public void setPolicyNumber(int policyNumber) { this.policyNumber = policyNumber; }

    public String getProviderName() { return providerName; }
    public void setProviderName(String providerName) { this.providerName = providerName; }

    public String getPolicyholderFirstName() { return policyholderFirstName; }
    public void setPolicyholderFirstName(String firstName) { this.policyholderFirstName = firstName; }

    public String getPolicyholderLastName() { return policyholderLastName; }
    public void setPolicyholderLastName(String lastName) { this.policyholderLastName = lastName; }

    public int getPolicyholderAge() { return policyholderAge; }
    public void setPolicyholderAge(int age) { this.policyholderAge = age; }

    public String getSmokingStatus() { return smokingStatus; }
    public void setSmokingStatus(String smokingStatus) { this.smokingStatus = smokingStatus; }

    public double getPolicyholderHeight() { return policyholderHeight; }
    public void setPolicyholderHeight(double height) { this.policyholderHeight = height; }

    public double getPolicyholderWeight() { return policyholderWeight; }
    public void setPolicyholderWeight(double weight) { this.policyholderWeight = weight; }

    // Method to calculate BMI
    public double calculateBMI() {
        return (policyholderWeight * 703) / (policyholderHeight * policyholderHeight);
    }

    // Method to calculate insurance price
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
