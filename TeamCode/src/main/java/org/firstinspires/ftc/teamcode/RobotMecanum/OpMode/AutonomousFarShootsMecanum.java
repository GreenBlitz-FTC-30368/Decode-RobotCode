package org.firstinspires.ftc.teamcode.RobotMecanum.OpMode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "far auto shoots mecanum")
public class AutonomousFarShootsMecanum extends LinearOpMode {
    private RobotMecanum robot;
    private final long timeToPositionBeforeTurn = 1500;

    @Override
    public void runOpMode() {
        waitForStart();
        robot = new RobotMecanum(hardwareMap);
        robot.getMecanum().drive(0, -1, 0);
        sleep(timeToPositionBeforeTurn);
        robot.getMecanum().drive(0,0,1);
    }
}
