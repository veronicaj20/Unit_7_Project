public class Address {
    private String houseNumber;
    private String streetName;
    private String aptNumber;
    private String city;
    private String state;
    private String zip;

    public Address(String houseNumber, String streetName, String aptNumber, String city, String state, String zip) {
        this.houseNumber = houseNumber;
        this.streetName = streetName;
        this.aptNumber = aptNumber;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    // takes address object
    public Address(Address a) {
        this.houseNumber = a.houseNumber;
        this.streetName = a.streetName;
        this.aptNumber = a.aptNumber;
        this.city = a.city;
        this.state = a.state;
        this.zip = a.zip;
    }

    // breaks up a string
    public Address(String wholeAddress) {
        String [] sections = wholeAddress.split(",");
        String [] houseNumberAndStreet = sections[0].split(" ", 2);
        this.houseNumber = houseNumberAndStreet[0];
        this.streetName = houseNumberAndStreet[1];

        if (wholeAddress.contains("Apt")) {
            int aptIdx = wholeAddress.indexOf("Apt");
            this.aptNumber = wholeAddress.substring(aptIdx, wholeAddress.indexOf(","));
        }
        else {
            this.city = sections[1];
            this.state = sections[2].split(" ")[0];
            this.zip = sections[2].split(" ")[1];
        }
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getAptNumber() {
        return aptNumber;
    }

    public void setAptNumber(String aptNumber) {
        this.aptNumber = aptNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String toString() {
        String address = houseNumber + " " + streetName;
        if (aptNumber != null) {
            address += " " + aptNumber + ", " + city + ", " + state + " " + zip;
        }
        else {
            address += ", " + city + ", " + state + " " + zip;
        }
        return address;
    }
}
