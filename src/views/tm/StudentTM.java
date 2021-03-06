package views.tm;

import javafx.scene.control.Button;

public class StudentTM {
    private String id;
    private String name;
    private String contact;
    private String address;
    private Button button;

    public StudentTM() {
    }

    public StudentTM(String id, String name, String contact, String address, Button button) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.button = button;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }
}
