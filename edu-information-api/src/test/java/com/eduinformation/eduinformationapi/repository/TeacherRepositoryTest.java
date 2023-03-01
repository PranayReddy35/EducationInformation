package com.eduinformation.eduinformationapi.repository;

import com.eduinformation.eduinformationapi.entity.Course;
import com.eduinformation.eduinformationapi.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){

        Course courseDBA= Course.builder()
                .title("DBA")
                .credit(5)
                .build();

        Course courseJava= Course.builder()
                .title("Java")
                .credit(6)
                .build();

        Teacher teacher=
                Teacher.builder()
                        .firstName("Unni")
                        .lastName("Krishnan")
//                        .courses(Arrays.asList(courseDBA, courseJava))
                        .build();

        teacherRepository.save(teacher);

    }
}