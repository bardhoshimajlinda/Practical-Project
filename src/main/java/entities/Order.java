package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "po_order")
@Getter @Setter @ToString
public class Order extends BaseEntity {

    @Column(name = "created_date")
    protected Instant createdDate;

    protected double total;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order", fetch = FetchType.EAGER)
    protected List<OrderItem> items;

}
