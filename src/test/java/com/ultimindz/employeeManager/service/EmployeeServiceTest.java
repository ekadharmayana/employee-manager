package com.ultimindz.employeeManager.service;

import com.ultimindz.employeeManager.dto.EmployeeDTO;
import com.ultimindz.employeeManager.entity.Employee;
import com.ultimindz.employeeManager.exception.NotFoundException;
import com.ultimindz.employeeManager.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    void createEmployee_ShouldReturnSavedEmployee(){
        EmployeeDTO inputDto = new EmployeeDTO();
        inputDto.setFirstName("Hans");
        inputDto.setLastName("Test");
        inputDto.setEmail("hans@test.com");

        Employee savedEmployee = new Employee("Hans", "Test", "hans@test.com", 0.0);
        savedEmployee.setId(1L);

        when(employeeRepository.save(any(Employee.class))).thenReturn(savedEmployee);

        EmployeeDTO result = employeeService.createEmployee(inputDto);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Hans", result.getFirstName());

        verify(employeeRepository, times(1)).save(any(Employee.class));
    }

    @Test
    void getEmployeeById_ShouldReturnEmployee_WhenExists() {
        Long employeeId = 1L;
        Employee mockEmployee = new Employee("Anna", "Muster", "anna@test.com", 50000.0);
        mockEmployee.setId(employeeId);

        when(employeeRepository.findById(employeeId)).thenReturn(java.util.Optional.of(mockEmployee));

        EmployeeDTO result = employeeService.getEmployeeById(employeeId);

        assertNotNull(result);
        assertEquals("Anna", result.getFirstName());
        assertEquals("anna@test.com", result.getEmail());
    }

    @Test
    void getEmployeeById_ShouldThrowException_WhenDoesNotExist() {
        Long employeeId = 99L;

        when(employeeRepository.findById(employeeId)).thenReturn(java.util.Optional.empty());

        assertThrows(NotFoundException.class, () -> {
            employeeService.getEmployeeById(employeeId);
        });

        verify(employeeRepository, times(1)).findById(employeeId);
    }
}
