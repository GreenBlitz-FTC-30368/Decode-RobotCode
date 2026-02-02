package org.firstinspires.ftc.teamcode.Robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class MecanumDrive {

    private final DcMotor frontLeft;
    private final DcMotor backLeft;
    private final DcMotor frontRight;
    private final DcMotor backRight;

    public MecanumDrive(HardwareMap hardwareMap) {
        frontLeft = hardwareMap.get(DcMotor.class, "front_left_drive");
        backLeft = hardwareMap.get(DcMotor.class, "back_left_drive");
        frontRight = hardwareMap.get(DcMotor.class, "front_right_drive");
        backRight = hardwareMap.get(DcMotor.class, "back_right_drive");

        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.REVERSE);
        frontRight.setDirection(DcMotor.Direction.FORWARD);
        backRight.setDirection(DcMotor.Direction.FORWARD);
    }

    public void driveByDriverJoystick(Gamepad gamepad) {
        double drive = gamepad.left_stick_y;
        double strafe = gamepad.left_stick_x;
        double twist = gamepad.right_stick_x;

        double[] motorSpeeds = {
                (drive + strafe + twist),
                (drive - strafe - twist),
                (drive - strafe + twist),
                (drive + strafe - twist)
        };

        double max = Math.abs(motorSpeeds[0]);
        for (double motorSpeed : motorSpeeds) {
            if (max < Math.abs(motorSpeed)) max = Math.abs(motorSpeed);
        }

        if (max > 1) {
            for (int i = 0; i < motorSpeeds.length; i++) motorSpeeds[i] /= max;
        }

        frontLeft.setPower(motorSpeeds[0]);
        frontRight.setPower(motorSpeeds[1]);
        backLeft.setPower(motorSpeeds[2]);
        backRight.setPower(motorSpeeds[3]);
    }

}
