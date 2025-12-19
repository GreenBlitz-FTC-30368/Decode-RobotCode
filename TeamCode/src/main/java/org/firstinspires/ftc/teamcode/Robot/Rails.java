package org.firstinspires.ftc.teamcode.Robot;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class Rails {
    private final CRServo leftRail;
    private final CRServo rightRail;
    private final double movePower=0.5;
    public Rails(CRServo rightRail, CRServo leftRail){
        this.leftRail=leftRail;
        this.rightRail=rightRail;
    }
    public void setMoving(boolean moving){
        leftRail.setPower(moving?movePower:0);
        rightRail.setPower(moving?-1*movePower:0);
    }
}