package org.firstinspires.ftc.teamcode.RobotTank;

public class MathUtilBlitz {

    public static boolean isNear(double expected, double actual, double tolerance) {
        if (tolerance < 0) {
            throw new IllegalArgumentException("Tolerance must be a non-negative number!");
        }
        return Math.abs(expected - actual) < tolerance;
    }

}
