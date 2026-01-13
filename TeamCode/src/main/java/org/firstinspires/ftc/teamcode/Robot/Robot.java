package org.firstinspires.ftc.teamcode.Robot;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import org.firstinspires.ftc.teamcode.Robot.Subsystems.Rail;

public class Robot {

    /*
    ⠀⠀⠀⠀⢀⣠⠤⠤⠤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡤⠤⠤⢄⡀⠀⠀⠀⠀
⠀⠀⢀⠴⠉⠀⠀⠀⠀⠀⠙⢄⠀⠀⠀⠀⠀⠀⣠⠞⠁⠀⠀⠀⠀⠈⠢⡀⠀⠀
⠀⢀⠎⠀⠀⠀⠀⠀⠀⠀⠀⠀⢧⠀⠀⠀⠀⡰⠁⠀⠀⠀⠀⠀⠀⠀⠀⠘⡄⠀
⢀⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢧⠀⠀⣰⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠀
⣾⠀⢀⣀⣀⣀⠀⠀⠀⠀⠀⠀⠀⢸⡄⠀⡇⠀⣀⣀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀
⣧⣴⠋⠉⣿⣿⣿⣦⠀⠀⠀⠀⠀⢸⡃⠰⢠⡞⠉⢹⣿⣿⣷⡄⠀⠀⠀⠀⠀⠈
⣽⣿⣷⣾⣿⣿⣿⣿⡆⠀⠀⠀⠀⢸⡅⢨⣿⣿⣶⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⢐
⢿⣿⣿⣿⣿⣿⠟⣸⠁⠀⠀⠀⠀⠘⡆⠀⡿⣿⣿⣿⣿⡿⠏⡞⠀⠀⠀⠀⠀⠠
⠘⡈⠳⠭⠭⠥⠚⠁⠀⠀⠀⠀⠀⣺⠀⠀⢧⠙⠪⠭⠭⠔⠊⠀⠀⠀⠀⠀⠀⠘
⠀⢳⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⠇⠀⠀⠈⢆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡐⠀
⠀⠀⠱⣀⠀⠀⠀⠀⠀⠀⠀⣨⠇⠀⠀⠀⠀⠘⢆⠀⠀⠀⠀⠀⠀⠀⢀⡜⠁⠀
⠀⠀⠀⠈⠢⢄⣀⡀⢠⡠⠚⠁⠀⠀⠀⠀⠀⠀⠀⠑⢤⣀⣀⢀⣠⠴⠋⠀⠀⠀
     */

    private final Rail rail;

    public Robot() {
        this.rail = new Rail(hardwareMap.crservo.get("railRight"), hardwareMap.crservo.get("railLeft"));
    }

    public Rail getRail() {
        return rail;
    }

}
