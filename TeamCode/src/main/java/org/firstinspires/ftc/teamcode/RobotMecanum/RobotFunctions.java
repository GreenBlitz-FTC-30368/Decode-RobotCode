package org.firstinspires.ftc.teamcode.RobotMecanum;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.MathUtilBlitz;
import org.firstinspires.ftc.teamcode.RobotTank.RobotConstants;

public class RobotFunctions{
    private final RobotMecanum robot;

    private Telemetry telemetry;
    private final double rotationPidPowerTo360DegRatio = 1;
    public RobotFunctions(RobotMecanum robotMecanum, Telemetry telemetry){
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

    public void rotateToAngle(double angle,double tolerance){
        double currentAngle = robot.getYaw();
        double delta = MathUtilBlitz.angleDifference(currentAngle,angle);
        while (Math.abs(delta)>tolerance){
            robot.getMecanum().drive(0,0,delta*rotationPidPowerTo360DegRatio/360);
            currentAngle = robot.getYaw();
            telemetry.addData("Yaw: ", currentAngle);
            telemetry.update();
            delta = MathUtilBlitz.angleDifference(currentAngle,angle);
        }
    }

    public void rotateToAngle(double angle){
        rotateToAngle(angle,1000); //Need to lower
    }

//    public void rotate(double degrees,double tolerance){
//        rotateToAngle(robot.getYaw()+degrees,tolerance);
//    }
//
//    public void rotate(double degrees){
//        rotateToAngle(robot.getYaw()+degrees);
//    }
}