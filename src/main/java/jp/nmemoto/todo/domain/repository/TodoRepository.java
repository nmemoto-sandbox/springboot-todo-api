package jp.nmemoto.todo.domain.repository;

import jp.nmemoto.todo.domain.model.Todo;
import jp.nmemoto.todo.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    public List<Todo> findByUser(User user);

    public Optional<Todo> findByIdAndUser(Long id, User user);

    public void deleteByIdAndUser(Long id, User user);


}
