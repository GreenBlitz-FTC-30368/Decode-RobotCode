package org.firstinspires.ftc.teamcode.RobotMecanum.Subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class Rail {
    private final CRServo servoRight;
    private final CRServo servoLeft;
    private final double railPower = 0.767;
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
        servoLeft.setPower(-1* railPower);
        servoRight.setPower(-1* railPower);
        mode = "reverse";
    }

    public void go() {
        servoLeft.setPower(railPower);
        servoRight.setPower(railPower);
        mode = "go";
    }

    public String getMode() {
        return mode;
    }

}
