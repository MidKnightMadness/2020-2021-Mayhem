package org.firstinspires.ftc.teamcode.intake;


import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@TeleOp


public class intake extends LinearOpMode{

    private CRServo servo2;
    private CRServo servo1;

    public void runOpMode(){

        servo2 = hardwareMap.get(CRServo.class, "servo2");
        servo1 = hardwareMap.get(CRServo.class, "servo1");
        telemetry.addData("Status", "Press play!" );
        telemetry.update();
        double power = 0.0;


        waitForStart();//This will set the play button

        while(opModeIsActive()){//This will run when you press the run button

            if (this.gamepad1.a){
                servo2.setPower(0.9);
                servo1.setPower(-0.9);
            } else {
                servo2.setPower(-0.9);
                servo1.setPower(0.9);
            }


        }

    }


}



