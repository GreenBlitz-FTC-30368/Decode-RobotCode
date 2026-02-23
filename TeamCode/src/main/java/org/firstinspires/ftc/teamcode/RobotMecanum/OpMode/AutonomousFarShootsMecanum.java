package org.firstinspires.ftc.teamcode.RobotMecanum.OpMode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.RobotMecanum.RobotConstants;
import org.firstinspires.ftc.teamcode.RobotMecanum.RobotFunctions;
import org.firstinspires.ftc.teamcode.RobotMecanum.RobotMecanum;

//@Autonomous(name = "far auto shoots mecanum 68")
public abstract class AutonomousFarShootsMecanum extends LinearOpMode {

    abstract int getmodifier();
    private RobotMecanum robot;
    private RobotFunctions robotFunctions;
    @Override
    public void runOpMode() {
        waitForStart();
        robot = new RobotMecanum(hardwareMap);
        robotFunctions = new RobotFunctions(robot);

        double xMovement = -1.5*RobotConstants.tileSizeCm+RobotConstants.distanceToShootCm/Math.sqrt(2);
        double yMovement = -4.5*RobotConstants.tileSizeCm+RobotConstants.distanceToShootCm/Math.sqrt(2);
        double startingYaw = robot.getYaw();
        robotFunctions.moveWithXYCm(xMovement*getmodifier(),yMovement,true);
        robotFunctions.rotateToAngle(startingYaw+45*getmodifier());

        robot.getFlywheel().shoot();
        sleep(RobotConstants.wheelAccelerationTimeMS);
        shootArtifacts(3);
        robot.getFlywheel().stop();/**/


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
