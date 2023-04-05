package com.teksystems.formbeans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PlayerFormBean {

    private Integer id;

    private String name;

    private String team;

    private String position;

    private Integer bye;
}
