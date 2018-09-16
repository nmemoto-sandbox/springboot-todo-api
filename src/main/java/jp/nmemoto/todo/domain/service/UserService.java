package jp.nmemoto.todo.domain.service;

import jp.nmemoto.todo.api.v1.dto.UserDTO;

public interface UserService {
    void create(UserDTO userDTO);
}
