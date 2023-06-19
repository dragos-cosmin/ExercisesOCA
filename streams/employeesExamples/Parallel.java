package org.example.streams.employeesExamples;

import java.util.List;

/**
 * @author dragos.cosmin
 **/
public class Parallel {
    public static void main(String[] args) {
        List<Employee> eList=Employee.createShortList();

        double result=eList.parallelStream()
                .filter(e->e.getState().equals("CO"))
                .filter(e->e.getRole().equals(Role.MANAGER))
                .peek(Employee::printSummary)
                .mapToDouble(Employee::getSalary)
                .sum();
        System.out.printf("Total CO Manager Pay: $%,9.2f %n",result);

        System.out.println("\n");

        // Call parallel from pipeline
        result=eList.stream()
                .filter(e->e.getState().equals("CO"))
                .filter(e->e.getRole().equals(Role.MANAGER))
                .peek(e->e.printSummary())
                .mapToDouble(e->e.getSalary())
                .parallel()
                .sum();

        System.out.printf("Total CO Manager Pay: $%,9.2f %n",result);

    }
}
