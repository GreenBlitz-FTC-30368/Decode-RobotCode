package org.firstinspires.ftc.teamcode.Robot.OpMode.auto;

import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Robot.RobotConstants;
import org.firstinspires.ftc.teamcode.Robot.RobotMecha;

@Autonomous(name = "close auto meca")
public class AutonomousCloseMecanum extends LinearOpMode {
    private RobotMecha robot;
    private final PoseVelocity2d forwardVelocity = new PoseVelocity2d(new Vector2d(1, 0), 0);

    @Override
    public void runOpMode() {
        waitForStart();
        robot = new RobotMecha(hardwareMap);
        robot.getMecanum().setDrivePowers(forwardVelocity);
        sleep((long) (RobotConstants.distanceToShootCm / RobotConstants.tankMaxVelocityCmPerMinute * 60000));
        robot.getMecanum().stop();

        robot.getFlywheel().shoot();
        sleep(RobotConstants.wheelAccelerationTimeMS);
        for (int i = 0; i < 3; i++) {
            robot.getRail().go();
            sleep(RobotConstants.timeToShootAnArtifactMS);
            robot.getRail().stop();
            sleep(RobotConstants.timeBetweenArtifactShootings);
        }
        robot.getFlywheel().stop();
    }
}
