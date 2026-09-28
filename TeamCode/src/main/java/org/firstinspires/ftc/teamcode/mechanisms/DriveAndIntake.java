package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class DriveAndIntake extends OpMode {
    MechanumDrive drive = new MechanumDrive();
    IntakeSpin intake = new IntakeSpin();

    double forward, strafe, rotate;

    @Override
    public void init() {
        drive.init(hardwareMap);
        intake.init(hardwareMap);
    }

    @Override
    public void loop() {
        forward = gamepad1.left_stick_y;
        strafe = gamepad1.left_stick_x;
        rotate = gamepad1.right_stick_x;

        if(gamepad1.a){
            intake.intake(1.0);
        } else if(gamepad1.b) {
            intake.intake(-1.0);//outtake
        } else {
            intake.intake(0.0);//not moving
        }


    }
}
