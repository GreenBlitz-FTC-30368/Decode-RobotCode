package org.firstinspires.ftc.teamcode.RobotMecanum;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.RobotTank.Robot;

public class JoystickBindings {
    public final Gamepad gamepad1;
    private final Telemetry telemetry;

    public JoystickBindings(Gamepad gamepad1, Telemetry telemetry) {
        this.gamepad1 = gamepad1;
        this.telemetry = telemetry;
    }

    public void mainJoystickButtons(RobotMecanum robot) {
        robot.getMecanum().drive(gamepad1);

        if (gamepad1.right_trigger > 0.5) {
            robot.getRail().go();
        } else {
            robot.getRail().stop();
        }

        if (gamepad1.left_trigger > 0.5) {
            robot.getFlywheel().shoot();
            robot.getFlywheel().addDataWhenFlywheelStart(telemetry);
        }

        if (gamepad1.left_bumper)
            robot.getFlywheel().stop();

        if (gamepad1.back) {
            robot.getFlywheel().stop();
        }
        if (gamepad1.psWasPressed()) {
            robot.getFlywheel().stop();
            robot.getRail().stop();
            robot.getMecanum().stop();
        }

    }

}
