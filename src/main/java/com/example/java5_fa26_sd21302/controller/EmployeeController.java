package com.example.java5_fa26_sd21302.controller;

import com.example.java5_fa26_sd21302.entity.Employee;
import com.example.java5_fa26_sd21302.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    // 1. Hiển thị danh sách lấy tất cả nhân viên
    @GetMapping("/employees")
    public String listEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "views/employees";
    }

    // 2. Hiển thị form thêm nhân viên mới
    @GetMapping("/employees/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "views/new_employee";
    }

    // 3. Lưu nhận viên mới
    @PostMapping("/employees/saveEmployee")
    public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "views/new_employee";
        }
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    // 4. Hiển thị form cập nhật thông tin nhân viên (theo id)
    @GetMapping("/employees/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable("id") Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee == null) {
            return "redirect:/employees";
        }
        model.addAttribute("employee", employee);
        return "views/update_employee";
    }

    // 5. Cập nhật dữ liệu thông tin nhân viên mới
    @PostMapping("/employees/updateEmployee")
    public String updateEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "views/update_employee";
        }
        employeeService.updateEmployee(employee);
        return "redirect:/employees";
    }

    // 6. Xóa dữ liệu thông tin nhân viên
    @GetMapping("/employees/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }

    // Đây là test cmt
}
