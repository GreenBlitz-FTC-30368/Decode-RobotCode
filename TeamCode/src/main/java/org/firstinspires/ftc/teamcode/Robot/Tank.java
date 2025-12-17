package org.firstinspires.ftc.teamcode.Robot;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Tank {
    private final DcMotor leftMotor;
    private final DcMotor rightMotor;

    private static final double deltaBetweenMotorsToTurn90DegTPS = 720;
    private static final double blindaMotorLimtTPS = 3600;

    public Tank(DcMotor rightMotor, DcMotor leftMotor){
        this.leftMotor=leftMotor;
        this.rightMotor=rightMotor;
    }

    public void goToPosition(int degrees){

    }
}
