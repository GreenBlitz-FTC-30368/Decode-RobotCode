package org.firstinspires.ftc.teamcode.Robot;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.MecanumDrive;

public class Robot {

    private MecanumDrive drive;

    public Robot(HardwareMap hardwareMap){
        drive = new MecanumDrive(hardwareMap, new Pose2d(0,0,0));
        drive.setDrivePowers(new PoseVelocity2d(new Vector2d(),));
    }

}
