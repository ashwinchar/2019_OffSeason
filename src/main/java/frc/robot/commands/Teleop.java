package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Teleop extends CommandGroup 
{
    public Teleop(DriveTrain driveTrain/*, Grabber grabber, Lifter lifter*/)
    {
		super.addParallel(new TeleDrive(driveTrain, Robot.m_oi.controller0, Robot.m_oi.controller1));
        
        /*
        super.addParallel(new UseGrabber(Robot.oi.controller1, grabber));
        super.addParallel(new UseLifter(Robot.oi.controller1, lifter));
        */
    }
}