package org.firstinspires.ftc.teamcode.Robot;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class Robot {
    private final Rail rail;
    private final Flywheel flywheel;

    public Robot(HardwareMap hardwareMap) {
        rail = new Rail(
                hardwareMap.crservo.get("railLeft"),
                hardwareMap.crservo.get("railRight")
        );
        flywheel = new Flywheel(
                hardwareMap.dcMotor.get("flywheelMotor")
        );
    }

    public Rail getRail() {
        return rail;
    }

    public Flywheel getFlywheel() {
        return flywheel;
    }
}
