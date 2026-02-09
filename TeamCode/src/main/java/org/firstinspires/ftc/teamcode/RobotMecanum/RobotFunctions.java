package org.firstinspires.ftc.teamcode.RobotMecanum;

public class RobotFunctions{
    private final RobotMecanum robot;
    public RobotFunctions(RobotMecanum robotMecanum){
        this.robot = robotMecanum;
    }

    public void moveWithForDiagonalsCm(double topLeft, double topRight) {
        double normalFactor = Math.max(Math.abs(topLeft),Math.abs(topRight));
        double topLeftPower = topLeft/normalFactor;
        double topRightPower = topRight/normalFactor;
        double timeToMove = normalFactor*
    }
}