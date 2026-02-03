package org.firstinspires.ftc.teamcode.RobotMecanum.OpMode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.RobotMecanum.RobotConstants;
import org.firstinspires.ftc.teamcode.RobotMecanum.RobotMecanum;

@Autonomous(name = "close auto mecanum")
public class AutonomousCloseMecanum extends LinearOpMode {
    private RobotMecanum robot;
    private static int moveTimeToShootPositionMS=500;
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
        robot.getMecanum().drive(0,1,0);
        sleep(moveTimeToShootPositionMS);
        robot.getMecanum().stop();
        robot.getFlywheel().shoot();
        sleep(RobotConstants.wheelAccelerationTimeMS);
        shootThreeArtifacts();
        robot.getFlywheel().stop();
    }
}
