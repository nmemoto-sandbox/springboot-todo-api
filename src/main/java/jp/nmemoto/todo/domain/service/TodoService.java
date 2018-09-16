package jp.nmemoto.todo.domain.service;

import jp.nmemoto.todo.api.v1.dto.TodoDTO;

import java.util.List;

public interface TodoService {
    List<TodoDTO> findAll();

    TodoDTO find(Long id);

    TodoDTO create(TodoDTO todoDTO);

    TodoDTO patch(TodoDTO todoDTO);

    TodoDTO update(TodoDTO todoDTO);

    void delete(Long id);
}
