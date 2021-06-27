package ticket;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDate;

@Entity
public class ReturnTicket extends TicketBase {

    // @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_RETURN_DATE")
    private LocalDate lastReturnDate;

    public LocalDate getLastReturnDate() {
        return lastReturnDate;
    }

    public void setLastReturnDate(LocalDate lastReturnDate) {
        this.lastReturnDate = lastReturnDate;
    }
}
