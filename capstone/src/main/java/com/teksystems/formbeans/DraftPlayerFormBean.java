package com.teksystems.formbeans;

import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

@Getter
@Setter
public class DraftPlayerFormBean {

    private Integer id;

    @NotNull(message = "Team cannot be empty")
    private Integer teamId;

    @NotNull(message = "Player cannot be empty")
    private Integer playerId;

    @NotNull(message = "Draft Pick cannot be empty")
    private Integer draftPickNumber;

}
