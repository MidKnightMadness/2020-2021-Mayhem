package org.firstinspires.ftc.teamcode.outtake;


import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@TeleOp

public class outtake extends LinearOpMode{
    private DcMotor leftMotor;
    private DcMotor rightMotor;
    private Servo slicey;
    // todo: write your code here

    public void runOpMode(){
        leftMotor = hardwareMap.get(DcMotor.class, "leftMotor");
        rightMotor = hardwareMap.get(DcMotor.class, "rightMotor");
        slicey = hardwareMap.get(Servo.class, "slicey");
        telemetry.addData("Status", "Press Play!");
        telemetry.update();
        boolean powered = false;
        int buttonCounter = 0;
        int sliceyCounter = 0;
        //double power = 0.0;

        waitForStart();

        while (opModeIsActive()) {
            if (powered) {
                leftMotor.setPower(1.0);
                rightMotor.setPower(-1.0);
            }
            else{
                leftMotor.setPower(0.0);
                rightMotor.setPower(0.0);
            }

            if(this.gamepad1.dpad_up && sliceyCounter == 0){
                slicey.setPosition(0.9);
                sliceyCounter = 10000;
            } else if (sliceyCounter == 0){
                slicey.setPosition(0.4);
            }

            if(gamepad1.y && buttonCounter == 0){
                powered = !powered;
                buttonCounter = 10000;
            }

            buttonCounter = Math.max(0, buttonCounter-1);
            sliceyCounter = Math.max(0, sliceyCounter-1);
            telemetry.addData("buttonCounter ", buttonCounter);
            telemetry.addData("sliceyCounter ", sliceyCounter);
            telemetry.update();


        }
    }
}