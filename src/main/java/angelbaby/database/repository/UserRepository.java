package angelbaby.database.repository;

import angelbaby.database.model.Product;
import angelbaby.database.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
