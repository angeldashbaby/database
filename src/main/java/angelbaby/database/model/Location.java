package angelbaby.database.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
public class Location {

    @Id
    @SequenceGenerator(name="location_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="location_seq")
    private Long locationID;

    private int shelfID;

}
