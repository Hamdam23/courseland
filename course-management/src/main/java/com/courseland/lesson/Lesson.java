package com.courseland.lesson;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.courseland.course.Course;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "lessons")
@Getter
@Setter
public class Lesson {

    private static final String GENERATOR_NAME = "GEN_LESSON";
    private static final String SEQUENCE_NAME = "SEQ_LESSON_ID";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = GENERATOR_NAME)
    @SequenceGenerator(name = GENERATOR_NAME, sequenceName = SEQUENCE_NAME, allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name="course_id", nullable=false)
    private Course course;

    @Column(name = "title")
    private String title;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "study_materials")
    @ElementCollection
    private List<Long> studyMaterials;

    @Column(name = "related_resources")
    @ElementCollection
    private List<Long> relatedResources;
}
