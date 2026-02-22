package org.firstinspires.ftc.teamcode.RobotMecanum.OpMode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.RobotMecanum.RobotConstants;
import org.firstinspires.ftc.teamcode.RobotMecanum.RobotFunctions;
import org.firstinspires.ftc.teamcode.RobotMecanum.RobotMecanum;

//@Autonomous(name = "far auto shoots mecanum 68")
public abstract class AutonomousFarShootsMecanum extends LinearOpMode {

    abstract RobotConstants.AllianceColor getAllianceColor();
    private RobotMecanum robot;
    private RobotFunctions robotFunctions;
    @Override
    public void runOpMode() {
        waitForStart();
        robot = new RobotMecanum(hardwareMap);
        robotFunctions = new RobotFunctions(robot);
        //robotFunctions.moveWithXYTiles(0.5*getAllianceColor().autonomousFarShootsModifier,-3.5);
        //robotFunctions.rotateToAngle(robot.getYaw()+45, 10, telemetry);

        /*
        double xMovement = -1.5*RobotConstants.tileSizeCm+RobotConstants.distanceToShootCm/Math.sqrt(2);
        double yMovement = -4.5*RobotConstants.tileSizeCm+RobotConstants.distanceToShootCm/Math.sqrt(2);
        robotFunctions.moveWithXYTiles(xMovement*getAllianceColor().autonomousFarShootsModifier,yMovement);
        robotFunctions.rotate(45);

        robot.getFlywheel().shoot();
        sleep(RobotConstants.wheelAccelerationTimeMS);
        shootThreeArtifacts();
        robot.getFlywheel().stop();
         */

        robot.getMecanum().driveWithDiagonalVelocities(1,0);
        sleep(1000);
        robot.getMecanum().stop();
    }
    private void shootThreeArtifacts() {
        for (int i = 0; i < 3; i++) {
            robot.getRail().go();
            sleep(RobotConstants.timeToShootAnArtifactMS);
            robot.getRail().stop();
            sleep(RobotConstants.timeBetweenArtifactShootings);
        }
    }


}
