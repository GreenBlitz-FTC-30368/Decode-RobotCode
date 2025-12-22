package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.CRServo;

import org.firstinspires.ftc.teamcode.Robot.FlyWheel;
import org.firstinspires.ftc.teamcode.Robot.MathUtilBlitz;
import org.firstinspires.ftc.teamcode.Robot.Tank;
import org.firstinspires.ftc.teamcode.Robot.Rails;

@TeleOp(name="test1")
public class RunRobot extends OpMode{
    Tank tank = null;
    FlyWheel flyWheel = null;
    Rails rails = null;
    boolean xPressedLastFrame = false;
    @Override
    public void init(){
        DcMotor leftWheel = hardwareMap.get(DcMotor.class,"leftWheel");
        DcMotor rightWheel = hardwareMap.get(DcMotor.class,"rightWheel");
        flyWheel = new FlyWheel(hardwareMap.get(DcMotor.class,"flyWheel"));
        tank = new Tank(rightWheel,leftWheel);
        rails = new Rails(hardwareMap.get(CRServo.class,"rightRail"),hardwareMap.get(CRServo.class,"leftRail"));
    }
    @Override
    public void loop(){
        //tank.moveWithStickXY(gamepad1.right_stick_x, gamepad1.left_stick_y);
        if (gamepad1.x&&!xPressedLastFrame){
            flyWheel.toggleState();
        }
        xPressedLastFrame = gamepad1.x;
        rails.setMoving(gamepad1.y);
        tank.goToPosition(MathUtilBlitz.radianToDegree(Math.atan2(gamepad1.right_stick_x, gamepad1.right_stick_y)),gamepad1.left_stick_y);
    }
}