package org.firstinspires.ftc.teamcode.Robot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class FlyWheel {
    private final DcMotor flywheel;
    private boolean isShooting = false;
    public FlyWheel(DcMotor flywheel){
        this.flywheel = flywheel;
        flywheel.setPower(0);
    }
    public void setState(boolean shooting){
        isShooting=shooting;
        flywheel.setPower(shooting?1:0);
    }
    public boolean getShooting(){
        return isShooting;
    }
    public void toggleState(){
        setState(!isShooting);
    }
}
