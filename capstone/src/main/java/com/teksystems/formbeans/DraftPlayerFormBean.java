package com.teksystems.formbeans;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DraftPlayerFormBean {

    private Integer id;

    private Integer teamId;

    private Integer playerId;

    private Integer draftPickNumber;

}
