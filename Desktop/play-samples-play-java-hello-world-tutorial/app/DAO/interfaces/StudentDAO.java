package DAO.interfaces;

import DAO.StudentJPARepository;
import com.google.inject.ImplementedBy;
import models.Student;

import java.util.List;

@ImplementedBy(StudentJPARepository.class)
public interface StudentDAO {
    List<Student> findAll();
    Student findById(String id);
    Student save(Student student);
    void update(Student student, String updatableId);
    void delete(Student student);

    //Student findByStudentCardNumber(Integer number);

}
