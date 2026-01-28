package org.firstinspires.ftc.teamcode.Robot.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Robot.MathUtilBlitz;

public class Tank {
    private final DcMotor leftMotor;
    private final DcMotor rightMotor;
    private final double maxPowerFactor = 1;

    public Tank(DcMotor rightMotor, DcMotor leftMotor) {
        this.leftMotor = leftMotor;
        this.rightMotor = rightMotor;
    }

    public void moveWithStickXY(double stickY, double stickX) {
        double left = stickX - stickY;
        double right = stickX + stickY;

        if (Math.max(Math.abs(left), Math.abs(right)) > 1) {
            left /= Math.max(left, right);
            right /= Math.max(left, right);
        }

        rightMotor.setPower(right * maxPowerFactor);
        leftMotor.setPower(left * maxPowerFactor);
    }

    public void stop() {
        rightMotor.setPower(0);
        leftMotor.setPower(0);
    }

}
