/*
 * Copyright (c) 2020. Krishnakanth Yachareni
 */

package com.kk.student.studentdal.repository;

import com.kk.student.studentdal.entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
