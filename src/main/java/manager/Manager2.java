package manager;

import javax.persistence.*;

@Entity
@Table(name = "MANAGERS_2")
public class Manager2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MANAGER_ID")
    private int id;

    @Column(name = "MANAGER_NAME")
    private String name;

    @OneToOne
    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID")
    private Department2 department;

    public Manager2() {
    }

    public Manager2(String name) {
        this.name = name;
    }

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

    public Department2 getDepartment() {
        return department;
    }

    public void setDepartment(Department2 department) {
        this.department = department;
    }
}
