package org.firstinspires.ftc.robotcontroller;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="TeamBadCode", group="TeamBADCODE")
public class TeamBadCode extends OpMode {

    DcMotor leftFront;
    DcMotor leftBack;
    DcMotor rightFront;  
    DcMotor rightBack;
    Servo leftClaw;
    Servo rightClaw;

    public static final Gamepad.Type controller = Gamepad.Type.XBOX_360;
    String holdController = controller.name();

    @Override
    public void init() {
        holdController.hashCode();
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        rightBack = hardwareMap.get(DcMotor.class, "rightBack");
        rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftClaw.setPosition(0.5);
        rightClaw.setPosition(0.5);
    }

    public void loop() {
        movement();
        openOrCloseClaws();
    }

    /*  Use moveToDirection() for setting power without needing the whole boilerplate code
        Just use -1 for backwards movement, 0 for no movement, and 1 for forward movement   */
    public void moveToDirection(double power, int motor0, int motor1, int motor2, int motor3){
        leftFront.setPower(power * motor0);
        leftBack.setPower(power * motor1);
        rightFront.setPower(power * motor2);
        rightBack.setPower(power * motor3);
    }
    /* Use to turn off all motors */
    public void turnMotorsOff(){
        leftFront.setPower(0);
        leftBack.setPower(0);
        rightFront.setPower(0);
        rightBack.setPower(0);
    }
    public void openOrCloseClaws(){
        while(gamepad1.left_bumper){
            leftClaw.setPosition(leftClaw.getPosition() - 0.01);
            rightClaw.setPosition(rightClaw.getPosition() + 0.01);
        }
        while(gamepad1.right_bumper){
            leftClaw.setPosition(leftClaw.getPosition() + 0.01);
            rightClaw.setPosition(rightClaw.getPosition() - 0.01);
        }
    }
    public void movement(){
        if(gamepad1.left_stick_y > 0){
            moveToDirection(gamepad1.left_stick_y, 1, 1, 1, 1);
        } if (gamepad1.left_stick_y < 0) {
            moveToDirection(gamepad1.left_stick_y, 1, 1, 1, 1);
        } if (gamepad1.left_stick_x > 0) {
            moveToDirection(gamepad1.left_stick_y, 1, -1, 1, -1);
        } if (gamepad1.left_stick_x < 0) {
            moveToDirection(gamepad1.left_stick_y, -1, 1, -1, 1);
        }
        turnMotorsOff();
    }




}
