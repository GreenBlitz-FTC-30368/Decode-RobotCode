package org.firstinspires.ftc.teamcode.Robot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class Tank {
    private final DcMotor leftMotor;
    private final DcMotor rightMotor;

    private static final double ratioForTurn = 0.4;
    private static final double powerPerVelocity = 1;

    public static final double tolerance = 30;
    public Tank(DcMotor rightMotor, DcMotor leftMotor){
        this.leftMotor=leftMotor;
        this.rightMotor=rightMotor;
        leftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        rightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void goToPosition(double degrees, double power) {
        double reasonablePower = 0.8 * power;
        if (!(MathUtilBlitz.isNear(0, degrees, tolerance) || MathUtilBlitz.isNear(180, reasonablePower, tolerance) && degrees > 0)) {
            rightMotor.setPower(reasonablePower * ratioForTurn);
            leftMotor.setPower(reasonablePower);
        } else if (!(MathUtilBlitz.isNear(0, degrees, tolerance) || MathUtilBlitz.isNear(-180, degrees, tolerance))) {
            rightMotor.setPower(reasonablePower);
            leftMotor.setPower(reasonablePower * ratioForTurn);
        } else {
            leftMotor.setPower(reasonablePower);
            rightMotor.setPower(reasonablePower);
        }
    }

    public void moveY(double precent){
        rightMotor.setPower(precent*0.6);
        leftMotor.setPower(precent*0.6);
    }

    public void turn(Boolean isRight, double percent){
        if(isRight){
            rightMotor.setPower(percent*0.6*ratioForTurn);
            leftMotor.setPower(percent*0.6);
        }
        else{
            rightMotor.setPower(percent*0.6);
            leftMotor.setPower(percent*0.6*ratioForTurn);
        }
    }
    public void moveWithStickXY(double stickX, double stickY) {
        double left = stickY - stickX;
        double right = stickY + stickX;
        rightMotor.setPower(right*powerPerVelocity/2);
        leftMotor.setPower(left*powerPerVelocity/2);
    }
    public void stop(){
        rightMotor.setPower(0);
        leftMotor.setPower(0);
    }
}