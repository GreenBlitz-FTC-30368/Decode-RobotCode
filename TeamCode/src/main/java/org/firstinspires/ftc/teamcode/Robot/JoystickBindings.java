package org.firstinspires.ftc.teamcode.Robot;

import com.qualcomm.robotcore.hardware.Gamepad;

public class JoystickBindings {
    public final Gamepad gamepad1;
    public final Gamepad gamepad2;

    public JoystickBindings(Gamepad gamepad1, Gamepad gamepad2){
        this.gamepad1=gamepad1;
        this.gamepad2=gamepad2;
    }
    public void mainJoystickButtons(Robot robot){
        if(gamepad1.x){//shooting
            if (robot.getFlywheel().getState()==Flywheel.WheelState.SHOOTING){
                robot.getFlywheel().setState(Flywheel.WheelState.SPINNING);
            } else {
                robot.getFlywheel().setState(Flywheel.WheelState.SHOOTING);
            }
        }
        if(gamepad1.y){//normal spin
            if (robot.getFlywheel().getState()==Flywheel.WheelState.INACTIVE){
                robot.getFlywheel().setState(Flywheel.WheelState.SHOOTING);
            } else {
                robot.getFlywheel().setState(Flywheel.WheelState.INACTIVE);
            }
        }
    }
}
