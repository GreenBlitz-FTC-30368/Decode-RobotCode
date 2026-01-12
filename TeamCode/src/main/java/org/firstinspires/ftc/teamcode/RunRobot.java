package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.CRServo;

import org.firstinspires.ftc.teamcode.Robot.FlyWheel;
import org.firstinspires.ftc.teamcode.Robot.Tank;
import org.firstinspires.ftc.teamcode.Robot.Rails;

@TeleOp(name = "test2")
public class RunRobot extends OpMode{
    Tank tank = null;
    FlyWheel flyWheel = null;
    Rails rails = null;
    boolean xPressedLastFrame = false;
    boolean railsMoving=false;
    DcMotor leftWheel;
    DcMotor rightWheel;
    @Override
    public void init(){
        leftWheel = hardwareMap.get(DcMotor.class,"leftWheel");
        rightWheel = hardwareMap.get(DcMotor.class,"rightWheel");
        flyWheel = new FlyWheel(hardwareMap.get(DcMotor.class,"flyWheel"));
        tank = new Tank(rightWheel,leftWheel);
        rails = new Rails(hardwareMap.get(CRServo.class,"rightRail"),hardwareMap.get(CRServo.class,"leftRail"));
        leftWheel.setPower(0);
        rightWheel.setPower(0);
    }
    @Override
    public void loop(){
        double speed=0;
        //tank.moveWithStickXY(gamepad1.left_stick_x, gamepad1.right_stick_y);
        if (gamepad1.x){
            flyWheel.setState(flyWheel.getState()== FlyWheel.WheelState.INACTIVE?FlyWheel.WheelState.SHOOTING:FlyWheel.WheelState.INACTIVE);
        }

        xPressedLastFrame = gamepad1.x;
        railsMoving = railsMoving&&!gamepad1.yWasReleased()|| gamepad1.yWasPressed();
        rails.setMoving(railsMoving);


        //tank.goToPosition(MathUtilBlitz.radianToDegree(Math.atan2(gamepad1.right_stick_y, gamepad1.right_stick_x)),gamepad1.left_stick_y);
        double leftV=gamepad1.right_trigger-gamepad1.right_stick_x;
        double rightV=gamepad1.right_trigger+gamepad1.right_stick_x;
        double absoluteMax = Math.max(Math.abs(leftV),Math.abs(rightV));
        telemetry.addData("bofore norm",""+leftV+" "+rightV);
        if (absoluteMax >1){
            leftV/= absoluteMax;
            rightV/= absoluteMax;
        }
        leftWheel.setPower(leftV);
        rightWheel.setPower(rightV);
        telemetry.addData("after norm",""+leftV+" "+rightV);
    }
}