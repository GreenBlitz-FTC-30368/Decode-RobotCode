package org.firstinspires.ftc.teamcode.Robot;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class Rail {

    private final CRServo crServoLeft;

    private final CRServo crServoRight;

    private static final double maxPower = 1;

    public Rail(CRServo crServoLeft, CRServo crServoRight){
        this.crServoLeft=crServoLeft;
        this.crServoRight=crServoRight;

    }

    public void moveRailForward(){
        crServoRight.setDirection(DcMotorSimple.Direction.FORWARD);
        crServoLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        crServoLeft.setPower(maxPower /4);
        crServoRight.setPower(maxPower /4);
    }

    public void moveRailBackwards(){
        crServoLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        crServoRight.setDirection(DcMotorSimple.Direction.REVERSE);
        crServoRight.setPower(maxPower /4);
        crServoLeft.setPower(maxPower /4);
    }

    public void stopRail(){
        crServoLeft.setPower(0);
        crServoRight.setPower(0);
    }
}
