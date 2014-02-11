/*
 * The launch component is composed of a motor and two buttons
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author milo
 */
public class LaunchComponent implements RobotComponent {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    private Victor launcher;
    private Joystick launchStick;
    private JoystickButton launchButt;
    private JoystickButton retractButt;
    
    public void robotInit() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        launcher = new Victor(2);
        launchStick = new Joystick(2);
        launchButt = new JoystickButton(launchStick, 1);
    }

    public void autonomousPeriodic() {
    }

    public void teleopPeriodic() {
        
        if (launchButt.get() == true){
           launcher.set(1);
           Timer.delay(1);
           launcher.set(-1);
        }
        else {
           launcher.set(0);
        }
        
    }

    public void testPeriodic() {
    }

    public void disabledPeriodic() {
    }

    public void autonomousInit() {
        
    }

    public void disabledInit() {
        
    }

    public void teleopInit() {
        
    }

}
