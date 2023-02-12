package com.courseland.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "app_user")
@Getter
@Setter
public class AppUser {

    private static final String GENERATOR_NAME = "GEN_APP_USER";
    private static final String SEQUENCE_NAME = "SEQ_APP_USER";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = GENERATOR_NAME)
    @SequenceGenerator(name = GENERATOR_NAME, sequenceName = SEQUENCE_NAME, allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "avatar_id")
    private Long avatarId;
}
