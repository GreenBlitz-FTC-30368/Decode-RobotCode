package org.firstinspires.ftc.teamcode.Robot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class Tank {
    private final DcMotor leftMotor;
    private final DcMotor rightMotor;
    private static final double powerPerVelocity = 1;
    public Tank(DcMotor rightMotor, DcMotor leftMotor){
        this.leftMotor=leftMotor;
        this.rightMotor=rightMotor;
        leftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        rightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }
    public void moveWithStickXY(double stickX, double stickY) {
        double left = stickY - stickX;
        double right = stickY + stickX;
        if (Math.max(left,right)>1){
            left/=Math.max(left,right);
            right/=Math.max(left,right);
        }
        rightMotor.setPower(right*powerPerVelocity);
        leftMotor.setPower(left*powerPerVelocity);
    }
    public void stop(){
        rightMotor.setPower(0);
        leftMotor.setPower(0);
    }
}