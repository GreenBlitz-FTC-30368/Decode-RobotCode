package org.firstinspires.ftc.teamcode.RobotMecanum;

import org.firstinspires.ftc.teamcode.RobotTank.RobotConstants;

public class RobotFunctions{
    private final RobotMecanum robot;
    public RobotFunctions(RobotMecanum robotMecanum){
        this.robot = robotMecanum;
    }

    public void moveWithDiagonalsCm(double topLeft, double topRight){
        double normalFactor = Math.max(Math.abs(topLeft),Math.abs(topRight));
        double topLeftPower = topLeft/normalFactor;
        double topRightPower = topRight/normalFactor;
        double movementDuration = normalFactor/RobotConstants.mecanumDiagonalVelocityCmPerMinute;
        robot.getMecanum().driveWithDiagonalVelocities(topLeftPower,topRightPower);
        try {
            Thread.sleep((int) (movementDuration * 6000));
        } catch (InterruptedException e) {}
        robot.getMecanum().stop();
    }

    public void moveWithXYCm(double x, double y){
        moveWithDiagonalsCm((-y-x)*Math.sqrt(2)/2,(-y+x)*Math.sqrt(2)/2);
    }

    public void moveWithXYTiles(double x, double y){
        moveWithXYCm(x*RobotConstants.tileSizeCm,y*RobotConstants.tileSizeCm);
    }
}