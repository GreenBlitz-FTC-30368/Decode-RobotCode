package org.firstinspires.ftc.teamcode.Robot;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

public class Robot {
    private static final Rail rail = new Rail(hardwareMap.crservo.get("railLeft"), hardwareMap.crservo.get("railRight"));
    public Robot(){
    }
    public Rail getRail() {
        return rail;
    }
}
