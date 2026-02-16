package org.firstinspires.ftc.teamcode.RobotMecanum.OpMode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.RobotMecanum.RobotConstants;
@Autonomous(name="mecanum auto far red",group="far auto shoots")
public class AutonomousFarRed extends AutonomousFarShootsMecanum{
    @Override
    RobotConstants.AllianceColor getAllianceColor() {
        return RobotConstants.AllianceColor.RED;
    }
}
