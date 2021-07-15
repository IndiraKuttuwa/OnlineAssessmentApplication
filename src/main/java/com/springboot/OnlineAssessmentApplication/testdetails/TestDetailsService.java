package com.springboot.OnlineAssessmentApplication.testdetails;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestDetailsService {
	
	@Autowired
	TestRepository testRepository;
	
	

	public void add(TestDetails details) {
		// TODO Auto-generated method stub
		testRepository.save(details);
	}
	
	public ArrayList<TestDetails> findAll()
	{
		return (ArrayList<TestDetails>) testRepository.findAll();
	}
	

}
