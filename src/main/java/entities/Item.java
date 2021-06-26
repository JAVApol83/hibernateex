package entities;

import javax.persistence.*;

@Entity
@Table(name = "ITEMS")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public Item(long id) {
        this.id = id;
    }

    public Item() {
    }
}
