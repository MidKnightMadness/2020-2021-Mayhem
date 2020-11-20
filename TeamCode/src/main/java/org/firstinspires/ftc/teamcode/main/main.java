package org.firstinspires.ftc.teamcode.main;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.common.Angle;
import org.firstinspires.ftc.teamcode.common.Assembly;
import org.firstinspires.ftc.teamcode.chassis.Drive;
import org.firstinspires.ftc.teamcode.chassis.MechanumWheels;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.CRServo;




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

    private CRServo servo2;
    private CRServo servo1;
    private DcMotor ahaha;
    private DcMotor leftMotor;
    private DcMotor rightMotor;




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

        //Wheels
        Angle direction = Angle.aTan(gamepad1.left_stick_x, -gamepad1.left_stick_y);
        double speed = Math.hypot(gamepad1.left_stick_x, -gamepad1.left_stick_y) * (1 - gamepad1.right_trigger) * (1 - gamepad1.left_trigger) * (slow ? 0.3 : 1);
        double rotation = gamepad1.right_stick_x * (1 - gamepad1.right_trigger) * (1 - gamepad1.left_trigger) * (slow ? 0.3 : 1);
        drive.setDirection(direction, speed, rotation);
        drive.update();
        servo2 = hardwareMap.get(CRServo.class, "servo2");
        servo1 = hardwareMap.get(CRServo.class, "servo1");
        ahaha = hardwareMap.get(DcMotor.class, "ahaha");
        leftMotor = hardwareMap.get(DcMotor.class, "leftMotor");
        rightMotor = hardwareMap.get(DcMotor.class, "rightMotor");
        telemetry.addData("Status", "Press Play!");
        telemetry.update();
        boolean powered = false;
        int buttonCounter = 0;
        double power = 0.0;

        //outake/intake/conveyerbelt
            if (powered) {
                ahaha.setPower(.4);
                leftMotor.setPower(1.0);
                rightMotor.setPower(-1.0);
            } else {
                ahaha.setPower(0.0);
                leftMotor.setPower(0.0);
                rightMotor.setPower(0.0);
            }

            if (gamepad1.x && buttonCounter == 0) {
                buttonCounter = 10000;
                powered = !powered;

            }
            if (buttonCounter > 0) {
                buttonCounter = buttonCounter - 1;
            }
            telemetry.addData("Status", buttonCounter);
            telemetry.update();

            if (this.gamepad1.a) {
                servo2.setPower(0.9);
                servo1.setPower(-0.9);
            } else {
                servo2.setPower(-0.9);
                servo1.setPower(0.9);
            }

            //belt dog

        }



    public void stop()
    {

    }
}