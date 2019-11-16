/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  /**
     * Drivetrain Motor CAN Ids
     */
    public static final int FRONT_LEFT_MOTOR = 2;
    public static final int FRONT_RIGHT_MOTOR = 3;
    public static final int BACK_LEFT_MOTOR = 4;
    public static final int BACK_RIGHT_MOTOR = 1;

    /**
     * Aux Motor CAN Ids
     */
    public static final int LIFTER_MOTOR = 12;
    public static final int CAM_MOTOR = 23;
    public static final int ARTICULATOR_MOTOR = 25;
    public static final int GRABBER_MOTOR = 21;
}
