package com.teksystems.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "team_name")
    private String teamName;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "team_picture")
    private String teamPicture;

    @ToString.Exclude
//    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<TeamPlayer> teamPlayers;

}
