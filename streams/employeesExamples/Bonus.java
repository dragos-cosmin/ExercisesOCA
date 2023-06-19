package org.example.streams.employeesExamples;

/**
 * @author dragos.cosmin
 **/
public enum Bonus {
    STAFF(0.02),
    MANAGER(0.04),
    EXECUTIVE(0.06);

    private final double percent;


    Bonus(double percent) {
        this.percent = percent;
    }

    public static double byRole(Role r){

        return switch (r) {
            case STAFF -> STAFF.percent;
            case EXECUTIVE -> EXECUTIVE.percent;
            case MANAGER -> MANAGER.percent;
        };
    }
}
