package org.firstinspires.ftc.teamcode.Robot.OpMode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Robot.Robot;
@Autonomous(name="far67")
public class AutonomousFar extends LinearOpMode {
    private Robot robot = new Robot(hardwareMap);
    private static final int moveForMS=2000;
    @Override
    public void runOpMode(){
        robot.getTank().moveWithStickXY(0,1);
        sleep(moveForMS);
        robot.getTank().stop();
    }
}
