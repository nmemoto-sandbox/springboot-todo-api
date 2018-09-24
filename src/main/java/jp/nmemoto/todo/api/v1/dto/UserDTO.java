package jp.nmemoto.todo.api.v1.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class UserDTO extends AbstractDTO {
    private Long id;
    private String username;
    private String password;
}
