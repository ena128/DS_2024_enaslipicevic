package homework3;

public class Entry implements Comparable<Entry> {

    private String surname;
    private String name;
    private String streetAddress;
    private String city;
    private String postcode;
    private String country;
    private String phoneNumber;

    public Entry(String surname, String name, String streetAddress, String city, String postcode, String country, String phoneNumber) {
        this.surname = surname;
        this.name = name;
        this.streetAddress = streetAddress;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString(){
        return  "\nName: " + this.name
                + "\nAddress: " + this.streetAddress
                + "\nCity: " + this.city
                + "\nPost Code: " + this.postcode
                + "\nCountry: " + this.country
                + "\nPhone Number: " + this.phoneNumber + "\n";
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getPostcode() {
        return postcode;
    }
    public String getCountry() {
        return country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public int compareTo(Entry other) {
        int surnameComparison = this.surname.compareTo(other.surname);
        if (surnameComparison != 0) {
            return surnameComparison;
        }
        return this.name.compareTo(other.name);
    }
}

