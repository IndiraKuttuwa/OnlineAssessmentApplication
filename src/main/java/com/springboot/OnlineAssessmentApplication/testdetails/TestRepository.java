package com.springboot.OnlineAssessmentApplication.testdetails;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<TestDetails, String> {

}
