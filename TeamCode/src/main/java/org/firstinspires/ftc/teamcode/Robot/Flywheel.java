package org.firstinspires.ftc.teamcode.Robot;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Flywheel {
    private final DcMotor flywheelMotor;

    public enum WheelState{
        SHOOTING(0.8),
        SPINNING(0.2),
        INACTIVE(0);
        public double power = 0;
        WheelState(double power){
            this.power = power;
        }
    }
    private WheelState state = WheelState.INACTIVE;
    public WheelState getState(){
        return state;
    }
    public Flywheel(DcMotor flywheelMotor)
    {this.flywheelMotor=flywheelMotor;}
     public void setState(WheelState state){
        flywheelMotor.setPower(state.power);
        this.state=state;
    }
}
