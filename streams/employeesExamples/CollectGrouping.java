package org.example.streams.employeesExamples;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author dragos.cosmin
 **/
public class CollectGrouping {
    public static void main(String[] args) {
        List<Employee> eList=Employee.createShortList();

        Map<Boolean,List<Employee>>gMap=new HashMap<>();

        gMap=eList.stream()
                .collect(
                        Collectors.partitioningBy(
                                e->e.getRole().equals(Role.MANAGER)
                        )
                );
        System.out.println("\n== Employees by Dept ==");
        gMap.forEach((k,v)->{
            System.out.println("\nGroup: "+k);
            v.forEach(Employee::printSummary);
        });

    }
}
