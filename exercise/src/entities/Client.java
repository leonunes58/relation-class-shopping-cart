package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private String name;
    private String email;
    private Date birthDate;
    private String password;

    public Client(String name, String email, Date birthDate,  String password) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Client: ").append(getName()).append(" ").append(sdf.format(getBirthDate())).append(" - ").append(getEmail()).append(" Password: "). append(getPassword()).append("\n");
        return sb.toString();
    }
}
