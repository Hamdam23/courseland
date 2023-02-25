package com.courseland.course;

import com.courseland.lesson.Lesson;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
@Getter
@Setter
public class Course {

    private static final String GENERATOR_NAME = "GEN_COURSE";
    private static final String SEQUENCE_NAME = "SEQ_COURSE_ID";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = GENERATOR_NAME)
    @SequenceGenerator(name = GENERATOR_NAME, sequenceName = SEQUENCE_NAME, allocationSize = 1)
    private Long id;

    // TODO: 24/01/23 subject should be a separate table
    @Column(name = "subject")
    private String subject;

    @ElementCollection
    private List<Long> teachers = new ArrayList<>();

    @ElementCollection
    private List<Long> pupils = new ArrayList<>();

    @Column(name = "price")
    private Double price;

    @ElementCollection
    private List<Long> files = new ArrayList<>();

    @OneToMany
    private List<Lesson> lessons = new ArrayList<>();
}