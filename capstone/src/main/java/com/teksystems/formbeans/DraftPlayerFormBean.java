package com.teksystems.formbeans;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DraftPlayerFormBean {

    private Integer id;

    @NotNull(message = "Player cannot be empty")
    private Integer playerId;

}
