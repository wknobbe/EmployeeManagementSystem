package com.business.ems.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.business.ems.models.Employee;
import com.business.ems.services.EmployeeService;

@Controller
public class EmployeeController {
	private final EmployeeService employeeService;
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		Iterable<Employee> employees = employeeService.allEmployees();
		model.addAttribute("employees", employees);
		return "/dashboard.jsp";
	}
	@RequestMapping("/employee/new")
	public String newEmployee(@ModelAttribute("employee") Employee employee) {
		return "/newemployee.jsp";
	}
	@RequestMapping(value="/employee/create", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("employee") Employee employee, BindingResult result) {
		if (result.hasErrors()) {
			return "/newemployee.jsp";
		} else {
			employeeService.createEmployee(employee);
			return "redirect:/dashboard";
		}
	}
}
