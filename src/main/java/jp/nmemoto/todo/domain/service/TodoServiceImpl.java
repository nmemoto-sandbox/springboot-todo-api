package jp.nmemoto.todo.domain.service;

import jp.nmemoto.todo.api.v1.dto.TodoDTO;
import jp.nmemoto.todo.api.v1.dto.UserDTO;
import jp.nmemoto.todo.domain.model.Todo;
import jp.nmemoto.todo.domain.model.User;
import jp.nmemoto.todo.domain.repository.TodoRepository;
import jp.nmemoto.todo.domain.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;
    private ModelMapper modelMapper;

    public TodoServiceImpl(TodoRepository todoRepository, ModelMapper modelMapper) {
        this.todoRepository = todoRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional(readOnly = true)
    public List<TodoDTO> findAll(User user) {
        List<TodoDTO> result = new ArrayList<>();
        todoRepository.findByUser(user).forEach(todo -> {
            result.add(mapToTodoDTO(todo));
        });
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public TodoDTO find(Long id, User user) {
        Optional<Todo> todoOptional = todoRepository.findByIdAndUser(id, user);
        if (todoOptional.isPresent()) {
            Todo todo = todoOptional.get();
            return mapToTodoDTO(todo);
        } else {
            //TODO
            throw new EntityNotFoundException();
        }
    }

    @Override
    @Transactional
    public void create(TodoDTO todoDTO, User user) {
        Todo mapToTodo = mapToTodo(todoDTO);
        mapToTodo.setUser(user);
        todoRepository.save(mapToTodo);
    }

    @Override
    @Transactional
    public void patch(TodoDTO todoDTO, User user) {
        todoRepository.findByIdAndUser(todoDTO.getId(),user).map(todo -> {
            if(todoDTO.getName() != null){
                todo.setName(todoDTO.getName());
            }
            if(todoDTO.getDone() != null){
                todo.setDone(todoDTO.getDone());
            }
            return todoRepository.save(todo);
        }).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    @Transactional
    public void update(TodoDTO todoDTO, User user) {
        Optional<Todo> todoOptional = todoRepository.findByIdAndUser(todoDTO.getId(), user);
        if (todoOptional.isPresent()) {
            todoRepository.save(mapToTodo(todoDTO));
        } else {
            //TODO
            throw new EntityNotFoundException();
        }
    }

    @Override
    @Transactional
    public void delete(Long id, User user) {
        todoRepository.deleteByIdAndUser(id, user);
    }


    private Todo mapToTodo(TodoDTO todoDTO) {
        return modelMapper.map(todoDTO, Todo.class);
    }

    private TodoDTO mapToTodoDTO(Todo todo) {
        return modelMapper.map(todo, TodoDTO.class);
    }

}
