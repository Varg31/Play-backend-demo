package controllers;

import DAO.StudentJPARepository;
import com.fasterxml.jackson.databind.JsonNode;
import models.Student;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;

@Transactional
public class StudentController extends Controller {

    private final StudentJPARepository jpaRepository;

    @Inject
    public StudentController(StudentJPARepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    public Result create() {
        JsonNode node = request().body().asJson();
        Student student = Json.fromJson(node, Student.class);

        return ok(Json.toJson(jpaRepository.save(student)));
    }

    public Result getStudent(String id) {
        Student student = jpaRepository.findById(id);

        return ok(Json.toJson(student));
    }

    public Result getAllStudents() {
        List<Student> students = jpaRepository.findAll();

        return ok(Json.toJson(students));
    }

    public Result deleteStudent(String id) {
        Student student = jpaRepository.findById(id);
        jpaRepository.delete(student);

        return ok();
    }
}
