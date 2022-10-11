package angelbaby.database.repository;

import angelbaby.database.model.Location;
import angelbaby.database.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

}
