package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Robot.Tank;

@TeleOp(name="test1")
public class RunRobot extends OpMode{
    Tank tank = null;
    @Override
    public void init(){
        DcMotor leftWheel = hardwareMap.get(DcMotor.class,"leftWheel");
        DcMotor rightWheel = hardwareMap.get(DcMotor.class,"rightWheel");
        tank = new Tank(rightWheel,leftWheel);
    }
    @Override
    public void loop(){
        tank.moveWithStickXY(gamepad1.left_stick_x, gamepad1.left_stick_y);
    }
}