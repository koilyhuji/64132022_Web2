package com.pgq.Controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pgq.Models.Student;


@Controller
public class ListController {
    public List<Student> students = new ArrayList<>(Arrays.asList(
        new Student(1111, "Nguyen van A", "9.3"),
        new Student(2222, "Tran thi B", "4.4"),
        new Student(3333, "Ly thi C", "5.5"),
        new Student(1043, "Bui dan D", "7.7"),
        new Student(1054, "Le van E", "7.2")
    ));
    @GetMapping("/studentlist")
    public String studentlist(ModelMap map){
        
        map.addAttribute("students", students);
        return "list";
    };
    @GetMapping("/addnew")
    public String addnew(){


        return "addnew";
    }
    @PostMapping("/addnew")
    public String postaddnew(@RequestParam("id") int id,
            @RequestParam("name") String name,
            @RequestParam("grade") String grade,
            ModelMap map){

        students.add(new Student(id, name, grade));
        return "redirect:/studentlist";
    }
}
