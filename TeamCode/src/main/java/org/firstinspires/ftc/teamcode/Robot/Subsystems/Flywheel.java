package org.firstinspires.ftc.teamcode.Robot.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class Flywheel {
    public static final int wheelAccelerationTimeMS = 1000;
    private final DcMotor flywheel;

    public Flywheel(DcMotor flywheel) {
        flywheel.setDirection(DcMotorSimple.Direction.FORWARD);
        this.flywheel = flywheel;
    }

    public void shoot() {
        flywheel.setPower(0.68);
    }

    public void stop() {
        flywheel.setPower(0);
    }

}
