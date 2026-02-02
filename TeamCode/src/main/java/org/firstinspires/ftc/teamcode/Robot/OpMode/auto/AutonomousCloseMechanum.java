package org.firstinspires.ftc.teamcode.Robot.OpMode.auto;

import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Robot.RobotConstants;
import org.firstinspires.ftc.teamcode.Robot.RobotMecha;

@Autonomous(name = "close auto mecha")
public class AutonomousCloseMechanum extends LinearOpMode {
    private RobotMecha robot;
    private final PoseVelocity2d forwardVelocity = new PoseVelocity2d(new Vector2d(1, 0), 0);
    private final PoseVelocity2d reverseVelocity = new PoseVelocity2d(new Vector2d(-1, 0), 0);
    public static int timeMovingBackMS = 500;

    @Override
    public void runOpMode() {
        waitForStart();
        robot = new RobotMecha(hardwareMap);
        robot.getMechanum().setDrivePowers(forwardVelocity);
        sleep((long) (RobotConstants.distanceToShootCm / RobotConstants.tankMaxVelocityCmPerMinute * 60000));
        robot.getMechanum().stop();

        robot.getFlywheel().shoot();
        sleep(RobotConstants.wheelAccelerationTimeMS);
        for (int i = 0; i < 3; i++) {
            robot.getRail().go();
            sleep(RobotConstants.timeToShootAnArtifactMS);
            robot.getRail().stop();
            sleep(RobotConstants.timeBetweenArtifactShootings);
        }
        robot.getFlywheel().stop();
        robot.getMechanum().setDrivePowers(reverseVelocity);
        sleep(timeMovingBackMS);
        robot.getMechanum().stop();
    }
}
