package jp.nmemoto.todo.domain.service;

import jp.nmemoto.todo.api.v1.dto.TodoDTO;
import jp.nmemoto.todo.domain.model.Todo;

import java.util.List;

public interface TodoService {
    List<TodoDTO> findAll();

    TodoDTO find(Long id);

    TodoDTO create(TodoDTO todoDTO);

    TodoDTO update(TodoDTO todoDTO);

    void delete(Long id);
}
