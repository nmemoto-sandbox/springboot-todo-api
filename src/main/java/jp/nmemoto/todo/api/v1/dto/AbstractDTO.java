package jp.nmemoto.todo.api.v1.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public abstract class AbstractDTO {
    private Date createdAt;
    private Date updatedAt;
}
