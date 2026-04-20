package org.firstinspires.ftc.teamcode.RobotMecanum.OpMode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.RobotMecanum.RobotConstants;
import org.firstinspires.ftc.teamcode.RobotMecanum.RobotFunctions;
import org.firstinspires.ftc.teamcode.RobotMecanum.RobotMecanum;

@Autonomous(name = "closeAutoMecanum")
public class AutonomousCloseMecanum extends LinearOpMode {
    private static final int SHOOT_AT_A_TIME = 3;
    private RobotMecanum robot;
    private RobotFunctions functions;
    private static final double moveAfterShootCm=50;
    private void shootArtifacts(int numOfArtifacts) {
        for (int i = 0; i < numOfArtifacts; i++) {
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
        functions = new RobotFunctions(robot);
        functions.moveWithXYCm(0,moveAfterShootCm);
        robot.getFlywheel().shoot();
        sleep(RobotConstants.wheelAccelerationTimeMS);
        shootArtifacts(SHOOT_AT_A_TIME);
        robot.getFlywheel().stop();
    }
}
