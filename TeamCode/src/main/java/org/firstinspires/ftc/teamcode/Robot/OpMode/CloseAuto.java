package org.firstinspires.ftc.teamcode.Robot.OpMode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Robot.Robot;

@Autonomous(name = "closeAuto", group = "Linear OpMode")
public class CloseAuto extends LinearOpMode {

    private Robot robot;

    @Override
    public void runOpMode() throws InterruptedException {
        robot = new Robot();
        waitForStart();
        robot.getFlywheel().shoot();
    }

}
