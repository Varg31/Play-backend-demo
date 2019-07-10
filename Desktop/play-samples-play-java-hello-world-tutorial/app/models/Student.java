package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import models.enums.Gender;

import javax.persistence.*;

@Entity
@Table(name = "students", schema = "institution", indexes =
        {@Index(name = "card_number_index", columnList = "student_card_number")})
@EqualsAndHashCode(exclude = {"classEntity"})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "student_id", nullable = false)
    private String studentId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "date_of_birth", nullable = false)
    private String dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Column(name = "student_card_number", nullable = false, unique = true)
    private Integer studentCardNumber;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id", referencedColumnName = "class_id")
    private ClassEntity classEntity;

    public Student(String name, String surname, String middleName, String dateOfBirth, Gender gender, Integer studentCardNumber) {
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.studentCardNumber = studentCardNumber;
    }
}
