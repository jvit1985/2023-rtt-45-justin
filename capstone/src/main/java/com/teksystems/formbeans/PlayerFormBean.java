package com.teksystems.formbeans;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PlayerFormBean {

    @NotEmpty(message = "Player Id is required")
    private Integer id;

    @NotEmpty(message = "Player name is required")
    private String name;

    private String team;

    @NotEmpty(message = "Player position is required")
    private String position;

    private Integer bye;
}
