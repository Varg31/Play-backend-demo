package DAO.interfaces;

import models.Teacher;

import java.util.List;

public interface TeacherDAO {
    List<Teacher> findAll();
    Teacher findById(String id);
    Teacher save(Teacher student);
    void update(Teacher student, String updatableId);
    void delete(Teacher student);

//    void addDisciplineForTeacher(Discipline discipline, Long teacherId);
//    List<Discipline> getDisciplinesByTeacherId(Long teacherId);
//    void removeDiscipline(Long teacherId, Long disciplineId);
//    List<ClassEntity> getClassesByTeacherId(Long teacherId);
//
//    Teacher findByEmploymentBookNumber(Integer number);
}
