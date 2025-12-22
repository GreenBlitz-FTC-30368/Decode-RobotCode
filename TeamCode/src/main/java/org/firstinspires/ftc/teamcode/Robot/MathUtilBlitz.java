package org.firstinspires.ftc.teamcode.Robot;

public class MathUtilBlitz {

    public static boolean isNear(double expected, double actual, double tolerance) {
        if (tolerance < 0) {
            throw new IllegalArgumentException("Tolerance must be a non-negative number!");
        }
        return Math.abs(expected - actual) < tolerance;
    }

    public static double radianToDegree(double radian){
        return radian*180/Math.PI;
    }
}
