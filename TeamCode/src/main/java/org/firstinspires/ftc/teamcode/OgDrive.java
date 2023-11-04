package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;


public class OgDrive {
    DcMotor BackLeft;
    DcMotor BackRight;
    DcMotor FrontLeft;
    DcMotor FrontRight;

    public OgDrive(HardwareMap hardwareMap) {

        BackLeft = hardwareMap.get(DcMotor.class, "leftBack");
        BackRight = hardwareMap.get(DcMotor.class, "rightBack");
        FrontLeft = hardwareMap.get(DcMotor.class, "leftFront");
        FrontRight = hardwareMap.get(DcMotor.class, "rightFront");


        // init servo hardware
        // init drive hardware and variables
        BackLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BackRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FrontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FrontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BackRight.setDirection(DcMotorSimple.Direction.REVERSE);
    }
    public void og_drive_code(Gamepad gamepad1, Telemetry telemetry) {

        double Scale_Factor_of_Drive;

        if (gamepad1.right_bumper) {
            Scale_Factor_of_Drive = 1;
        } else {
            Scale_Factor_of_Drive = 0.55;
        }
        // drive with joysticks
        BackLeft.setPower(-0.8 * Scale_Factor_of_Drive * gamepad1.right_stick_x - 0.8 * Scale_Factor_of_Drive * (gamepad1.left_stick_x + gamepad1.left_stick_y));
        BackRight.setPower(0.8 * Scale_Factor_of_Drive * gamepad1.right_stick_x - -0.8 * Scale_Factor_of_Drive * (gamepad1.left_stick_x - gamepad1.left_stick_y));
        FrontLeft.setPower(-0.8 * Scale_Factor_of_Drive * gamepad1.right_stick_x - -0.8 * Scale_Factor_of_Drive * (gamepad1.left_stick_x - gamepad1.left_stick_y));
        FrontRight.setPower(-0.8 * Scale_Factor_of_Drive * gamepad1.right_stick_x - -0.8 * Scale_Factor_of_Drive * (gamepad1.left_stick_x + gamepad1.left_stick_y));
        telemetry.addData("FL Motor", FrontLeft.getPower());
        telemetry.addData("FR Motor", FrontRight.getPower());
        telemetry.addData("BL Motor", BackLeft.getPower());
        telemetry.addData("BR Motor", BackRight.getPower());

    }
}
