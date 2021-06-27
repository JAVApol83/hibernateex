package manager;

import javax.persistence.*;

@Entity
@Table(name = "DEPARTMENTS_2")
public class Department2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEPARTMENT_ID")
    private int id;

    @Column(name = "DEPARTMENT_NAME")
    private String name;

    @OneToOne(mappedBy = "department")
    private Manager2 manager;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
