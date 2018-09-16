package jp.nmemoto.todo.api.v1.controller;

import jp.nmemoto.todo.api.v1.dto.TodoDTO;
import jp.nmemoto.todo.domain.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<TodoDTO> findAll() {
        return todoService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public TodoDTO find(@PathVariable Long id) {
        return todoService.find(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public TodoDTO create(@RequestBody TodoDTO todoDTO) {
        return todoService.create(todoDTO);
    }


    @RequestMapping(method = RequestMethod.PATCH, value = "{id}")
    public TodoDTO patch(@PathVariable Long id, @RequestBody TodoDTO todoDTO) {
        todoDTO.setId(id);
        return todoService.patch(todoDTO);
    }


    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public TodoDTO update(@PathVariable Long id, @RequestBody TodoDTO todoDTO) {
        todoDTO.setId(id);
        return todoService.update(todoDTO);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        todoService.delete(id);
    }

}
