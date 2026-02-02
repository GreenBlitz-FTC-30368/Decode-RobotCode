package org.firstinspires.ftc.teamcode.Robot.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.Robot.MathUtilBlitz;

public class Mechanum {
    private final DcMotor flMotor;
    private final DcMotor frMotor;
    private final DcMotor blMotor;
    private final DcMotor brMotor;
    public Mechanum(DcMotor flMotor, DcMotor frMotor, DcMotor blMotor, DcMotor brMotor){
        this.flMotor = flMotor;
        this.frMotor = frMotor;
        this.blMotor = blMotor;
        this.brMotor = brMotor;
        frMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        brMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        flMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        blMotor.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    public void moveWithXYAnglepower(double x, double y, double anglePower){
        //*negative y means forward
        double fl = -y+x+anglePower;
        double fr = -y-x-anglePower;
        double bl = -y-x+anglePower;
        double br = -y+x-anglePower;
        double maxPower = Math.abs(x)+Math.abs(y)+Math.abs(anglePower);
        if (maxPower>1){
            fl/=maxPower;
            fr/=maxPower;
            bl/=maxPower;
            br/=maxPower;
        }
        flMotor.setPower(fl);
        frMotor.setPower(fr);
        blMotor.setPower(bl);
        brMotor.setPower(br);
    }

}
