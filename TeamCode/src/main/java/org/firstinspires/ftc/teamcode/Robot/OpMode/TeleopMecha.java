package org.firstinspires.ftc.teamcode.Robot.OpMode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Robot.JoystickBindings;
import org.firstinspires.ftc.teamcode.Robot.Robot;
import org.firstinspires.ftc.teamcode.Robot.RobotMecha;

@TeleOp(name="teleopTank")
public class TeleopMecha extends OpMode {

    private RobotMecha robot;
    private JoystickBindings joystickBindings;

    @Override
    public void init() {
        robot = new RobotMecha(hardwareMap);
        joystickBindings = new JoystickBindings(gamepad1);
    }

    @Override
    public void loop() {
        joystickBindings.mainJoystickButtonsMecha(robot);
        telemetry.addData("RailMode", robot.getRail().getMode());
    }

}
