package com.app.ems.repository;

import com.app.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Modifying
    @Query(value = "Alter table employees auto_increment = 1", nativeQuery = true)
    void resetIdSequence();
}
