package entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "USERS")
public class User {

    @EmbeddedId
    private UserKey id;

    private double brutto;

    @Transient
    private double netto;

    public User() {
    }

    public User(UserKey id) {
        this.id = id;
    }

    public User(String username, String departmentNumber) {
        this.id = new UserKey(username, departmentNumber);
    }

    public double getBrutto() {
        return brutto;
    }

    public void setBrutto(double brutto) {
        this.brutto = brutto;
    }

    public double getNetto() {
        return brutto / 1.15d;
    }
}
