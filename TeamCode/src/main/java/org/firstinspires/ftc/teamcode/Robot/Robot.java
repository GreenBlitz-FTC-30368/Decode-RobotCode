package org.firstinspires.ftc.teamcode.Robot;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Robot.Subsystems.Flywheel;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.Rail;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.Tank;

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
    private final Flywheel flywheel;
    private final Tank tank;

    public Robot(HardwareMap hardwareMap) {
        this.rail = new Rail(
                hardwareMap.crservo.get("railRight"),
                hardwareMap.crservo.get("railLeft")
        );
        flywheel = new Flywheel(
                hardwareMap.dcMotor.get("flywheelMotor")
        );
        tank = new Tank(
                hardwareMap.dcMotor.get("tankRight"),
                hardwareMap.dcMotor.get("tankLeft")
        );
    }

    public Rail getRail() {
        return rail;
    }

    public Flywheel getFlywheel() {
        return flywheel;
    }

    public Tank getTank() {
        return tank;
    }
}
