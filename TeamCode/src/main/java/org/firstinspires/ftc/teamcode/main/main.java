package org.firstinspires.ftc.teamcode.main;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.common.Angle;
import org.firstinspires.ftc.teamcode.common.Assembly;
import org.firstinspires.ftc.teamcode.chassis.Drive;
import org.firstinspires.ftc.teamcode.chassis.MechanumWheels;




@TeleOp
public class main extends OpMode {

    private Drive drive = new MechanumWheels();

    private double targetHeight;
    private double targetDepth;

    private boolean ypressed;
    private int mode = 1;

    private boolean xpressed;
    private boolean isGrabbed;
    private double targetGrabberRot;
    private int grabberDefaultRotation;
    private boolean dlpressed;
    private boolean drpressed;
    private boolean ddpressed;
    private boolean dupressed;
    private boolean slow;

    private int doGrab;



    @Override
    public void init() {
        telemetry.addLine("------------------------------");
        telemetry.addLine("        |     |   -----   |");
        telemetry.addLine("        |-----|     |     |");
        telemetry.addLine("        |     |   -----   .");
        telemetry.addLine("------------------------------");
        telemetry.addLine(" \"Please get better text art\"");

        //drive.setDriveMode(Drive.DRIVEMODE.RELATIVE);

        telemetry.addLine("I AM INITIALIZED FOR POWER!!!");
        telemetry.addLine(" -- Just for Chris and David...");
        telemetry.update();
    }

    public void init_loop() {

    }

    public void start()
    {

    }

    @Override
    public void loop() {
        //LEDs


        Angle direction = Angle.aTan(gamepad1.left_stick_x, -gamepad1.left_stick_y);
        double speed = Math.hypot(gamepad1.left_stick_x, -gamepad1.left_stick_y) * (1 - gamepad1.right_trigger) * (1 - gamepad1.left_trigger) * (slow ? 0.3 : 1);
        double rotation = gamepad1.right_stick_x * (1 - gamepad1.right_trigger) * (1 - gamepad1.left_trigger) * (slow ? 0.3 : 1);
        drive.setDirection(direction, speed, rotation);
        drive.update();


    }

    public void stop()
    {

    }
}