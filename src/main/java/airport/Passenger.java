package airport;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PASSENGERS")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PASSENGER_ID")
    private int id;

    @Column(name = "PASSENGER_NAME")
    private String name;

    @OneToMany(mappedBy = "passenger")
    private List<Ticket> tickets = new ArrayList<>();

    public Passenger() {
    }

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "PASSENGER_STREET")),
            @AttributeOverride(name = "number", column = @Column(name = "PASSENGER_NUMBER")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "PASSENGER_ZIP_CODE")),
            @AttributeOverride(name = "city", column = @Column(name = "PASSENGER_CITY"))
    })
    private Address address;

    public Passenger(String name) {
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

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
