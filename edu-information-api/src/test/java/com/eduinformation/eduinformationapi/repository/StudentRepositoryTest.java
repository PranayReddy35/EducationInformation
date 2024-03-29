package com.eduinformation.eduinformationapi.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eduinformation.eduinformationapi.entity.Guardian;
import com.eduinformation.eduinformationapi.entity.Student;


@SpringBootTest
class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepository;

//	@Test
//	public void saveStudent() {
//		Student student= Student.builder()
//				.emailId("Pranayalwa@gmail.com")
//				.firstName("Pranay")
//				.lastName("Reddy")
////				.guardianName("AnanthaReddy")
////				.guardianEmail("Ananthaalwa@gmail.com")
////				.guardianMobile("1234567890")
//				.build();
//
//		studentRepository.save(student);
//	}
	@Test
	public void saveStudentWithGuardian() {
		
		Guardian guardian=Guardian.builder()
				.name("AmruthaReddy")
				.email("Amruthaalwa@gmail.com")
				.mobile("1234567890")
				.build();						
				
		Student student= Student.builder()
				.emailId("Deekshaalwa@gmail.com")
				.firstName("Deeksha")
				.lastName("Reddy")
				.guardian(guardian)
				.build();
		
		studentRepository.save(student);		
	}
	@Test
	public void printAllStudent() {
		List<Student> studentList=
				studentRepository.findAll();
		
		System.out.println("StudentList = " + studentList);
	}
	@Test
	public void printStudentByFirstName() {
		List<Student>students=
				studentRepository.findByFirstName("Deeksha");
		System.out.println("Students = "+students);
	}
	@Test
	public void printStudentByFirstNameContaining() {
		List<Student>students=
				studentRepository.findByFirstNameContaining("De");
		System.out.println("Students = "+students);
	}
	@Test
	public void printStudentBasedOnGuardianName() {
		List<Student> students=
				studentRepository.findByGuardianName("AmruthaReddy");
		System.out.println("Students = "+students);
	}
	@Test
	public void printGetStudentByEmailAddress() {
		Student student=
				studentRepository.getStudentByEmailAddress(
						"Deekshaalwa@gmail.com");
		System.out.println("Students = "+student);
	}
	@Test
	public void printStudentFirstNameByEmailAddress() {
		String firstName=
				studentRepository.getStudentFirstNameByEmailAddress(
						"Deekshaalwa@gmail.com");
		System.out.println("FirstName = "+firstName);
	}
	@Test
	public void printGetStudentByEmailAddressNative() {

		Student student=
				studentRepository.getStudentByEmailAddressNative(
						"Deekshaalwa@gmail.com");
		System.out.println("Students = "+student);
	}
	@Test
	public void printGetStudentByEmailAddressNativeNamedParam(){
		Student student=
				studentRepository.getStudentByEmailAddressNativeNamedParam(
						"Deekshaalwa@gmail.com");
		System.out.println("Students = "+student);
	}
//	@Test
//	public void updateStudentNameByEmailIdTest(){
//		studentRepository.updateStudentNameByEmailId(
//				"Deekshitha","Deekshaalwa@gmail.com");
//	}


}
