package org.firstinspires.ftc.teamcode.Robot.OpMode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Robot.JoystickBindings;
import org.firstinspires.ftc.teamcode.Robot.Robot;

public class Teleop extends OpMode {

    private Robot robot;
    private JoystickBindings joystickBindings;

    @Override
    public void init() {
        robot = new Robot();
        joystickBindings = new JoystickBindings(gamepad1);
    }

    @Override
    public void loop() {
        joystickBindings.mainJoystickButtons(robot);
    }
}
