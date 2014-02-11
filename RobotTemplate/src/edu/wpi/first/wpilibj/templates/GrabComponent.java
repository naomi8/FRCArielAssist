/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.Robot;

/**
 *
 * @author 1SRJ
 */

public class GrabComponent implements RobotComponent {

    //private CANJaguar grabMotor;
    //private Joystick armStick;
    //private final Joystick armStick = new Joystick(2);
    private final JoystickButton releaseButton = new JoystickButton(Robot.ARM_STICK, 2);
    private Victor grabMotor;

    public void initialize() {
        grabMotor = new Victor(1);
    }

    public void teleopInit() {
    }

    public void teleopPeriodic() {
        grabMotor.set(Robot.ARM_JOYSTICK.getY());
    }

    public void autonomousInit() {
    }

    public void autonomousPeriodic() {
    }

    public void disabledInit() {
    }

    public void disabledPeriodic() {
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}
