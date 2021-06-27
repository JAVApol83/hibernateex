package manager;

import javax.persistence.*;

@Entity
@Table(name = "MANAGERS")
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MANAGER_ID")
    private int id;

    @Column(name = "MANAGER_NAME")
    private String name;

    @OneToOne
    @JoinTable(
            name = "MANAGER_TO_DEPARTMENT",
            joinColumns = {
                    @JoinColumn(name = "MANAGER_ID", referencedColumnName = "MANAGER_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID")
            }
    )
    private Department department;

    public Manager() {
    }

    public Manager(String name) {
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
