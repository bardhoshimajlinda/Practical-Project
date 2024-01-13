package entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter @Setter @ToString
@Table(name = "po_menu")
public class Menu extends BaseEntity {

    protected String name;
    protected double price;
}
