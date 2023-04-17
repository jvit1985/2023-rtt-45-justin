package com.teksystems.formbeans;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

@Getter
@Setter
public class DraftPlayerFormBean {

    private Integer id;

    @NotEmpty(message = "Team is required")
    private Integer teamId;

    @NotEmpty(message = "Player is required")
    private Integer playerId;

    @NotEmpty(message = "Draft Pick Number is required")
    private Integer draftPickNumber;

}
