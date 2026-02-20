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
        robotFunctions = new RobotFunctions(robot,telemetry);
        robotFunctions.moveWithXYTiles(0.5*getAllianceColor().autonomousFarShootsModifier,-3.5);
        robotFunctions.rotateToAngle(45*getAllianceColor().autonomousFarShootsModifier);
    }


}
