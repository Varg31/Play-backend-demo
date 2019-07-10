package DAO;

import DAO.interfaces.ClassDAO;
import models.ClassEntity;
import play.db.jpa.JPAApi;

import javax.inject.Inject;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

public class ClassJPARepository implements ClassDAO {
    private final JPAApi jpaApi;

    @Inject
    public ClassJPARepository(JPAApi jpaApi) {
        this.jpaApi = jpaApi;
    }

    @Override
    public List<ClassEntity> findAll() {
        return jpaApi.em().createQuery("select s from ClassEntity s", ClassEntity.class).getResultList();
    }

    @Override
    public ClassEntity findById(String id) {
        ClassEntity classEntity = jpaApi.em()
                .createQuery("select s from ClassEntity s where s.classId = :id", ClassEntity.class)
                .setParameter("id", id)
                .getSingleResult();

        if (classEntity == null) {
            throw new NoSuchElementException("No student with id: " + id);
        }

        return classEntity;
    }

    @Override
    public ClassEntity save(ClassEntity classEntity) {
        classEntity.setClassId(UUID.randomUUID().toString());
        jpaApi.em().persist(classEntity);

        return classEntity;
    }

    @Override
    public void update(ClassEntity classEntity, String updatableId) {
        ClassEntity newClass = findById(updatableId);

        if (newClass == null) {
            throw new NoSuchElementException("No class with id: " + updatableId);
        }

        newClass.setTitle(classEntity.getTitle());
        jpaApi.em().persist(newClass);
    }

    @Override
    public void delete(ClassEntity classEntity) {
        ClassEntity deletedClass = findById(classEntity.getClassId());
        if (deletedClass == null) {
            throw new NoSuchElementException("No student with id: " + classEntity.getClassId());
        }

        jpaApi.em().remove(deletedClass);
    }
}
