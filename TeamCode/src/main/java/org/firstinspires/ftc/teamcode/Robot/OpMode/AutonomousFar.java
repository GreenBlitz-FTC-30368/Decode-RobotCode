package org.firstinspires.ftc.teamcode.Robot.OpMode;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.ftccommon.internal.manualcontrol.parameters.ImuParameters;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import org.firstinspires.ftc.teamcode.Robot.MathUtilBlitz;
import org.firstinspires.ftc.teamcode.Robot.Robot;
import org.firstinspires.ftc.teamcode.Robot.RobotConstants;

@Autonomous(name = "far auto67")
public class AutonomousFar extends LinearOpMode {
    private Robot robot;
    private IMU imu;
    private static final double farAutoTilesBeforeTurn = 1.5;
    private static final double farAutoTilesAfterTurn = Math.sqrt(2)*2;
    public static final double m = 0.1;
    private void moveForTiles(double tiles){
        robot.getTank().moveWithStickXY(0,-1);
        sleep((long)(tiles*RobotConstants.tileSizeCm/RobotConstants.tankMaxVelocityCmPerMinute*60000));
        robot.getTank().stop();  //punch alon please
    }

    @Override
    public void runOpMode() {
        waitForStart();
        imu = hardwareMap.get(IMU.class, "imu");
        IMU.Parameters meow = new IMU.Parameters((new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD)));
        double angleYaw;
        imu.resetYaw();
        angleYaw=imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES);
        double targetYaw=angleYaw+12.5;
        telemetry.addData("starting Yaw",angleYaw);
        telemetry.update();
        robot = new Robot(hardwareMap);
        moveForTiles(farAutoTilesBeforeTurn);
        boolean isAtPosition = false;
        double originalDelta = targetYaw-angleYaw;
        while(!isAtPosition&&opModeIsActive()){
            telemetry.addData("current Yaw",angleYaw);
            telemetry.update();
            angleYaw=imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES);
            robot.getTank().moveWithStickXY(m*(targetYaw-angleYaw)/originalDelta,0);
            isAtPosition = targetYaw-angleYaw<5;
        }
        robot.getFlywheel().shoot();
        moveForTiles(farAutoTilesAfterTurn);
        for (int i = 0; i < 3; i++) {
            robot.getRail().go();
            sleep(RobotConstants.timeToShootAnArtifactMS);
            robot.getRail().stop();
            sleep(RobotConstants.timeBetweenArtifactShootings);
        }
        robot.getRail().stop();

    }
}
