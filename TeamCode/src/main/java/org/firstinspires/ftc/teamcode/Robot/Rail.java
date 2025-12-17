package org.firstinspires.ftc.teamcode.Robot;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class Rail {

    private final CRServo crServoLeft;

    private final CRServo crServoRight;

    private static final double maxSpeed = 12;

    public Rail(CRServo crServoLeft, CRServo crServoRight){
        this.crServoLeft=crServoLeft;
        this.crServoRight=crServoRight;

    }

    public void moveRailForward(){
        crServoRight.setDirection(DcMotorSimple.Direction.FORWARD);
        crServoLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        crServoLeft.setPower(maxSpeed/4);
        crServoRight.setPower(maxSpeed/4);
    }

    public void moveRailBackwards(){
        crServoLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        crServoRight.setDirection(DcMotorSimple.Direction.REVERSE);
        crServoRight.setPower(maxSpeed/4);
        crServoLeft.setPower(maxSpeed/4);
    }

    public void stopRail(){
        crServoLeft.setPower(0);
        crServoRight.setPower(0);
    }
}
