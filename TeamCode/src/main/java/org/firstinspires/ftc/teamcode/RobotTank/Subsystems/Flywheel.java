package org.firstinspires.ftc.teamcode.RobotTank.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class Flywheel {
    private final DcMotor flywheel;

    public Flywheel(DcMotor flywheel) {
        flywheel.setDirection(DcMotorSimple.Direction.FORWARD);
        this.flywheel = flywheel;
    }

    public void shoot() {
        flywheel.setPower(0.6);
    }

    public void stop() {
        flywheel.setPower(0);
    }

}
