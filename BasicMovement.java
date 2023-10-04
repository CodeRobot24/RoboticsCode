package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

//import com.qualcomm.robotcore.hardware.HardwareDevice;
//import com.qualcomm.robotcore.hardware.ServoController.PwmStatus;

@TeleOp(name="BasicMovement", group="movement")

public class BasicMovement extends OpMode {
    
    final double MAX_POSITION = 1.0;
    final double MIN_POSITION = 0.0;
    
    DcMotor frontLeft;  //0
    DcMotor backLeft;   //1
    DcMotor frontRight; //2
    DcMotor backRight;  //3
    Servo leftHand;
    Servo rightHand;
    
    // public void moveRobot(){
    //     double vertical = 0;
    //     double horizontal = 0;
    //     double pivot = 0;
        
    //     vertical = -gamepad1.left_stick_y;
    //     horizontal = gamepad1.left_stick_y;
    //     pivot = gamepad1.right_stick_x;
        
    //     frontLeft.setPower(pivot + (-vertical + horizontal));
    //     frontRight.setPower(pivot + (-vertical - horizontal));
    //     backLeft.setPower(pivot + (-vertical + horizontal));
    //     backRight.setPower(pivot + (-vertical + horizontal));
    // }
    
    @Override
    public void init(){
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        
        leftHand = hardwareMap.get(Servo.class, "leftHand");
        leftHand.setPosition(0.5);
        
        rightHand = hardwareMap.get(Servo.class, "rightHand");
        rightHand.setPosition(0.5);
        
    }
    public void loop(){
        
        if(gamepad1.left_stick_y > 0.1 || gamepad1.left_stick_y  < -0.1){
            frontLeft.setPower(gamepad1.left_stick_y);
            frontRight.setPower(gamepad1.left_stick_y);
            backLeft.setPower(gamepad1.left_stick_y);
            backRight.setPower(gamepad1.left_stick_y);
        }
        else{
            frontLeft.setPower(0);
            frontRight.setPower(0);
            backLeft.setPower(0);
            backRight.setPower(0);
        }
        if(gamepad1.left_stick_x > 0.5 || gamepad1.left_stick_x  < -0.5){
            frontLeft.setPower(gamepad1.left_stick_x);
            frontRight.setPower(-gamepad1.left_stick_x);
            backLeft.setPower(gamepad1.left_stick_x);
            backRight.setPower(-gamepad1.left_stick_x);
        }
        else{
            frontLeft.setPower(0);
            frontRight.setPower(0);
            backLeft.setPower(0);
            backRight.setPower(0);
        }
        moveArm();
        // if(gamepad1.left_trigger == true && servoArm.getPosition() > MIN_POSITION){
        //     servoArm.setPosition(servoArm.getPosition() - 0.01);
        // }
        // if(gamepad1.right_trigger == true && servoArm.getPosition() < MIN_POSITION){
        //     servoArm.setPosition(servoArm.getPosition() + 0.01);
        // }
        
    }
    
    public void moveArm(){
    if(gamepad1.left_bumper && leftHand.getPosition() > MIN_POSITION){
            leftHand.setPosition(leftHand.getPosition() - 0.05);
            rightHand.setPosition(rightHand.getPosition() + 0.05);
        }
        if(gamepad1.right_bumper && rightHand.getPosition() > MIN_POSITION){
            leftHand.setPosition(leftHand.getPosition() + 0.05);
            rightHand.setPosition(rightHand.getPosition() - 0.05);
        }
    }
    
    
    
    
}
