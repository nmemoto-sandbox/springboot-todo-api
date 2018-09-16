package jp.nmemoto.todo.domain.repository;

import jp.nmemoto.todo.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
