package org.firstinspires.ftc.teamcode.Robot.OpMode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Robot.Robot;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.Flywheel;

@Autonomous(name="close67")
public class AutonomousClose extends LinearOpMode {
    private static final int timeToShoot3ArtifactsMS = 1000;
    private Robot robot = new Robot(hardwareMap);
    @Override
    public void runOpMode(){
        robot.getFlywheel().shoot();
        sleep(Flywheel.wheelAccelerationTimeMS);
        robot.getRail().go();
        sleep(timeToShoot3ArtifactsMS);
        robot.getRail().stop();
        robot.getFlywheel().stop();

    }
}
