/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.image.NIVisionException;
import edu.wpi.first.wpilibj.image.ColorImage;
/**
 *
 * @author milo
 */
public class CameraComponent implements RobotComponent {
        
    AxisCamera camera; //Camera
    private int imageWidth = 0;//width of image
    DriverStation dS = DriverStation.getInstance();
    ColorImage image;
        
    public void robotInit() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        camera = AxisCamera.getInstance("192.168.0.90");
        camera.writeMaxFPS(5);
        camera.writeResolution(AxisCamera.ResolutionT.k160x120);
        camera.writeCompression(20);
        camera.writeBrightness(0);
        System.out.println("Camera Activated");
    }

    public void autonomousPeriodic() {
        if (camera.getBrightness() == 100) {
            //shoot!
         }
    }

    public void teleopPeriodic() {
         //getting image from camera below
         
        //getWatchdog().setEnabled(false);
         if (camera.freshImage()){
         try {
         image = camera.getImage();
         image.free();
         System.out.println(camera.getImage());
         } catch (AxisCameraException ex) {
         ex.printStackTrace();
         } catch (NIVisionException ex) {
         ex.printStackTrace();
         }
       }   
         
         camera.writeRotation(AxisCamera.RotationT.k180);
         System.out.println(camera.getBrightness());
         DriverStationLCD.getInstance().updateLCD();
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
