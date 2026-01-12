package org.firstinspires.ftc.teamcode.Robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class Flywheel {
    private DcMotor flywheel;

    public Flywheel(DcMotor flywheel) {
        flywheel.setDirection(DcMotorSimple.Direction.FORWARD);
        this.flywheel = flywheel;

    }

    public void shoot() {
        flywheel.setPower(0.68);
    }

    public void preShoot(){
        flywheel.setPower(0.5);
    }

    public void stop() {

        flywheel.setPower(0);
    }
}