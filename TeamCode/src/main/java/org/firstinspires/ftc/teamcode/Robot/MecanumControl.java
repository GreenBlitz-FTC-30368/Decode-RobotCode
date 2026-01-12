package org.firstinspires.ftc.teamcode.Robot;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.MecanumDrive;

public class MecanumControl {
    private DcMotor forwardRight;
    private DcMotor forwardLeft;
    private DcMotor backRight;
    private DcMotor backLeft;
    public void moveWithXYAngle(double x, double y, double angle){
        double frPower;
        double flPower;
        double brPower;
        double blPower;
        frPower=y-x-angle;
        flPower=y+x+angle;
        blPower=y-x+angle;
        brPower=y+x-angle;
        double maxAbsPower=Math.max(Math.max(Math.abs(frPower),Math.abs(flPower)),
                Math.max(Math.abs(brPower),Math.abs(blPower)));
        if (maxAbsPower>1){
            frPower/=maxAbsPower;
            flPower/=maxAbsPower;
            blPower/=maxAbsPower;
            brPower/=maxAbsPower;
        }
        forwardLeft.setPower(flPower);
        forwardRight.setPower(frPower);
        backLeft.setPower(blPower);
        backRight.setPower(brPower);
    }
    public MecanumControl(DcMotor forwardRight,DcMotor forwardLeft,DcMotor backLeft,DcMotor backRight){
        this.forwardRight=forwardRight;
        this.forwardLeft=forwardLeft;
        this.backLeft=backLeft;
        this.backRight=backRight;
    }
}
