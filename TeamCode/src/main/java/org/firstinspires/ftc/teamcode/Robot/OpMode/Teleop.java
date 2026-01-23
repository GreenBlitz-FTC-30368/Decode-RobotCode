package org.firstinspires.ftc.teamcode.Robot.OpMode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Robot.JoystickBindings;
import org.firstinspires.ftc.teamcode.Robot.Robot;
@TeleOp(name="teleop1")
public class Teleop extends OpMode { // add name

    private Robot robot;
    private JoystickBindings joystickBindings;

    @Override
    public void init() {
        robot = new Robot(this.hardwareMap);
        joystickBindings = new JoystickBindings(gamepad1);
    }

    @Override
    public void loop() {
        joystickBindings.mainJoystickButtons(robot);
        telemetry.addData("RailMode", robot.getRail().getMode());
    }

}
