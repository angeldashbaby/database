package angelbaby.database.repository;

import angelbaby.database.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // SELECT * FROM User WHERE username = ‘username in parameter’
    User findByUsername(String username);
}
