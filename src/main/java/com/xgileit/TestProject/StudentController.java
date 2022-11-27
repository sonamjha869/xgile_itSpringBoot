package com.xgileit.TestProject;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;

@RestController //@ annotation
public class StudentController {
    /**
     * Map of Student Name as Key, Student Request as Value
     **/
    public static HashMap<String, StudentRequest> studentMap = new HashMap<String, StudentRequest>();


    /* @GetMapping("/")
     public String hello () {
         return "hello sonam jha";
     }*/
    @GetMapping("/")
    public String methodone() {
        return "This is a get Method";
    }

    @PostMapping("/")
    public String methodtwo() {
        return "This is a Post Method";
    }

    @PutMapping("/")
    public String methodthree() {
        return "This is a Put Method";
    }

    @DeleteMapping("/")
    public String methodfour() {
        return "This is a Delete Method";
    }

    @PostMapping("/create")
    public String methodtwo1() {
        return "This is a Post Method";
    }

    @PostMapping("/add")
    public String addMethod(@RequestParam Integer num1,
                            @RequestParam Integer num2) {

        Integer addition = num1 + num2;
        return " The Addition is " + addition;
    }

    @PostMapping("/multiply")
    public String multiply(@RequestParam Integer num1,
                           @RequestParam Integer num2) {
        Integer multiply = num1 * num2;
        return "The Addition is ";
    }

    /**
     * Add Student
     **/
    @PostMapping("/student")
    public StudentResponse addStudent(@RequestBody StudentRequest studentRequest) {
        System.out.println("This is Student Request Body Name: " + studentRequest.name);

        studentMap.put(studentRequest.name, studentRequest);

        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setStudent(studentRequest);
        studentResponse.setResult("Student Record is added successfully");

        return studentResponse;
    }

    /**
     * Get All Student Records
     **/
    @GetMapping("/student")
    public Collection<StudentRequest> getStudentDetails() {
        return studentMap.values();
    }

    /**
     * Delete Student
     **/
    @DeleteMapping("/student")
    public StudentResponse deleteStudent(@RequestParam String name) {
        studentMap.remove(name);
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setResult("Student Record is Deleted successfully for student : " + name);
        return studentResponse;
    }

    /**
     * Update Student Record
     **/
    @PutMapping("/student")
    public StudentResponse updateStudent(@RequestParam String name, @RequestBody StudentRequest studentRequest) {

        studentMap.put(name, studentRequest);
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setStudent(studentRequest);
        studentResponse.setResult("Student Record is updated successfully for student : " + name);
        return studentResponse;
    }

    /**
     * Get Student Record by name
     **/
    @GetMapping("/studentByName")
    public StudentResponse getStudentByName(@RequestParam String name) {

        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setStudent(studentMap.get(name));
        studentResponse.setResult("Student Details");
        return studentResponse;
    }
}
