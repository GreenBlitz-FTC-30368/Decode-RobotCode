package org.firstinspires.ftc.teamcode.RobotMecanum.OpMode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.RobotMecanum.JoystickBindings;
import org.firstinspires.ftc.teamcode.RobotMecanum.RobotMecanum;

@TeleOp(name="teleopMecanum")
public class TeleopMecanum extends OpMode {

    private RobotMecanum robot;
    private JoystickBindings joystickBindings;

    @Override
    public void init() {
        robot = new RobotMecanum(hardwareMap);
        joystickBindings = new JoystickBindings(gamepad1);
    }

    @Override
    public void loop() {
        joystickBindings.mainJoystickButtons(robot);
        telemetry.addData("RailMode", robot.getRail().getMode());
    }

}
