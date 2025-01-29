/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package net.fva.employee_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.fva.employee_backend.entity.Employee;

/**
 *
 * @author Fernando
 */
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
    
}
