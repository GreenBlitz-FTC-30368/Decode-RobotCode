package org.firstinspires.ftc.teamcode.Robot;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Tank {
    private final DcMotor leftMotor;
    private final DcMotor rightMotor;

    private static final double powerPerVelocity = 0.5;
    public Tank(DcMotor rightMotor, DcMotor leftMotor, double bodyWidth) {
        this.leftMotor = leftMotor;
        this.rightMotor = rightMotor;
    }
    public void moveWithStickXY(double stickX, double stickY){
        double left = stickX+stickY;
        double right = stickY-stickX;
        leftMotor.setPower(left);
        rightMotor.setPower(right);
    }
    public void stop(){
        rightMotor.setPower(0);
        leftMotor.setPower(0);
    }
}
