package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;


@Entity
@Getter @Setter @ToString
@Table(name = "po_menu")
public class Menu extends BaseEntity {

    protected String name;
    protected double price;
}
