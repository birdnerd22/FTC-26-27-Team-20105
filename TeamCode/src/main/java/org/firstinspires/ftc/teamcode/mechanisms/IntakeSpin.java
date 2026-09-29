package org.firstinspires.ftc.teamcode.mechanisms;

import static com.qualcomm.robotcore.hardware.DcMotor.RunMode.RUN_USING_ENCODER;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

public class IntakeSpin {
    private DcMotor intakeMotor;
    private IMU imu;

    public void init(HardwareMap hwMap){
        intakeMotor = hwMap.get(DcMotor.class, "intake");//add intake motor in setup
        intakeMotor.setMode(RUN_USING_ENCODER);
        imu = hwMap.get(IMU.class, "imu");
        RevHubOrientationOnRobot RevOrientation = new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD);//change if design changes this
        //This might have to change but hopefully not
        imu.initialize(new IMU.Parameters(RevOrientation));

    }

    public void intake(double power){//set 1.0 for intake and -1.0 for outtake(I think)
        intakeMotor.setPower(power);
    }
}
