package org.firstinspires.ftc.teamcode.RobotMecanum;

public class Telemetry {
    private org.firstinspires.ftc.robotcore.external.Telemetry telemetry = null;

    public Telemetry(org.firstinspires.ftc.robotcore.external.Telemetry telemetry){
        this.telemetry = telemetry;
    }

    public void addData(String caption, Object object){
        if (telemetry!=null){
            telemetry.addData(caption, object);
        }
    }

    public org.firstinspires.ftc.robotcore.external.Telemetry getTelemetry() {
        return telemetry;
    }

}
