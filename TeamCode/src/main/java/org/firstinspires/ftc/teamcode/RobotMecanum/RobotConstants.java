package org.firstinspires.ftc.teamcode.RobotMecanum;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class RobotConstants {
    public static final int wheelAccelerationTimeMS = 1000;
    public static final int timeToShootAnArtifactMS = 500;
    public static final int timeBetweenArtifactShootings = 1000;
    public static final int RPM = 117;
    public static final double mecanumWheelRadiusCm = 5;
    public static final double mecanumDiagonalMaxVelocityCmPerMinute=RPM*mecanumWheelRadiusCm*Math.PI*2;
    public static final double mecanumVerticalHorizontalMaxVelocityCmPerMinute = mecanumDiagonalMaxVelocityCmPerMinute*Math.sqrt(2);
    public static final double mecanumRotationalMaxVelocityDegreePerMinute=mecanumDiagonalMaxVelocityCmPerMinute*Math.PI/180;
    public static final double distanceToShootCm = 50;
    public static final double tileSizeCm = 60.96;
    public static final double timeToMoveTileAtMaxSpeed = tileSizeCm/mecanumVerticalHorizontalMaxVelocityCmPerMinute;
}
