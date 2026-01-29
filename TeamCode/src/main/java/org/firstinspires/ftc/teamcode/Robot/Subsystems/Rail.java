package org.firstinspires.ftc.teamcode.Robot.Subsystems;

import android.app.Notification;

import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class Rail {
    //private final CRServo servoRight;
    private final CRServo servoLeft;

    private String mode;

    public Rail(/*CRServo servoRight*/ CRServo servoLeft) {
        this.servoLeft = servoLeft;
        //this.servoRight = servoRight;
        mode = "none";
    }

    public void stop() {
//        servoRight.setPower(0);
        servoLeft.setPower(0);
        mode = "stop";
    }

    public void go() {
//        servoRight.setDirection(DcMotorSimple.Direction.REVERSE);
        servoLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        servoLeft.setPower(0.6);
//        servoRight.setPower(0.6);
        mode = "go";
    }

    public String getMode() {
        return mode;
    }

}
