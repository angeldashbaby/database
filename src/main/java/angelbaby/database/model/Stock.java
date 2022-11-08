package angelbaby.database.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Stock {

    @Id
    @SequenceGenerator(name="stock_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="stock_seq")
    private Long stockID;

    private Date expire;
    private int quantity;

    @OneToOne(targetEntity = Product.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "itemID", referencedColumnName = "itemID")
    private Product item;

    public boolean useQuantity(int amount) {
        if (quantity - amount >= 0) {
            quantity -= amount;
            return true;
        }
        return false;

    }

    public Stock(Long stockID, Date expire, int quantity, Product item) {
        this.stockID = stockID;
        this.expire = expire;
        this.quantity = quantity;
        this.item = item;
    }
}
