package jp.nmemoto.todo.api.v1.controller;

import jp.nmemoto.todo.api.v1.dto.UserDTO;
import jp.nmemoto.todo.api.v1.dto.UserMeDTO;
import jp.nmemoto.todo.domain.model.User;
import jp.nmemoto.todo.domain.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private UserService userService;
    private ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signUp(@RequestBody UserDTO userDTO) {
        userService.create(userDTO);
    }

    @GetMapping("/me")
    @ResponseStatus(HttpStatus.OK)
    public UserMeDTO findMe(@AuthenticationPrincipal(expression = "user") User user) {
        return mapToUserMeDTO(user);
    }

    private UserMeDTO mapToUserMeDTO(User user) {
        UserMeDTO userMeDTO = modelMapper.map(user, UserMeDTO.class);
        return userMeDTO;
    }
}
