package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.util.MiniPID;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {

	TalonSRX rightFront, rightBack, leftFront, leftBack;

	AHRS ahrs;

	private double targetAngle;
	MiniPID miniPID;
	double currentAngle;

	public DriveTrain() {
		rightFront = new TalonSRX(RobotMap.FRONT_RIGHT_MOTOR);
		rightBack = new TalonSRX(RobotMap.BACK_RIGHT_MOTOR);
		leftFront = new TalonSRX(RobotMap.FRONT_LEFT_MOTOR);
		leftBack = new TalonSRX(RobotMap.BACK_LEFT_MOTOR);

		rightBack.follow(rightFront);
		leftBack.follow(leftFront);

		ahrs = new AHRS(Port.kMXP);
		ahrs.zeroYaw();


		targetAngle = 0;
		miniPID = new MiniPID(.05, .001, .20);
		miniPID.setOutputLimits(.5);
	}

	public void resetPID() {
		miniPID.reset();
	}

	public void resetAHRS() {
		ahrs.reset();
	}

	public void directDrive(double left, double right) {
		rightFront.set(ControlMode.PercentOutput, -right);
		leftFront.set(ControlMode.PercentOutput, left);
	}

	public void autoTurn() {
		double output = miniPID.getOutput(getAngleCCW(), targetAngle);
		directDrive(-output, output);
	}

	public void driveStraight(double speed) {
		double turnComp = miniPID.getOutput(getAngleCCW(), targetAngle);
		directDrive(speed - turnComp, speed + turnComp);
	}

	/*
	 * public void driveSlow() { rightFront.configMotionAcceleration(arg0, 0); }
	 */

	public void initDefaultCommand() {
	}

	public double getTargetAngle() {
		return targetAngle;
	}
	
	/**
	 * 
	 * @return 1 for right, -1 for left
	 */
	public int getSwitchSide()
	{
		
		if(DriverStation.getInstance().getGameSpecificMessage().charAt(0) == 'R')
			return 1;
		return -1;
	}
	
	/**
	 * 
	 * @return 1 for right, -1 for left
	 */
	public int getScaleSide()
	{
		if(DriverStation.getInstance().getGameSpecificMessage().charAt(1) == 'R')

			return 1;
		return -1;
	}

	public void setTargetAngle(double targetAngle) {

		this.targetAngle = targetAngle;

	}

	public double getAngleCCW() {
		return -ahrs.getAngle();
	}
}
