package org.firstinspires.ftc.teamcode.RobotMecanum.OpMode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.RobotMecanum.RobotConstants;
import org.firstinspires.ftc.teamcode.RobotMecanum.RobotFunctions;
import org.firstinspires.ftc.teamcode.RobotMecanum.RobotMecanum;

//@Autonomous(name = "far auto shoots mecanum")
public abstract class AutonomousFarShootsMecanum extends LinearOpMode {

    abstract int getModifier();
    private RobotMecanum robot;
    private RobotFunctions robotFunctions;
    private static final int SHOOT_AT_A_TIME = 3;

    private static final double tilesToMoveVertically = -4.5;
    private static final double tilesToMoveHorizontally = -1.5;
    @Override
    public void runOpMode() {
        waitForStart();
        robot = new RobotMecanum(hardwareMap);
        robotFunctions = new RobotFunctions(robot);
        double xMovement = tilesToMoveHorizontally*RobotConstants.tileSizeCm+RobotConstants.distanceToShootCm/Math.sqrt(2);
        double yMovement = tilesToMoveVertically*RobotConstants.tileSizeCm+RobotConstants.distanceToShootCm/Math.sqrt(2);
        double startingYaw = robot.getYaw();
        robotFunctions.moveWithXYCm(xMovement*getModifier(),yMovement);
        robotFunctions.rotateToAngle(startingYaw+45*getModifier());

        robot.getFlywheel().shoot();
        sleep(RobotConstants.wheelAccelerationTimeMS);
        shootArtifacts(SHOOT_AT_A_TIME);
        robot.getFlywheel().stop();
    }
    private void shootArtifacts(int n) {
        for (int i = 0; i < n; i++) {
            robot.getRail().go();
            sleep(RobotConstants.timeToShootAnArtifactMS);
            robot.getRail().stop();
            sleep(RobotConstants.timeBetweenArtifactShootings);
        }
    }


}
