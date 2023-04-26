package com.teksystems.formbeans;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TeamFormBean {


    private Integer id;

    @NotEmpty(message = "Team name cannot be empty")
    private String teamName;

    private String teamPicture;

}
