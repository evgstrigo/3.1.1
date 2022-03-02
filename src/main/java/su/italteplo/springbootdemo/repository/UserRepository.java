package su.italteplo.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import su.italteplo.springbootdemo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
