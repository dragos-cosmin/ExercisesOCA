package org.example.streams.employeesExamples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dragos.cosmin
 **/
public class Collect {
    public static void main(String[] args) {
        List<Employee> eList=Employee.createShortList();

        List<Employee> nList=new ArrayList<>();

        //Collect CO Managers

        nList=eList.stream()
                .filter(e->e.getRole().equals(Role.MANAGER))
                .filter(e->e.getState().equals("CO"))
                .sorted(Comparator.comparing(Employee::getSurName))
                .collect(Collectors.toList());
        System.out.println("\n== CO Bonus Details ==");
        nList.stream()
                .forEach(Employee::printSummary);

    }
}
