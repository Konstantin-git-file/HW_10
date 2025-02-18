package ru.elizarov.job;

import lombok.Data;
import lombok.NoArgsConstructor;

/*
1.6.10 Начальник отдела. Измените сущности полученные в задаче 1.3.4. Необходимо гарантировать, что начальник отдела гарантированно работает в том же отделе, в котором он начальник.
Обратите внимание: задача должна быть решена таким образом, чтобы никогда не бросала никаких исключений.
 */
@Data
@NoArgsConstructor
public class Employee {
    private String name;
    private Department department;

    // доступ только внутри пакета
    void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        if (department == null) {
            return name + " (отдел не указан)";
        }
        if (this.equals(department.getManager())) {
            return name + " начальник отдела " + department.getName();
        } else {
            String managerName = (department.getManager() != null) ? department.getManager().getName() : "не указан";
            return name + " работает в отделе " + department.getName() + ", начальник которого " + managerName;
        }
    }
}