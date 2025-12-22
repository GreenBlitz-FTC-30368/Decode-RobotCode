package org.firstinspires.ftc.teamcode.Robot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class FlyWheel {
    private final DcMotor flywheel;
    private boolean isShooting = false;
    public FlyWheel(DcMotor flywheel){
        this.flywheel = flywheel;
        flywheel.setDirection(DcMotorSimple.Direction.REVERSE);
        flywheel.setPower(0);
    }
    public void setState(boolean shooting){
        isShooting=shooting;
        flywheel.setPower(shooting?1:0);
    }

    public enum WheelState{
        INACTIVE(0),
        SPINNING(0.2),
        SHOOTING(0.8);

        double speed;
        WheelState(double speed){
            this.speed=speed;
        }
    }
    private WheelState wheelState = WheelState.INACTIVE;
    public WheelState getState(){
        return wheelState;
    }
    public void setState(WheelState wheelState){
        this.wheelState = wheelState;
        flywheel.setPower(wheelState.speed);
    }
}
