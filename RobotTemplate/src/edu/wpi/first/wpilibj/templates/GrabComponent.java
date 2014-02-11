/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import java.lang.Exception;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 *
 * @author 1SRJ
 */
public class GrabComponent implements RobotComponent {

//private CANJaguar grabMotor;
//private Joystick armStick;
    private final Joystick armStick = new Joystick(2);
    private int releaseButton = 2;
    private int grabButton = 3;
    private final Victor grabMotor = new Victor(1);

    public void robotInit() {
        grabMotor.set(armStick.getY());
    }

    public void teleopInit() {

    }

    public void teleopPeriodic() {
        boolean grab = armStick.getRawButton(grabButton);
        boolean release = armStick.getRawButton(releaseButton);
        if(grab){
            grabMotor.set(1.0);
        }else if(release){
            grabMotor.set(-1.0);
        }else{
            grabMotor.set(0.0);
        } 
    }

    public void autonomousInit() {
        Victor grabMotor = new Victor(1);
    }

    public void autonomousPeriodic() {
        grabMotor.set(armStick.getY());
    }

    public void disabledInit() {
    }

    public void disabledPeriodic() {
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initialize() {
       // throw new java.lang.UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
