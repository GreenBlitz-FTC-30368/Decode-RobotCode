package org.firstinspires.ftc.teamcode.Robot;

import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.MecanumDrive;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.Flywheel;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.Mecanum;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.Rail;

public class RobotMecanum {
    private final Rail rail;
    private final Flywheel flywheel;
    private final Mecanum mecanum;

    public RobotMecanum(HardwareMap hardwareMap) {
        this.rail = new Rail(
                hardwareMap.crservo.get("rightRail"),
                hardwareMap.crservo.get("leftRail")
        );
        this.flywheel = new Flywheel(
                hardwareMap.dcMotor.get("flywheelMotor")
        );
        this.mecanum = new Mecanum(hardwareMap); //TODO: name calibration
    }

    public Rail getRail() {
        return rail;
    }

    public Flywheel getFlywheel() {
        return flywheel;
    }

    public Mecanum getMecanum() {
        return mecanum;
    }

//     .-. __ _ .-.
//     |  `  / \  |
//     /     '.()--\
//    |         '._/
//   _| O   _   O |_
//   =\    '-'    /=
//     '-._____.-'
//     /`/\___/\`\
//    /\/o     o\/\
//   (_|         |_)
//jgs  |____,____|
//     (____|____)

}
