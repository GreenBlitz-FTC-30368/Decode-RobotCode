package org.firstinspires.ftc.teamcode.RobotMecanum.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name="MecanumFarBlue",group="Auto Far Shoots")
public class AutonomousFarBlue extends AutonomousFarShootsMecanum{
    @Override
    int getModifier(){
        return 1;
    }
}
