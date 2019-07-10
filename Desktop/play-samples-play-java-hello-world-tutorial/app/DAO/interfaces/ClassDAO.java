package DAO.interfaces;


import DAO.ClassJPARepository;
import com.google.inject.ImplementedBy;
import models.ClassEntity;

import java.util.List;

@ImplementedBy(ClassJPARepository.class)
public interface ClassDAO {
    List<ClassEntity> findAll();
    ClassEntity findById(String id);
    ClassEntity save(ClassEntity classEntity);
    void update(ClassEntity classEntity, String updatableId);
    void delete(ClassEntity classEntity);

//    void addDisciplineToClass(Discipline discipline, Long classId);
//    List<Discipline> getDisciplinesByClassId(Long classId);
//    void removeDiscipline(Long classId, Long disciplineId);
//    void addStudentToClass(Student student, Long classId);
//    List<Student> getStudentsByClassId(Long classId);
//    void removeStudent(Long classId, Long studentId);
//    List<Teacher> getTeachersByClassId(Long classId);
//    void addTeacherToClass(Teacher teacher, Long classId);
//    void removeTeacher(Long classId, Long teacherId);
//
//    ClassEntity findByTitle(String title);
}
