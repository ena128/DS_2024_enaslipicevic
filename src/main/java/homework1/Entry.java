package homework1;

public class Entry implements Comparable<Entry> {
    private String name;
    private String streetAddress;
    private String city;
    private String postcode;
    private String country;
    private String phoneNumber;

    // Constructor
    public Entry(String name, String streetAddress, String city, String postcode, String country, String phoneNumber) {
        this.name = name;
        this.streetAddress = streetAddress;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    // Getters
    public String getName() { return name; }
    public String getStreetAddress() { return streetAddress; }
    public String getCity() { return city; }
    public String getPostcode() { return postcode; }
    public String getCountry() { return country; }
    public String getPhoneNumber() { return phoneNumber; }

    @Override
    public int compareTo(Entry other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return name + ";" + streetAddress + ";" + city + ";" + postcode + ";" + country + ";" + phoneNumber;
    }
}
