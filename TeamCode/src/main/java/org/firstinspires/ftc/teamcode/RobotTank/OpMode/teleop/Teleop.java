package org.firstinspires.ftc.teamcode.RobotTank.OpMode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.RobotTank.JoystickBindings;
import org.firstinspires.ftc.teamcode.RobotTank.Robot;

@TeleOp(name = "teleop1")
public class Teleop extends OpMode {

    private Robot robot;
    private JoystickBindings joystickBindings;

    @Override
    public void init() {
        robot = new Robot(hardwareMap);
        joystickBindings = new JoystickBindings(gamepad1);
    }

    @Override
    public void loop() {
        joystickBindings.mainJoystickButtons(robot);
        telemetry.addData("RailMode", robot.getRail().getMode());
    }

}
