package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	@Query("from Student where lastName=?1 order by firstName")
	List<Student> findByLnameSorted(String lastName);
	
	
	List<Student> findByAge(int age);

	Optional<Student> findByFirstName(String firstName);

}
