package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.ADXL345_I2C;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.templates.Robot;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author milo
 */

public class DriveComponent implements RobotComponent {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    //private RobotDrive drive;
    private CANJaguar fljag;  //Front Left Wheel Jag
    private CANJaguar rljag; //Rear Left Wheel Jag
    private CANJaguar frjag; //Front Right Wheel Jag
    private CANJaguar rrjag; //Rear Right Wheel Jag
    private ADXL345_I2C accel; 
    private double accelerationX;
    private double accelerationY;
    private double accelerationZ;
    ADXL345_I2C.AllAxes accelerations;

    public void initialize() {
        
        try {  
            fljag = new CANJaguar(2); //Front Left Wheel Jag
            rljag = new CANJaguar(3); //Rear Left Wheel Jag
            frjag = new CANJaguar(4); //Front Right Wheel Jag
            rrjag = new CANJaguar(5); //Rear Right Wheel Jag
            //drive = new RobotDrive(rljag, rrjag);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
        accel = new ADXL345_I2C(1, ADXL345_I2C.DataFormat_Range.k2G);
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void autonomousPeriodic() {
    }

    public void teleopPeriodic() {
            accelerationZ = accel.getAcceleration(ADXL345_I2C.Axes.kZ);
            accelerationX = accel.getAcceleration(ADXL345_I2C.Axes.kX);
            accelerationY = accel.getAcceleration(ADXL345_I2C.Axes.kY);
            System.out.println("Z is " + accelerationZ);
            Timer.delay(.25);
            System.out.println("X is " + accelerationX);
            Timer.delay(.25);
            System.out.println("Y is " + accelerationY);
            Timer.delay(.25);
            
            fljag.setX(Robot.DRIVE_JOYSTICK.getY());
            rljag.setX(Robot.DRIVE_JOYSTICK.getY());
            frjag.setX(Robot.DRIVE_JOYSTICK.getThrottle());
            rrjag.setX(Robot.DRIVE_JOYSTICK.getThrottle());
            System.out.println("Leonard made me do it!!");
    }

    public void testPeriodic() {
    }

    public void disabledPeriodic() {
    }

    /**
     *
     */
//    @Override
    public void autonomousInit() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
    public void disabledInit() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
    public void teleopInit() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
