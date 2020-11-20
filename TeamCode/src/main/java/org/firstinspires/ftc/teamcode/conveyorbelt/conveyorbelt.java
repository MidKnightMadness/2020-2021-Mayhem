package org.firstinspires.ftc.teamcode.conveyorbelt;


import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@TeleOp

public class conveyorbelt extends LinearOpMode {
    private DcMotor ahaha;
    // todo: write your code here
    public void runOpMode() {
        ahaha = hardwareMap.get(DcMotor.class, "ahaha");
        telemetry.addData("Status", "Press Play!");
        telemetry.update();
        double power = 0.0;
        boolean powered = false;
        int buttonCounter = 0;

        waitForStart();

        while (opModeIsActive()) {
            if (powered) {
                ahaha.setPower(.4);
            }
            else{
                ahaha.setPower(0.0);
            }

            if(gamepad1.x && buttonCounter == 0){
                buttonCounter = 10000;
                powered = !powered;

            }
            if(buttonCounter > 0){
                buttonCounter = buttonCounter-1;
            }
            telemetry.addData("Status", buttonCounter);
            telemetry.update();
        }
    }
}