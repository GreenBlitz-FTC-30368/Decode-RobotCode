package org.firstinspires.ftc.teamcode.Robot.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Mecanum {
    private final DcMotor flMotor;
    private final DcMotor frMotor;
    private final DcMotor blMotor;
    private final DcMotor brMotor;
    public Mecanum(DcMotor flMotor, DcMotor frMotor, DcMotor blMotor, DcMotor brMotor){
        this.flMotor = flMotor;
        this.frMotor = frMotor;
        this.blMotor = blMotor;
        this.brMotor = brMotor;
        frMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        brMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        flMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        blMotor.setDirection(DcMotorSimple.Direction.FORWARD);
    }


    public void drive(double x, double y, double anglePower){

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

    public void drive(Gamepad gamepad){
        drive(gamepad.left_stick_x, gamepad.left_stick_y, gamepad.right_stick_x);
    }

    public Mecanum(HardwareMap hardwareMap){
        this.flMotor = hardwareMap.dcMotor.get("frontLeftWheel");
        this.frMotor = hardwareMap.dcMotor.get("frontRightWheel");
        this.blMotor = hardwareMap.dcMotor.get("backLeftMotor");
        this.brMotor = hardwareMap.dcMotor.get("backRightMotor");
        frMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        brMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        flMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        blMotor.setDirection(DcMotorSimple.Direction.FORWARD);
    }
    public void stop(){
        flMotor.setPower(0);
        frMotor.setPower(0);
        blMotor.setPower(0);
        brMotor.setPower(0);
    }
}
