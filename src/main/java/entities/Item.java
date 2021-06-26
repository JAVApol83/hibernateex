package entities;

import com.sun.istack.NotNull;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "ITEMS")
// @Access(AccessType.FIELD)
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // @Basic(optional = false)
    @Column(name = "INITIAL_PRICE", nullable = false)
    // @ColumnDefault("19.0")
    // @Generated(GenerationTime.ALWAYS)
    private BigDecimal initialPrice = new BigDecimal(19.0);

    private String name;

    // To powinno działać, a nie działa :(
    @Temporal(TemporalType.TIMESTAMP)
    @Generated(GenerationTime.ALWAYS)
    @Column(updatable = false, insertable = false)
    private Date updateDate;

    // To powinno działać, a nie działa :(
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false, insertable = false)
    @UpdateTimestamp
    private Date updateDate2;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    @CreationTimestamp
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTimestamp = new Date();

    @Temporal(TemporalType.DATE)
    private Date dateDate = new Date();

    @Temporal(TemporalType.TIME)
    private Date dateTime = new Date();

    @Enumerated(EnumType.ORDINAL)
    private ItemType itemTypeIndex = ItemType.TYPE_1;

    @Enumerated(EnumType.STRING)
    private ItemType itemTypeValue = ItemType.TYPE_2;

    public Item(long id) {
        this.id = id;
    }

    public Item() {
    }

    public BigDecimal getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(BigDecimal initialPrice) {
        this.initialPrice = initialPrice;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getUpdateDate2() {
        return updateDate2;
    }

    public void setUpdateDate2(Date updateDate2) {
        this.updateDate2 = updateDate2;
    }
}
