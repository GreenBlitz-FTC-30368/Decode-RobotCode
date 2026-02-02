package org.firstinspires.ftc.teamcode.Robot.OpMode.auto;

import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Robot.RobotConstants;
import org.firstinspires.ftc.teamcode.Robot.RobotMecanum;

@Autonomous(name = "close auto mecanum")
public class AutonomousCloseMecanum extends LinearOpMode {
    private RobotMecanum robot;
    private final PoseVelocity2d forwardVelocity = new PoseVelocity2d(new Vector2d(1, 0), 0);
    private final long moveTimeToShootPositionMS = (long) (RobotConstants.distanceToShootCm / RobotConstants.tankMaxVelocityCmPerMinute * 60000);

    private void shootThreeArtifacts() {
        for (int i = 0; i < 3; i++) {
            robot.getRail().go();
            sleep(RobotConstants.timeToShootAnArtifactMS);
            robot.getRail().stop();
            sleep(RobotConstants.timeBetweenArtifactShootings);
        }
    }

    @Override
    public void runOpMode() {
        waitForStart();
        robot = new RobotMecanum(hardwareMap);
        robot.getMecanum().setDrivePowers(forwardVelocity);
        sleep(moveTimeToShootPositionMS);
        robot.getMecanum().stop();
        robot.getFlywheel().shoot();
        sleep(RobotConstants.wheelAccelerationTimeMS);
        shootThreeArtifacts();
        robot.getFlywheel().stop();
    }
}
