package angelbaby.database.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @SequenceGenerator(name="product_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="product_seq")
    private Long itemID;

    private String name;
    private String description;
    private String supplierName;

}
