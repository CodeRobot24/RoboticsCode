//This is Origianl code, not the one we did on 11/30/2022
//I still have to get that one from the hub sadly, I forgot...
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous(name="Auto_Test_Color_2022", group="Training")
//@Disabled
public class Auto_Test_Color_2022 extends LinearOpMode {

    /* Declare OpMode members. */
    MaristBaseRobot2022_Quad robot   = new MaristBaseRobot2022_Quad();   
    private ElapsedTime runtime = new ElapsedTime();
    
    // Variables to control Speed
    double velocity = 0.5; // Default velocity


    @Override
    public void runOpMode() {

        /*
         * Initialize the drive system variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);
        
        robot.leftHand.setPosition(1.0);
        robot.rightHand.setPosition(0.2);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        
        // Perform the steps of Autonomous One Step at a Time.
        // MARIST: Add Code here!
        // Available Calls: forward(inches),delay(seconds),right(degrees),left(degrees)
        // robot.leftHand.setPosition(), robot.rightHand.setPosition()
        
        // Engineering Java Calls:
        // robot.moveDistance(inches, speed) moves
        // robot.turnAngle(degrees, speed) turns
        // robot.strafeInches(inches, speed) moves sideways
        
        robot.moveDistance(-7, 0.2);
        
        // Test Color Sensor
        float hue = robot.getHue();
        
        double waitTime = 2;
        
        double count = 2;
        
        double total = 0;
        
        int location;
        
        runtime.reset();
        
        while (opModeIsActive() && (runtime.seconds() < waitTime)) {
            hue = robot.getHue();
            total += hue;
            count++;
            double average = total/count;
            telemetry.addData("Average Hue", hue);
            telemetry.update();
        }
        
        double finalAverage = total / count;
        
        telemetry.addData("Final Hue", finalAverage);
        telemetry.update();
        
        if (finalAverage < 50) {
            location = 1;
            telemetry.addData("Location", location);
            telemetry.update();
            robot.moveDistance(-7, 0.2);
            robot.moveDistance(4, 0.2);
            //-25 was original
            robot.strafeInches(25, 0.2);
            
        }
        else if (finalAverage > 50 && finalAverage < 150) {
            location = 3;
            telemetry.addData("Location", location);
            telemetry.update();
            robot.moveDistance(-7, 0.2);
            robot.moveDistance(4, 0.2);
            robot.strafeInches(-25, 0.2);
        }
        else {
            location = 2;
            telemetry.addData("Location", location);
            telemetry.update();
            robot.moveDistance(-4, 0.2);
            robot.moveDistance(1, 0.2);
        }
        
        // Make Decision - Run Functions
        
        // Display output
        
        //telemetry.addData("Path", "Complete");
        //telemetry.update();
        //sleep(1000);
    }

    // Functions for REACH 2019 based on Python Turtles
    public void forward(double inches)
    {
        robot.driveStraightInches(velocity, inches, 10);
    }
    
    public void right(double degrees)
    {
        robot.pointTurnDegrees(velocity, degrees, 10);
    }
    
    public void left(double degrees)
    {
        degrees = degrees * -1;
        robot.pointTurnDegrees(velocity, degrees, 10);
    }
    
    public void speed(int speed)
    {
        double newSpeed = (double)speed / 10.0;
        velocity = newSpeed;
    }
    
    // Sample Delay Code
    public void delay(double t) { // Imitates the Arduino delay function
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < t)) {
            //telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            //telemetry.update();
        }
    }

    // REACH: Add Functions Here
    
    
        
    
    

}
