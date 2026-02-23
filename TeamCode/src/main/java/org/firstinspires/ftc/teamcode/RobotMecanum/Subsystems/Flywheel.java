package org.firstinspires.ftc.teamcode.RobotMecanum.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.MathUtilBlitz;

public class Flywheel {
    private final DcMotorEx flywheel;
    private final DcMotor flywheel2;
    private static final double shootingPower= 0.767;

    public Flywheel(DcMotorEx flywheel, DcMotor flywheel2) {
        flywheel2.setDirection(DcMotorSimple.Direction.REVERSE);
        flywheel.setDirection(DcMotorSimple.Direction.FORWARD);
        flywheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.flywheel = flywheel;
        this.flywheel2 = flywheel2;
    }

    public double getVelocity(){
        return flywheel.getVelocity(AngleUnit.DEGREES);
    }
    private boolean shouldAddData = false;
    public void shoot() {
        shouldAddData=true;
        flywheel.setPower(shootingPower);
        flywheel2.setPower(shootingPower);
    }

    public void stop() {
        shouldAddData=false;
        flywheel.setPower(0);
        flywheel2.setPower(0);
    }

    private final static double flywheelStableVelocityToleranceDegPerSecond = 5;
    private final static int flywheelStableCheckDeltaTimeMS = 667;
    public void waitForFlywheelStart(){
        boolean shouldContinue = true;
        double previousSpeed,currentSpeed;
        previousSpeed = flywheel.getVelocity();
        while (shouldContinue){
            try {
                Thread.sleep(flywheelStableCheckDeltaTimeMS);
            } catch (Exception _){}
            currentSpeed = flywheel.getVelocity();
            shouldContinue= !MathUtilBlitz.isNear(previousSpeed,currentSpeed,flywheelStableVelocityToleranceDegPerSecond);
            previousSpeed=currentSpeed;
        }
    }

    public void addDataWhenFlywheelStart(Telemetry telemetry) {
        Thread thread = new Thread(() -> {
            waitForFlywheelStart();
            if (shouldAddData) {
                telemetry.addData("flywheel", "flywheel done accelerating");
            }
            shouldAddData = false;
        });
        thread.start();
    }
}
