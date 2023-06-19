package org.example.streams.employeesExamples;

import java.util.List;

/**
 * @author dragos.cosmin
 **/
public class MapTest {
    public static void main(String[] args) {
        List<Employee> eList=Employee.createShortList();

        System.out.println("\n== CO Manager Bonuses ==");
        eList.stream()
                .filter(e->e.getRole().equals(Role.MANAGER))
                .filter(e->e.getState().equals("CO"))
                .map(e->e.getSalary()*Bonus.byRole(e.getRole()))
                .forEach(s-> System.out.printf("Bonus paid:     $%,6.2f %n",s));

        System.out.println("\n== Eng Manager Bonus ==");
        eList.stream()
                .filter(e->e.getRole().equals(Role.MANAGER))
                .filter(e->e.getDept().equals("Eng"))
                .map(e->e.getSalary()*Bonus.byRole(e.getRole()))
                .forEach(s-> System.out.printf("Bonus paid:     $%,6.2f %n",s));
    }
}
