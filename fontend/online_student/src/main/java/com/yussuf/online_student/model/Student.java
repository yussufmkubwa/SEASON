package com.yussuf.online_student.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "StudentName")
    private String StudentName;

    @Column(name = "StudentEmail")
    private String StudentEmail;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "courseID")
    private Course course;







}
