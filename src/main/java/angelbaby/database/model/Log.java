package angelbaby.database.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Log {

    @Id
    @SequenceGenerator(name="log_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="log_seq")
    private Long logID;

    private String type;

    @Nullable
    private Date productInDate;

    @Nullable
    private Date productOutDate;

    private int IOQuantity;
    private int totalQuantity;

    public Log(Long logID, String type, @Nullable Date productInDate, @Nullable Date productOutDate, int IOQuantity, int totalQuantity, Stock stock, User user) {
        this.logID = logID;
        this.type = type;
        this.productInDate = productInDate;
        this.productOutDate = productOutDate;
        this.IOQuantity = IOQuantity;
        this.totalQuantity = totalQuantity;
        this.stock = stock;
        this.user = user;
    }

    @OneToOne(targetEntity = Stock.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "stockID", referencedColumnName = "stockID")
    private Stock stock;

    @OneToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    private User user;

}
