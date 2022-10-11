package angelbaby.database.repository;

import angelbaby.database.model.Log;
import angelbaby.database.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {

}
