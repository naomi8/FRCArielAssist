/*----------------------------------------------------------------------------*/
/* class THUG LYFE ACTIVATED:).
 * Have fun!
 * Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Timer;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends SimpleRobot {
    RobotDrive drive = new RobotDrive(1,2);
    //left channel = 1, right channel = 2
    Joystick leftStick = new Joystick(1);
    Joystick rightStick = new Joystick(1);
    /*
     * This function is called once each time th    e robot enters autonomous mode.
     */
    public RobotTemplate() {
        getWatchdog().setEnabled(false);
    }
    
    public void autonomous() {
        getWatchdog().setEnabled(true);
        getWatchdog().setExpiration(0.5);
        drive.drive(1,0);
        Timer.delay(2);
        drive.drive(0,0);
        for (int i = 0; i < 4; i++) {
            drive.drive(0.5,0.0);
            Timer.delay(2.0);
            drive.drive(0.0,0.75);
        }
        drive.drive(0.0,0.0);
   }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
            while (true && isOperatorControl() && isEnabled())
            {
                drive.tankDrive(leftStick,rightStick);
                drive.setLeftRightMotorOutputs(.5,.5);
                Timer.delay(0.005);
            }
    }
    
    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test() {
    
    }
    
}
    
