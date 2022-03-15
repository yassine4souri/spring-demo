package org.sqli.pfe.spring.mvc.repositories.impl;

import org.springframework.stereotype.Repository;
import org.sqli.pfe.spring.mvc.repositories.StudentDao;
import org.sqli.pfe.spring.mvc.models.entities.Student;

import java.util.*;

@Repository
public class StudentMemoryDao implements StudentDao {

    private final static List<Student> db = new ArrayList<>();
    static {
        Student student=new Student("yassine","name@gmail.com");
        Student student1=new Student("med","name@gmail.com");
        Student student2=new Student("me","name@gmail.com");
        db.add(student);
        db.add(student1);
        db.add(student2);


    }


    private static long ID_GENERATOR = 0;



    @Override
    public List<Student> findAll() {
        return Collections.unmodifiableList(db);
    }

    @Override
    public Optional<Student> findById(long id) {
        return db.stream().filter(student -> student.getId() == id).findAny();
    }

    @Override
    public Student save(Student student) {
        if (Objects.nonNull(student)) {
            student.setId(++ID_GENERATOR);

            db.add(student);
            return student;
        }
        return null;
    }

}
