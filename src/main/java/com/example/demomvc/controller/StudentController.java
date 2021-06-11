package com.example.demomvc.controller;

import com.example.demomvc.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Map;

@Controller
@RequestMapping("/student")
@PropertySource("classpath:country.properties")
public class StudentController {

    @Value("#{${countries}}")
    private Map<String,String> countryOptions;

    @GetMapping("/new")
    public String newStudent(Model model) {
        Student st = new Student();
        model.addAttribute("student", st);
        model.addAttribute("countries", countryOptions.entrySet());
        countryOptions.entrySet().forEach( e -> System.out.println(e.getKey() + ", " + e.getValue()));
        return "student/new";
    }

    @GetMapping("/show")
    public String showStudent() {
        return "student/show";
    }

    @GetMapping("/")
    public String index() {
        return "student/index";
    }

    // parameter kakoy
    @GetMapping("/edit")
    public String editStudent() {
        return "student/edit";
    }

    @GetMapping("/processNew")
    public String processNew(@ModelAttribute("student") Student student, Model model) {
        model.addAttribute("student", student);
        System.out.println(Arrays.toString(student.getOperatingSystems()));
        return "student/show";
    }
}
