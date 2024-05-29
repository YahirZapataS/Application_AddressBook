package address_data;

public class AddressEntry {

    private String name;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String email;
    private String phone;

    public AddressEntry(String name, String lastName, String street, String city, String state, String postalCode,
            String email, String phone) {
        this.name = name;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String toString() {
        return "Nombre: " + name + "\nApellido" + lastName
                + "\nCalle: " + street + "\nCiudad: " + city + "\nEstado: " + state + "\nCódigo Postal: " + postalCode
                + "\nCorreo: " + email + "\nTeléfono: " + phone;
    }

    public static AddressEntry fromString(String entryString) {
        String[] parts = entryString.split(",");

        if (parts.length == 8) {
            String name = parts[0];
            String lastName = parts[1];
            String street = parts[2];
            String city = parts[3];
            String state = parts[4];
            String postalCode = parts[5];
            String email = parts[6];
            String phone = parts[7];

            return new AddressEntry(name, lastName, street, city, state, postalCode, email, phone);
        }
        return null;

    }
}
