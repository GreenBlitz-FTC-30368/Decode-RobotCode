package org.firstinspires.ftc.teamcode.RobotMecanum;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.RobotMecanum.Subsystems.Flywheel;
import org.firstinspires.ftc.teamcode.RobotMecanum.Subsystems.Mecanum;
import org.firstinspires.ftc.teamcode.RobotMecanum.Subsystems.Rail;

public class RobotMecanum {
    private final Rail rail;
    private final Flywheel flywheel;
    private final Mecanum mecanum;
    private final IMU imu;

    public RobotMecanum(HardwareMap hardwareMap) {
        this.rail = new Rail(
                hardwareMap.crservo.get("rightRail"),
                hardwareMap.crservo.get("leftRail")
        );
        this.flywheel = new Flywheel(
                hardwareMap.dcMotor.get("flywheelMotor")
        );
        this.mecanum = new Mecanum(hardwareMap); //TODO: name calibration
        this.imu = hardwareMap.get(IMU.class,"imu");
        imu.initialize(new IMU.Parameters(
                new RevHubOrientationOnRobot(
                        RevHubOrientationOnRobot.LogoFacingDirection.LEFT, RevHubOrientationOnRobot.UsbFacingDirection.FORWARD
                )
        ));
        imu.resetYaw();
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
    public IMU getImu(){
        return imu;
    }
    public double getYaw(){
        return imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES);
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
