package org.firstinspires.ftc.teamcode.Robot.Subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class Rail {
    private final CRServo servoRight;
    private final CRServo servoLeft;

    public Rail(CRServo servoRight, CRServo servoLeft) {
        this.servoLeft = servoLeft;
        this.servoRight = servoRight;
    }

    public void stop() {
        servoRight.setPower(0);
        servoLeft.setPower(0);
    }

    public void go() {
        servoRight.setDirection(DcMotorSimple.Direction.FORWARD);
        servoLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        servoLeft.setPower(0.6);
        servoRight.setPower(0.6);
    }
}
