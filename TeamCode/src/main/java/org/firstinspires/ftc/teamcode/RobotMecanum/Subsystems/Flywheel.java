package org.firstinspires.ftc.teamcode.RobotMecanum.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.MathUtilBlitz;
import org.firstinspires.ftc.teamcode.RobotMecanum.RobotConstants;

public class Flywheel {
    private final DcMotorEx flywheel;
    private final DcMotor flywheel2;
    private static final double shootingPower= 0.767;
    public static final double expectedVelocity = 1.0*RobotConstants.rPM*360/60*shootingPower;
    public double powerModifier = 1;
    public static final double slowModeShootingModifier=0.75;

    public Flywheel(DcMotorEx flywheel, DcMotor flywheel2) {
        flywheel2.setDirection(DcMotorSimple.Direction.FORWARD);
        flywheel2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        flywheel.setDirection(DcMotorSimple.Direction.FORWARD);
        flywheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        flywheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.flywheel = flywheel;
        this.flywheel2 = flywheel2;
    }

    public double getVelocity(){
        return flywheel.getVelocity(AngleUnit.DEGREES);
    }
    public void shoot() {
        flywheel.setPower(shootingPower*powerModifier);
        flywheel2.setPower(shootingPower*powerModifier);
    }

    public void stop() {
        flywheel.setPower(0);
        flywheel2.setPower(0);
    }
}
