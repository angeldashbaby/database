package angelbaby.database.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Location {

    @Id
    @SequenceGenerator(name="location_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="location_seq")
    private Long locationID;

    private int shelfID;

    @Nullable
    @OneToOne(targetEntity = Stock.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "stockID", referencedColumnName = "stockID")
    private Stock stockID;

}
