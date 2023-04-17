package com.teksystems.formbeans;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TeamFormBean {

    @NotEmpty(message = "Team number cannot be empty")
    private Integer id;

    @NotEmpty(message = "Team name cannot be empty")
    private String teamName;

    private String teamPicture;

}
