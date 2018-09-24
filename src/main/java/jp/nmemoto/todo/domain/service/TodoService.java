package jp.nmemoto.todo.domain.service;

import jp.nmemoto.todo.api.v1.dto.TodoDTO;
import jp.nmemoto.todo.domain.model.User;

import java.util.List;

public interface TodoService {
    List<TodoDTO> findAll(User user);

    TodoDTO find(Long id, User user);

    void create(TodoDTO todoDTO, User user);

    void patch(TodoDTO todoDTO, User user);

    void update(TodoDTO todoDTO, User user);

    void delete(Long id, User user);
}
