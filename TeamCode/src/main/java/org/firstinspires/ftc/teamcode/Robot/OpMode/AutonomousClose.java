package org.firstinspires.ftc.teamcode.Robot.OpMode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Robot.Robot;
import org.firstinspires.ftc.teamcode.Robot.RobotConstants;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.Flywheel;

@Autonomous(name = "close auto67")
public class AutonomousClose extends LinearOpMode {
    private Robot robot = new Robot(hardwareMap);

    @Override
    public void runOpMode() {
        robot.getFlywheel().shoot();
        sleep(RobotConstants.wheelAccelerationTimeMS);
        robot.getRail().go();
        sleep(RobotConstants.timeToShoot3ArtifactsMS);
        robot.getRail().stop();
        robot.getFlywheel().stop();
    }

}
