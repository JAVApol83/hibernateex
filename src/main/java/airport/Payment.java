package airport;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PAYMENTS")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PAYMENT_ID")
    private int id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "TICKET_ID", referencedColumnName = "ID"),
            @JoinColumn(name = "TICKET_NUMBER", referencedColumnName = "NUMBER")
    })
    private Ticket ticket;

    @Column(name = "PRICE")
    private BigDecimal price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
