package entities;

import jakarta.persistence.*;
import lombok.*;

@MappedSuperclass
@Getter @Setter @ToString
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
}
