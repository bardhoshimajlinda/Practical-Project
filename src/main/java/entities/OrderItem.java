package entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;

@Entity
@Table(name = "po_order_item")
@Getter @Setter @ToString
public class OrderItem extends BaseEntity{

    protected double quantity;

    @Column(name = "product_price")
    protected double productPrice;

    @Column(name = "product_name")
    protected String productName;

    @Column(name = "order_id")
    protected int orderId;

    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    protected Order order;

}
