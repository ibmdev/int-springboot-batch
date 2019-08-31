package com.ibm.batch.repositories;

import com.ibm.batch.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by karim on 30/08/2019.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
