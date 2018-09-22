package jp.nmemoto.todo.domain.service;

import jp.nmemoto.todo.api.v1.dto.TodoDTO;
import jp.nmemoto.todo.domain.model.User;

import java.util.List;

public interface TodoService {
    List<TodoDTO> findAll(User user);

    TodoDTO find(Long id, User user);

    TodoDTO create(TodoDTO todoDTO, User user);

    TodoDTO patch(TodoDTO todoDTO, User user);

    TodoDTO update(TodoDTO todoDTO, User user);

    void delete(Long id, User user);
}
