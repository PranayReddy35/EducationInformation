package com.eduinformation.eduinformationapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.eduinformation.eduinformationapi.entity.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

	List<Student> findByFirstName(String firstName);
	List<Student> findByFirstNameContaining(String name);
	List<Student> findByLastNameNotNull();
	List<Student> findByGuardianName(String guardianName);
	List<Student> findByFirstNameAndLastName(String firstName,String lastName);
	
	//JPQL
	@Query("select s from Student s where s.emailId = ?1")
	Student getStudentByEmailAddress(String emailId);
	
	//JPQL
	@Query("select s.firstName from Student s where s.emailId = ?1")
	String  getStudentFirstNameByEmailAddress(String emailId);

	//Native
	@Query(
			value="select * from tbl_student s where s.email_address=?1",
			nativeQuery=true
			)
	Student getStudentByEmailAddressNative(String emailId);
	//Native named param
	@Query(
			value="select * from tbl_student s where s.email_address=:emailId",
			nativeQuery=true
	)
	Student getStudentByEmailAddressNativeNamedParam(
			@Param("emailId")String emailId);

//	@Modifying
//	@Transactional
//	@Query(value = "UPDATE tbl_student SET first_name = :firstName WHERE email_address = :emailId",
//			nativeQuery = true)
//	int updateStudentNameByEmailId(@Param("firstName") String firstName, @Param("emailId") String emailId);


}
