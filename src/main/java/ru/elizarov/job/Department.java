package ru.elizarov.job;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Department {
    private String name;
    private Employee manager;
    private final List<Employee> employees = new ArrayList<>();

    // назначение начальника
    public void setManager(Employee manager) {
        if (manager == null) {
            this.manager = null;
            return;
        }
        if (this.manager != null) {
            this.manager.setDepartment(null); // Снятие текущего начальника
        }
        this.manager = manager;
        manager.setDepartment(this);
        if (!employees.contains(manager)) {
            employees.add(manager); // Добавляем начальника в список сотрудников
        }
    }

    // добавление сотрудника
    public void addEmployee(Employee employee) {
        if (employee == null || employees.contains(employee)) {
            return;
        }
        employees.add(employee);
        employee.setDepartment(this);
    }

    // Удаление сотрудника
    public void removeEmployee(Employee employee) {
        if (employee == null) {
            return;
        }
        if (employee.equals(manager)) {
            setManager(null); // Снятие с должности начальника
        }
        employees.remove(employee);
        employee.setDepartment(null);
    }

    @Override
    public String toString() {
        return "Отдел \"" + name + "\", начальник: " + (manager != null ? manager.getName() : "не назначен");
    }
}