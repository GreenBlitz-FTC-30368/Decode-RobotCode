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

    public static int timeMovingBackMS=500;

    @Override
    public void runOpMode() {
        waitForStart();
        robot = new RobotMecha(hardwareMap);
        robot.getMechanum().setDrivePowers(new PoseVelocity2d(new Vector2d(1, 0), 0));
        sleep((long) (RobotConstants.distanceToShootCm/RobotConstants.tankMaxVelocityCmPerMinute *60000));
        robot.getMechanum().stop();

        robot.getFlywheel().shoot();
        sleep(RobotConstants.wheelAccelerationTimeMS);
        for (int i=0; i<3; i++) {
            robot.getRail().go();
            sleep(RobotConstants.timeToShootAnArtifactMS);
            robot.getRail().stop();
            sleep(RobotConstants.timeBetweenArtifactShootings);
        }
        robot.getFlywheel().stop();
        robot.getMechanum().setDrivePowers(new PoseVelocity2d(new Vector2d(-1,0), 0));
        sleep(timeMovingBackMS);
        robot.getMechanum().stop();
        /*s
        robot.getTank().moveWithStickXY(0,1);
        sleep(closeAutoMoveForMS);
         */
    }
}
