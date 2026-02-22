package org.firstinspires.ftc.teamcode;

public class MathUtilBlitz {

    public static boolean isNear(double expected, double actual, double tolerance) {
        if (tolerance < 0) {
            throw new IllegalArgumentException("Tolerance must be a non-negative number!");
        }
        return Math.abs(expected - actual) < tolerance;
    }
    public static double angleDifference(double angle2, double angle1){
        if (angle1<=0&&angle2>=0) {
            return -360+Math.abs(angle1)+angle2;
        } else if (angle1 >= 0&&angle2>=0) {
            return Math.max(angle1, angle2)-Math.min(angle1,angle2);
        } else if (angle1 >= 0 && angle2 <= 0) {
            return 360-Math.abs(angle2)-angle1;
        } else {
            return (Math.max(Math.abs(angle1),Math.abs(angle2))-Math.min(Math.abs(angle1),Math.abs(angle2)));
        }
    }

}
