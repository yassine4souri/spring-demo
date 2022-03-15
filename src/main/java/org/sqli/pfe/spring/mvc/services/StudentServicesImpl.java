package org.sqli.pfe.spring.mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sqli.pfe.spring.mvc.models.entities.Student;
import org.sqli.pfe.spring.mvc.repositories.StudentDao;

import java.util.List;

@Service
public class StudentServicesImpl implements StudentServices {

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> getAllStudents() {
        return studentDao.findAll();
    }

    @Override
    public Student searchById(long id) {
        return studentDao.findById(id).get();
    }

    @Override
    public Student addNewStudent(Student student) {
        return studentDao.save(student);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentDao.save(student);
    }
}
