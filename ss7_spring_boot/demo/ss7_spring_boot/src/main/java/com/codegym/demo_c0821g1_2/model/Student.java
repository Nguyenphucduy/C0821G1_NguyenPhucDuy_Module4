package com.codegym.demo_c0821g1_2.model;

import javax.persistence.*;

//Thuộc tính name giúp xác định table được liên kết
@Entity(name = "student")
public class Student { //Table: student
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Tự động tăng
    @Column(name = "id")
    private Integer id; //-> thuộc tính id
    @Column(name = "name")
    private String name; //-> thuộc tính name

    @Column(name = "date_of_birth", columnDefinition = "DATE")
    private String dateOfBirth; //-> thuộc tính date_of_birth

    @Column(name = "gender")
    private Integer gender;

    @Column(name = "grade")
    private Double grade;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassRoom classRoom;

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public Student() {
    }

    public Student(Integer id, String name,
                   String dateOfBirth, Integer gender, Double grade) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
}
