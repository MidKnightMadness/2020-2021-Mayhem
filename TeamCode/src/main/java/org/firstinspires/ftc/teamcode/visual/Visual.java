package org.firstinspires.ftc.teamcode.visual;

import android.graphics.drawable.GradientDrawable;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.teamcode.common.Assembly;

public abstract class Visual extends Assembly {

    public static void init(HardwareMap hardwareMap, Telemetry telemetry) {
    }

    public abstract VectorF getPosition();
    public abstract Orientation getRotation();

    public enum STARTERSTACK {A,B,C};
    public abstract STARTERSTACK getStartStack();
    public abstract double getRingOffset();

    public abstract void update();
}