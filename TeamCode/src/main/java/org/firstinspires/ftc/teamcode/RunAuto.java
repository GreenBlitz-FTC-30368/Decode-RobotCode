package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Robot.FlyWheel;
import org.firstinspires.ftc.teamcode.Robot.Rails;
import org.firstinspires.ftc.teamcode.Robot.Tank;

@Autonomous(name="auto1")
public class RunAuto extends OpMode{
    DcMotor leftWheel = hardwareMap.get(DcMotor .class,"leftWheel");
    DcMotor rightWheel = hardwareMap.get(DcMotor.class, "rightWheel");
    @Override
    public void init() {
        leftWheel.setPower(0.2);
        rightWheel.setPower(0.2);
    }
    @Override
    public void loop(){

    }
}
