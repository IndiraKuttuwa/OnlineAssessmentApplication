package com.springboot.OnlineAssessmentApplication.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.OnlineAssessmentApplication.testdetails.TestDetails;
import com.springboot.OnlineAssessmentApplication.testdetails.TestDetailsService;
import com.springboot.OnlineAssessmentApplication.user.User;
import com.springboot.OnlineAssessmentApplication.user.UserDaoService;


@Controller
@EnableAutoConfiguration
public class WebController {

	@Autowired
	UserDaoService service;

	@Autowired
	TestDetailsService addDetails;

	String emailLoggedIn;

	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}

	
	@RequestMapping("/index")
	public String redirectIndex() {
		
		return "redirect:/";
		
	}

	@RequestMapping(value = "/login/do", method = RequestMethod.POST)
	public String validate(@RequestParam(value = "email") String email,
			@RequestParam(value = "password") String password) {
		service.addAdmins();
		User user = service.findOne(email);
		boolean admin = service.checkIfAdmin(email);

		if (user == null)
			return "InvalidUser.html";

		else if (!user.getPassword().equals(password))
			return "PasswordError.html";

		else if (admin) {

			return "SelectReports.html";

		}

		else {
			emailLoggedIn = email;
			return "SelectTests.html";
		}

	}

	@RequestMapping("/registration.html")
	public String registrationPage() {


		 return "registration.html";
	}

	@RequestMapping(value = "/registration/do", method = RequestMethod.POST)
	public String register(@RequestParam(value = "firstname") String firstName,
			@RequestParam(value = "lastname") String lastName, @RequestParam(value = "email") String email,
			@RequestParam(value = "password") String password, Model model) {
		User user = new User();

		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(password);
		user.setUserType("candidate");
		service.save(user);
		model.addAttribute("firstname", user.getFirstName());
		model.addAttribute("lastname", user.getLastName());

	
		return "confirmationPage.html";
	}
	

	@RequestMapping(value = "/evaluate/spring/test", method = RequestMethod.POST)
	public String evaluateSpring(@RequestParam(required = false, value = "Question1") String answer1,
			@RequestParam(required = false, value = "Question2") String answer2,
			@RequestParam(required = false, value = "Question3") String answer3,
			@RequestParam(required = false, value = "Question4") String answer4,
			@RequestParam(required = false, value = "Question5") String answer5) {
		TestDetails details = new TestDetails();

		LocalDateTime dateAndTime = LocalDateTime.now();
		DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

		String date = dateAndTime.format(myFormat);
		details.setAssessment("Spring-L1");
		details.setFormattedDate(date);
		details.setTotalMarks(50);
		details.setEmail(emailLoggedIn);
		int total = 0;
		try {
			if (answer1.equals("J2EE App Development Framework"))
				total += 10;
		} catch (Exception e) {

		}
		try {
			if (answer2.equals("Inversion of Control"))
				total += 10;
		} catch (Exception e) {

		}
		try {
			if (answer3.equals("Aspect Oriented Programming"))
				total += 10;
		} catch (Exception e) {

		}
		try {
			if (answer4.equals("Application Context"))
				total += 10;
		} catch (Exception e) {

		}
		try {
			if (answer5.equals("Dispatcher Servlet"))
				total += 10;
		} catch (Exception e) {

		}
		details.setTestMarks(total);

		if (total >= 30) {
			details.setResult("Passed");
			addDetails.add(details);
			return "successPage.html";
		}

		else {
			details.setResult("Failed");
			addDetails.add(details);
			return "failurePage.html";
		}

	}

	@RequestMapping(value = "/evaluate/hibernate/test", method = RequestMethod.POST)
	public String evaluateHibernate(@RequestParam(required = false, value = "Question1") String answer1,
			@RequestParam(required = false, value = "Question2") String answer2,
			@RequestParam(required = false, value = "Question3") String answer3,
			@RequestParam(required = false, value = "Question4") String answer4,
			@RequestParam(required = false, value = "Question5") String answer5) {
		TestDetails details = new TestDetails();

		LocalDateTime dateAndTime = LocalDateTime.now();
		DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

		String date = dateAndTime.format(myFormat);
		details.setAssessment("Hibernate-L1");
		details.setFormattedDate(date);
		details.setTotalMarks(50);
		details.setEmail(emailLoggedIn);

		int total = 0;
		try {
			if (answer1.contentEquals("Object Relational Mapping"))
				total += 10;
		} catch (Exception e) {
		}
		try {
			if (answer2.contentEquals("uni-directional & bi-directional"))
				total += 10;
		} catch (Exception e) {
		}
		try {
			if (answer3.contentEquals("configuration file"))
				total += 10;
		} catch (Exception e) {
		}
		try {
			if (answer4.contentEquals("Hibernate Query Language"))
				total += 10;
		} catch (Exception e) {
		}
		try {
			if (answer5.contentEquals("isolation levels"))
				total += 10;
		} catch (Exception e) {
		}

		details.setTestMarks(total);
		if (total >= 30) {
			details.setResult("Passed");
			addDetails.add(details);
			return "successPage.html";
		}

		else {
			details.setResult("Failed");
			addDetails.add(details);
			return "failurePage.html";
		}

	}

	@RequestMapping("/users/all")
	public String showUserDetails(Model model) {
		List<User> allUsers = service.findAll();
		Collections.sort(allUsers);
		model.addAttribute("users", allUsers);
		return "allUserDetails.html";
	}

	@RequestMapping("/tests/all")
	public String showTestDetails(Model model) {
		List<TestDetails> allDetails = addDetails.findAll();
		Collections.sort(allDetails);
		model.addAttribute("allDetails", allDetails);

		return "allTestsDetails.html";
	}

	@RequestMapping("/springAssessment.html")
	public String showSpring() {
	
		return "springAssessment.html";
	}

	@RequestMapping("/hibernateAssessment.html")
	public String showHibernate() {
	
		
		return "hibernateAssessment.html";
	}
}
