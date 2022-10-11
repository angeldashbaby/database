package angelbaby.database.repository;

import angelbaby.database.model.Stock;
import angelbaby.database.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

}
