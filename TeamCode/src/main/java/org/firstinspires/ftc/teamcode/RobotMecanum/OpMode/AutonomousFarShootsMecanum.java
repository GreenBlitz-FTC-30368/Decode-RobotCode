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
        telemetry.setAutoClear(false);
        robotFunctions.setTelemetry(telemetry);
        telemetry.addData("YAWS",robot.getYaw());
        telemetry.update();
        //robotFunctions.moveWithXYTiles(0.5*getAllianceColor().autonomousFarShootsModifier,-3.5);
        //robotFunctions.rotateToAngle(robot.getYaw()+45, 10, telemetry);


        //robotFunctions.moveWithXYCm(0,-155,true);
        double xMovement = -1.5*RobotConstants.tileSizeCm+RobotConstants.distanceToShootCm/Math.sqrt(2);
        double yMovement = -4.5*RobotConstants.tileSizeCm+RobotConstants.distanceToShootCm/Math.sqrt(2);
        telemetry.setAutoClear(false);
        telemetry.addData("xMovement",xMovement);
        telemetry.addData("yMovement",yMovement);
        telemetry.update();
        telemetry.addData("YAWS2",robot.getYaw());
        telemetry.update();
        double startingYaw = robot.getYaw();
        robotFunctions.moveWithXYCm(xMovement*getAllianceColor().autonomousFarShootsModifier,yMovement,true);
        robotFunctions.rotateToAngle(startingYaw+45*getAllianceColor().autonomousFarShootsModifier);

        robot.getFlywheel().shoot();
        sleep(RobotConstants.wheelAccelerationTimeMS);
        shootThreeArtifacts();
        robot.getFlywheel().stop();/**/


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
