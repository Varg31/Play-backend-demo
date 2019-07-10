package DAO;

import DAO.interfaces.StudentDAO;
import models.Student;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;

import javax.ejb.Singleton;
import javax.inject.Inject;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Singleton
@Transactional
public class StudentJPARepository implements StudentDAO {
    private final JPAApi jpaApi;

    @Inject
    public StudentJPARepository(JPAApi jpaApi) {
        this.jpaApi = jpaApi;
    }

    @Override
    public Student save(Student student) {
        student.setStudentId(UUID.randomUUID().toString());
        jpaApi.em().persist(student);

        return student;
    }

    @Override
    public void update(Student student, String updatableId) {
        Student newStudent = findById(updatableId);

        if (newStudent == null) {
            throw new NoSuchElementException("No such student for updating");
        }

        newStudent.setName(student.getName());
        newStudent.setSurname(student.getSurname());
        newStudent.setMiddleName(student.getMiddleName());
        newStudent.setDateOfBirth(student.getDateOfBirth());
        newStudent.setStudentCardNumber(student.getStudentCardNumber());
        newStudent.setGender(student.getGender());

        jpaApi.em().persist(newStudent);
    }

    @Override
    public void delete(Student student) {
        Student deletedStudent = findById(student.getStudentId());
        if (deletedStudent == null) {
            throw new NoSuchElementException("No student with id: " + student.getStudentId());
        }

        jpaApi.em().remove(deletedStudent);
    }

    @Override
    public List<Student> findAll() {
        return jpaApi.em()
                .createQuery("select s from Student s", Student.class).getResultList();
    }

    @Override
    public Student findById(String id) throws NoSuchElementException{
        Student student = jpaApi.em()
                .createQuery("select s from Student s where s.studentId = :id", Student.class)
                .setParameter("id", id)
                .getSingleResult();

        if (student == null) {
            throw new NoSuchElementException("No student with id: " + id);
        }

        return student;
    }
}
