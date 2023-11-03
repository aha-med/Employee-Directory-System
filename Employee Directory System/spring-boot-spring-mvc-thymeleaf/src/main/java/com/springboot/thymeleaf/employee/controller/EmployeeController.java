package com.springboot.thymeleaf.employee.controller;

import com.springboot.thymeleaf.employee.entity.Employee;
import com.springboot.thymeleaf.employee.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    EmployeeService employeeService;
    EmployeeController(EmployeeService employeeService1){
        employeeService=employeeService1;
    }

    @GetMapping("/list")
    public String listEmployee(Model model){
        List<Employee> employeeList=employeeService.findAll();
        model.addAttribute("employees",employeeList);
        return "list-employees";
    }
    @GetMapping("/addEmployee")
    public String showForm(Model model){
        Employee employee=new Employee();
        model.addAttribute("employees",employee);
        return "showForm";
    }
   @PostMapping("/save")
    public String saveData(@ModelAttribute("employees") Employee theEmployee){
        employeeService.save(theEmployee);
        return "redirect:/employee/list";
   }
   @GetMapping("/updateEmployee")
    public String updateForm(@RequestParam("employeeId") int id ,Model model){
      Employee employee= employeeService.findById(id);
      model.addAttribute("employees",employee);
      return "showForm";
   }
   @GetMapping("deleteEmployee")
    public String deleteEmployee(@RequestParam("employeeId") int id){
        employeeService.deleteById(id);
        return "redirect:/employee/list";
   }

}
