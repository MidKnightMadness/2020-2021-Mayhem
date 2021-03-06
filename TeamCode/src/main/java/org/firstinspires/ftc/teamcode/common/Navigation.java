package org.firstinspires.ftc.teamcode.common;

import org.firstinspires.ftc.teamcode.common.Assembly;
import org.firstinspires.ftc.teamcode.common.Position;
import org.firstinspires.ftc.teamcode.chassis.Drive;


public class Navigation extends Assembly {
    private Drive drive;
   // private Visual visual;

    public Navigation(Drive drive) {
     //   this.visual = visual;
        this.drive = drive;
    }

    @Override
    public void init() {}

    public void update() {
       // if(visual == null)
          //  return;

       // Position visualPosition = visual.getPosition();
        Position drivePosition = drive.getPosition();

      //  if (visualPosition != null) {
        //    if (Math.abs(visualPosition.getX().toMillimeters() - drivePosition.getX().toMillimeters()) > 4 ||
               //     Math.abs(visualPosition.getY().toMillimeters() - drivePosition.getY().toMillimeters()) > 4)
             //   drive.resetPosition(visualPosition);
      //  }
    }

    public Position getPosition() {
        return drive.getPosition();
    }
}