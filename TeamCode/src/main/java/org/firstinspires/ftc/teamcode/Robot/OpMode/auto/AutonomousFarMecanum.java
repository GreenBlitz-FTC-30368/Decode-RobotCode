package org.firstinspires.ftc.teamcode.Robot.OpMode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Robot.RobotConstants;
import org.firstinspires.ftc.teamcode.Robot.RobotMecanum;

@Autonomous(name = "far auto mecanum")
public class AutonomousFarMecanum extends LinearOpMode {
    private RobotMecanum robot;
    private final long timeToPositionBeforeTurn = 1500;

    @Override
    public void runOpMode() {
        waitForStart();
        robot = new RobotMecanum(hardwareMap);
        robot.getMecanum().drive(0, -1, 0);
        sleep(timeToPositionBeforeTurn);
    }
}
