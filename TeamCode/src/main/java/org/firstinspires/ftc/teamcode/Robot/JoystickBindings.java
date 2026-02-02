package org.firstinspires.ftc.teamcode.Robot;

import com.qualcomm.robotcore.hardware.Gamepad;

public class JoystickBindings {
    public final Gamepad gamepad1;

    public JoystickBindings(Gamepad gamepad1) {
        this.gamepad1 = gamepad1;
    }

    public void mainJoystickButtons(Robot robot) {
        robot.getTank().moveWithStickXY(gamepad1.left_stick_x, gamepad1.right_stick_y);

        if (gamepad1.right_trigger > 0.5) {
            robot.getRail().go();
        } else {
            robot.getRail().stop();
        }

        if (gamepad1.left_trigger>0.1) {
            robot.getFlywheel().shoot();
        }

        if(gamepad1.left_bumper)
            robot.getFlywheel().stop();

        if (gamepad1.back) {
            robot.getFlywheel().stop();
        }
        if(gamepad1.psWasPressed()){
            robot.getFlywheel().stop();
            robot.getRail().stop();
            robot.getTank().stop();
        }

    }

    public void mainJoystickButtonsMecha(RobotMecha robot) {
        robot.getMechanum().moveWithStickXY(gamepad1.left_stick_x, gamepad1.right_stick_y);

        if (gamepad1.right_trigger > 0.5) {
            robot.getRail().go();
        } else {
            robot.getRail().stop();
        }

        if (gamepad1.left_trigger>0.1) {
            robot.getFlywheel().shoot();
        }

        if(gamepad1.left_bumper)
            robot.getFlywheel().stop();

        if (gamepad1.back) {
            robot.getFlywheel().stop();
        }
        if(gamepad1.psWasPressed()){
            robot.getFlywheel().stop();
            robot.getRail().stop();
            robot.getMechanum().stop();
        }

    }

}
