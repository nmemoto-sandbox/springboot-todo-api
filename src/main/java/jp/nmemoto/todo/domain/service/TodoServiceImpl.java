package jp.nmemoto.todo.domain.service;

import jp.nmemoto.todo.api.v1.dto.TodoDTO;
import jp.nmemoto.todo.domain.model.Todo;
import jp.nmemoto.todo.domain.repository.TodoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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

    public List<TodoDTO> findAll() {
        List<TodoDTO> result = new ArrayList<>();
        todoRepository.findAll().forEach(todo -> {
            result.add(modelMapper.map(todo, TodoDTO.class));
        });
        return result;
    }

    @Override
    public TodoDTO find(Long id) {
        Optional<Todo> todoOptional = todoRepository.findById(id);
        if (todoOptional.isPresent()) {
            Todo todo = todoOptional.get();
            return modelMapper.map(todo, TodoDTO.class);
        } else {
            //TODO
            throw new EntityNotFoundException();
        }
    }

    @Override
    public TodoDTO create(TodoDTO todoDTO) {
        Todo todo = todoRepository.save(modelMapper.map(todoDTO, Todo.class));
        return modelMapper.map(todo, TodoDTO.class);
    }

    @Override
    public TodoDTO patch(TodoDTO todoDTO) {
        return todoRepository.findById(todoDTO.getId()).map(todo -> {
            if(todoDTO.getName() != null){
                todo.setName(todoDTO.getName());
            }
            if(todoDTO.getDone() != null){
                todo.setDone(todoDTO.getDone());
            }
            TodoDTO returnDto = modelMapper.map(todoRepository.save(todo), TodoDTO.class);
            returnDto.setId(todo.getId());
            return returnDto;
            // TODO
        }).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public TodoDTO update(TodoDTO todoDTO) {
        Optional<Todo> todoOptional = todoRepository.findById(todoDTO.getId());
        if (todoOptional.isPresent()) {
            Todo todoUpdate = todoRepository.save(modelMapper.map(todoDTO, Todo.class));
            return modelMapper.map(todoUpdate, TodoDTO.class);
        } else {
            //TODO
            throw new EntityNotFoundException();
        }
    }

    @Override
    public void delete(Long id) {
        todoRepository.deleteById(id);
    }
}
