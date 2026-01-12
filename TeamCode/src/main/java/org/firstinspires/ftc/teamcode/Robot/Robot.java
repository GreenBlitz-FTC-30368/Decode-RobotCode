package org.firstinspires.ftc.teamcode.Robot;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

public class Robot {
    Rail rail;

    public Robot(){
        this.rail = new Rail(hardwareMap.crservo.get("railRight"), hardwareMap.crservo.get("railLeft"));
    }
}