package angelbaby.database.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    public Product(Long itemID, String name, String description, String supplierName) {
        this.itemID = itemID;
        this.name = name;
        this.description = description;
        this.supplierName = supplierName;
    }
}
