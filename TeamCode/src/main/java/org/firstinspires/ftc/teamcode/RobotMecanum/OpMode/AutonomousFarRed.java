package org.firstinspires.ftc.teamcode.RobotMecanum.OpMode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.RobotMecanum.RobotConstants;
@Autonomous(name="MecanumFarRed",group="Auto Far Shoots")
public class AutonomousFarRed extends AutonomousFarShootsMecanum{
    @Override
    int getModifier(){
        return -1;
    }
}
