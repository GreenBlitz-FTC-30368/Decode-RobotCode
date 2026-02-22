package org.firstinspires.ftc.teamcode.RobotMecanum.OpMode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.RobotMecanum.RobotConstants;
@Autonomous(name="mecanum auto far blue",group="far auto shoots")
public class AutonomousFarBlue extends AutonomousFarShootsMecanum{
    @Override
    RobotConstants.AllianceColor getAllianceColor() {
        return RobotConstants.AllianceColor.BLUE;
    }
}
