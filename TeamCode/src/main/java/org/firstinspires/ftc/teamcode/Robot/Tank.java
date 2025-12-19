package org.firstinspires.ftc.teamcode.Robot;
import com.qualcomm.robotcore.hardware.DcMotor;
public class Tank {
    private final DcMotor leftMotor;
    private final DcMotor rightMotor;
    private static final double powerPerVelocity = 5;
    public Tank(DcMotor rightMotor, DcMotor leftMotor){
        this.leftMotor=leftMotor;
        this.rightMotor=rightMotor;
    }
    public void moveWithStickXY(double stickX, double stickY) {
        double left = stickY - stickX;
        double right = stickY + stickX;
        rightMotor.setPower(right*powerPerVelocity);
        leftMotor.setPower(left*powerPerVelocity);
    }
    public void stop(){
        rightMotor.setPower(0);
        leftMotor.setPower(0);
    }
}