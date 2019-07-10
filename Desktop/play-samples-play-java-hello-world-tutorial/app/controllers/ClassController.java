package controllers;

import DAO.ClassJPARepository;
import com.fasterxml.jackson.databind.JsonNode;
import models.ClassEntity;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;

@Transactional
public class ClassController extends Controller {

    private final ClassJPARepository classRepository;

    @Inject
    public ClassController(ClassJPARepository classRepository) {
        this.classRepository = classRepository;
    }

    public Result create() {
        JsonNode node = request().body().asJson();
        ClassEntity classEntity = Json.fromJson(node, ClassEntity.class);

        return ok(Json.toJson(classRepository.save(classEntity)));
    }

    public Result getClassById(String id) {
        ClassEntity classEntity = classRepository.findById(id);

        return ok(Json.toJson(classEntity));
    }

    public Result getAllClasses() {
        List<ClassEntity> classes = classRepository.findAll();

        return ok(Json.toJson(classes));
    }

    public Result deleteClass(String id) {
        ClassEntity classEntity = classRepository.findById(id);
        classRepository.delete(classEntity);

        return ok();
    }
}
