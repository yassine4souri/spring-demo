package org.sqli.pfe.spring.mvc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.sqli.pfe.spring.mvc.models.entities.Student;
import org.sqli.pfe.spring.mvc.services.StudentServices;

import java.util.List;


@Controller
@RequestMapping("/students")
public class ProductController {

    @Autowired
    StudentServices studentServices;


    @GetMapping()
    public String getAllStudent(Model model)
    {
        List<Student> students = studentServices.getAllStudents();
        model.addAttribute("students", students);
        students.forEach(acction -> {
            System.out.println("test----" + acction);
        });
        return "students/listStudents";
    }



    @GetMapping("/addView")
    public String showNewCourseForm(Model model)
    {
        Student student = new Student();
        model.addAttribute("student", student);


        return "students/studentForm";
    }



    @GetMapping("/{id}")
    public String studentDetails(@PathVariable long id ,Model model) {

        Student student =this.studentServices.searchById(id);
        model.addAttribute("student", student);

        return "students/studentProfil";
    }

    @PostMapping("/addAction")
    public String saveCourse(@ModelAttribute("student") Student student ,Model model )
    {
        Student student1=studentServices.saveStudent(student);

        return "redirect:/students";
    }


}
