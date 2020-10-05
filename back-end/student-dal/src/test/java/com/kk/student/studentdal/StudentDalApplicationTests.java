package com.kk.student.studentdal;

import com.kk.student.studentdal.entities.Student;
import com.kk.student.studentdal.repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentDalApplicationTests {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void testCreateStudent() {
        Student student = new Student();
        student.setName("Krishnakanth");
        student.setCourse("FullStack");
        student.setFee(1000d);

        studentRepository.save(student);
    }

    @Test
    public void testFindStudentById() {
        Optional<Student> student = studentRepository.findById(1L);
        System.out.println(student.isPresent());
    }

    @Test
    public void testUpdateStudent() {
        Optional<Student> student = studentRepository.findById(1L);
        if (student.isPresent()) {
            student.get().setFee(100d);
            studentRepository.save(student.get());
        }
    }

    @Test
    public void tesDeleteStudent() {
        Student s = new Student();
        s.setId(1L);
        studentRepository.delete(s);
    }

}
