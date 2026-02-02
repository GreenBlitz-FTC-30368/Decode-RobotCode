package org.firstinspires.ftc.teamcode.Robot;

import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.MecanumDrive;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.Flywheel;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.Rail;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.Tank;

public class RobotMecha {
    private final Rail rail;
    private final Flywheel flywheel;
    private final MecanumDrive mechanum;

    public RobotMecha (HardwareMap hardwareMap) {
        this.rail = new Rail(
                //hardwareMap.crservo.get("rightRail"),
                hardwareMap.crservo.get("leftRail")
        );
        this.flywheel = new Flywheel(
                hardwareMap.dcMotor.get("flywheelMotor")
        );
        this.mechanum = new MecanumDrive(hardwareMap, new Pose2d(0,0,0));
    }
}