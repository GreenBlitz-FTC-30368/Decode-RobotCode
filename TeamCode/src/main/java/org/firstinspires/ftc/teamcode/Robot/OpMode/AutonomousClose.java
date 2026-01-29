package org.firstinspires.ftc.teamcode.Robot.OpMode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Robot.Robot;
import org.firstinspires.ftc.teamcode.Robot.RobotConstants;

@Autonomous(name = "close auto67")
public class AutonomousClose extends LinearOpMode {
    private Robot robot = new Robot(hardwareMap);

    @Override
    public void runOpMode() {
        robot.getTank().moveWithStickXY(0,-1);
        sleep((long) (RobotConstants.distanceToShootCm/RobotConstants.tankMaxVelocityCmPerMinute *600000));
        robot.getTank().stop();

        robot.getFlywheel().shoot();
        sleep(RobotConstants.wheelAccelerationTimeMS);
        robot.getRail().go();
        sleep(RobotConstants.timeToShoot3ArtifactsMS);
        robot.getRail().stop();
        robot.getFlywheel().stop();
        /*
        robot.getTank().moveWithStickXY(0,1);
        sleep(closeAutoMoveForMS);

         */
    }

}
