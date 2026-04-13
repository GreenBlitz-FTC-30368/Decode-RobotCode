package org.firstinspires.ftc.teamcode.RobotMecanum.Subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class Rail {
    private final CRServo servoRight;
    private final CRServo servoLeft;
    private static final double power = 0.767;
    private String mode;

    public Rail(CRServo servoRight, CRServo servoLeft) {
        this.servoLeft = servoLeft;
        this.servoRight = servoRight;
        servoRight.setDirection(DcMotorSimple.Direction.REVERSE);
        servoLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        mode = "none";
    }

    public void stop() {
        servoRight.setPower(0);
        servoLeft.setPower(0);
        mode = "stop";
    }

    public void rewind() {
        servoLeft.setPower(-1* power);
        servoRight.setPower(-1* power);
        mode = "reverse";
    }

    public void go() {
        servoLeft.setPower(power);
        servoRight.setPower(power);
        mode = "go";
    }

    public String getMode() {
        return mode;
    }

}
