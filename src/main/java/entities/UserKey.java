package entities;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserKey implements Serializable {

    private String username;

    private String departmentNumber;

    protected UserKey() {

    }

    public UserKey(String username, String departmentNumber) {
        this.username = username;
        this.departmentNumber = departmentNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserKey userKey = (UserKey) o;
        return username.equals(userKey.username) && departmentNumber.equals(userKey.departmentNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, departmentNumber);
    }
}
