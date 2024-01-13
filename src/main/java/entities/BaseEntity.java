package entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.util.UUID;


@MappedSuperclass
@Getter @Setter @ToString
public class BaseEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid2", strategy = "uuid2")
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(name = "id", updatable = false, nullable = false)
    protected UUID id;
}
