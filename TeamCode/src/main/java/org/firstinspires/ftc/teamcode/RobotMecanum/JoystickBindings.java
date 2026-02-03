package org.firstinspires.ftc.teamcode.RobotMecanum;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.RobotTank.Robot;

public class JoystickBindings {
    public final Gamepad gamepad1;

    public JoystickBindings(Gamepad gamepad1) {
        this.gamepad1 = gamepad1;
    }

    public void mainJoystickButtons(RobotMecanum robot) {
        robot.getMecanum().drive(gamepad1);

        if (gamepad1.right_trigger > 0.5) {
            robot.getRail().go();
        } else {
            robot.getRail().stop();
        }

        if (gamepad1.left_trigger > 0.1) {
            robot.getFlywheel().shoot();
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
