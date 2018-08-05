package jp.nmemoto.todo.api.v1.dto;

import lombok.Data;

@Data
public class TodoDTO {
    private Long id;
    private String name;
    private Boolean done;
}
