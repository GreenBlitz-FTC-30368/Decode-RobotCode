package org.firstinspires.ftc.teamcode.Robot.OpMode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Robot.Robot;
import org.firstinspires.ftc.teamcode.Robot.RobotConstants;

@Autonomous(name = "close auto67")
public class AutonomousClose extends LinearOpMode {
    private Robot robot;
    public static int timeMovingBackMS=500;

    @Override
    public void runOpMode() {
        waitForStart();
        robot = new Robot(hardwareMap);
        robot.getTank().moveWithStickXY(0,1);
        sleep((long) (RobotConstants.distanceToShootCm/RobotConstants.tankMaxVelocityCmPerMinute *60000));
        robot.getTank().stop();

        robot.getFlywheel().shoot();
        sleep(RobotConstants.wheelAccelerationTimeMS);
        for (int i=0; i<3; i++) {
            robot.getRail().go();
            sleep(RobotConstants.timeToShootAnArtifactMS);
            robot.getRail().stop();
            sleep(RobotConstants.timeBetweenArtifactShootings);
        }
        robot.getFlywheel().stop();
        robot.getTank().moveWithStickXY(0,-1);
        sleep(timeMovingBackMS);
        robot.getTank().stop();
        /*
        robot.getTank().moveWithStickXY(0,1);
        sleep(closeAutoMoveForMS);
         */
    }

}
