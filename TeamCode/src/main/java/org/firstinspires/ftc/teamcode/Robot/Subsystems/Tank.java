package org.firstinspires.ftc.teamcode.Robot.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Robot.MathUtilBlitz;

public class Tank {
    private final DcMotor leftMotor;
    private final DcMotor rightMotor;

    private static final double fixedAngleRatio = 4/5;
    private static final double tolerance = 0.05;

    public Tank(DcMotor rightMotor, DcMotor leftMotor){
        this.leftMotor=leftMotor;
        this.rightMotor=rightMotor;
    }

    public void goToPosition(double degrees, double power){
        double reasonablePower = 0.6*power;
        if(!(MathUtilBlitz.isNear(0,degrees,tolerance)||MathUtilBlitz.isNear(180, reasonablePower, tolerance)&& degrees>0)){
            rightMotor.setPower(reasonablePower*fixedAngleRatio);
            leftMotor.setPower(reasonablePower);
        } else if(!(MathUtilBlitz.isNear(0, degrees, tolerance) || MathUtilBlitz.isNear(180, degrees, tolerance))){
            rightMotor.setPower(reasonablePower);
            leftMotor.setPower(reasonablePower*fixedAngleRatio);
        }
        else{
            leftMotor.setPower(reasonablePower);
            rightMotor.setPower(reasonablePower);
        }
    }

    public void stop(){
        rightMotor.setPower(0);
        leftMotor.setPower(0);
    }

}
