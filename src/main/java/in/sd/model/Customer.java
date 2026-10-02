package in.sd.model;

import java.util.Objects;

public class Customer {

    private final String id;
    private String name;
    private String contact;

    public Customer(String id, String name, String contact) {
        if(id == null || id.isBlank()) {
            throw new IllegalArgumentException("ID should not be Empty");
        }
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name should not be Empty");
        }
        if(contact == null || contact.isBlank() || contact.length() != 10) {
            throw new IllegalArgumentException("Invalid Contact");
        }

        this.id = id;
        this.name = name;
        this.contact = contact;
    }

    //Setters
    public void setName(String name) {
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name should not be empty");
        }
        this.name = name;
    }

    public void setContact(String contact) {
        if(contact == null || contact.isBlank() || contact.length()!=10) {
            throw new IllegalArgumentException("Invalid contact");
        }
        this.contact = contact;
    }

    //Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    //Overridden methods
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        Customer other = (Customer) obj;

        return id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Customer{id='" + id + "', name='" + name + "', contact='" + contact + "'}";
    }

}
