package org.firstinspires.ftc.teamcode.RobotMecanum.OpMode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.RobotMecanum.JoystickBindings;
import org.firstinspires.ftc.teamcode.RobotMecanum.Telemetry;
import org.firstinspires.ftc.teamcode.RobotMecanum.RobotMecanum;
import org.firstinspires.ftc.teamcode.RobotMecanum.Subsystems.Flywheel;

@TeleOp(name="teleopMecanum")
public class TeleopMecanum extends OpMode {

    private RobotMecanum robot;
    private JoystickBindings joystickBindings;
    private Telemetry telemetryObject;

    @Override
    public void init() {
        robot = new RobotMecanum(hardwareMap);
        joystickBindings = new JoystickBindings(gamepad1);
        telemetryObject = new Telemetry(telemetry);
    }

    @Override
    public void loop() {
        joystickBindings.mainJoystickButtons(robot);
        //telemetry.addData("RailMode", robot.getRail().getMode());
        telemetryObject.addData("yaw",robot.getYaw());
        telemetryObject.addData("expected flywheel speed", Flywheel.expectedVelocity);
        telemetryObject.addData("current velocity", robot.getFlywheel().getVelocity());

        telemetryObject.getTelemetry().update();
    }

}
