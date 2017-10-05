// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc4905.MotionProfiling.subsystems;

import org.usfirst.frc4905.MotionProfiling.RobotMap;
import org.usfirst.frc4905.MotionProfiling.commands.*;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class DriveTrain extends Subsystem {

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final CANTalon frontLeft = RobotMap.driveTrainFrontLeft;
    private final CANTalon frontRight = RobotMap.driveTrainFrontRight;
    private final CANTalon backLeft = RobotMap.driveTrainBackLeft;
    private final CANTalon backRight = RobotMap.driveTrainBackRight;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	// Encoder PID controller variables
	double EncoderKp = 0.0;
	double EncoderKi = 0.0;
	double EncoderKd = 0.0;
	double EncoderKf = 0.0;
	double EncoderOutputMax = 1.0;
	double EncoderTolerance = 0.1;
	double m_encoderPIDOutput = 0.0;
	ResetEncoderPositions m_resetEncoderPositions = new ResetEncoderPositions();
	
	public DriveTrain(){
		setCommonMotorParameters(backLeft);
		setCommonMotorParameters(backRight);
		setCommonMotorParameters(frontLeft);
		setCommonMotorParameters(frontRight);
	}
	
	private class ResetEncoderPositions{
		double backLeft;
		double backRight;
		double frontRight;
		double frontLeft;
	}
	
	public double getEncoderPIDOutput() {
		return m_encoderPIDOutput;
	}
	
	public void setAllDriveControllers(double value) {
		
		backLeft.set(value);
		backRight.set(value);
		frontLeft.set(value);
		frontRight.set(value);
		
	}
	
	public double getVelocity() {
		return backLeft.getSpeed();
		
	}
	
	public double getEncoderPosition() {
		return backLeft.getPosition();
	}
	
	private void resetEncoderPosition(){
		m_resetEncoderPositions.backLeft = backLeft.get();
		m_resetEncoderPositions.backRight = backRight.get();
		m_resetEncoderPositions.frontRight = frontRight.get();
		m_resetEncoderPositions.frontLeft = frontLeft.get();
	}
	
	private PIDController m_velocityPID;
	
	public PIDController getDeltaPositionPIDController() {
		return m_velocityPID;
	}
	
	private class DeltaPositionPIDin implements PIDSource {

		@Override
		public void setPIDSourceType(PIDSourceType pidSource) {

		}

		@Override
		public PIDSourceType getPIDSourceType() {
			return PIDSourceType.kDisplacement;
		}

		@Override
		public double pidGet() {
			return getEncoderPosition();
		}

	}
	private double m_velocityPIDOutput;
	public double getDeltaPositionPIDOutput() {return m_velocityPIDOutput;}

	private class DeltaPositionPIDout implements PIDOutput {

		@Override
		public void pidWrite(double output) {
			m_velocityPIDOutput = output;
		}

	}
	private double m_velocityKp = 0.0;
	private double m_velocityKi = 0.0;
	private double m_velocityKd = 0.0;
	private double m_velocityKf = 0.0;
	private double m_velocityTolerance = 0.1; 
	
	public void initializeDeltaPositionPID() {
		DeltaPositionPIDin velocityPIDin = new DeltaPositionPIDin();
		DeltaPositionPIDout velocityPIDout = new DeltaPositionPIDout();
		
		m_velocityPID = new PIDController(m_velocityKp, m_velocityKi, m_velocityKd, m_velocityKf, velocityPIDin,
				velocityPIDout);
		
		m_velocityPID.setAbsoluteTolerance(m_velocityTolerance);
		LiveWindow.addActuator("DriveTrain", "DeltaPositionPID", m_velocityPID);
	}

	public void setPositionSetpoint(double velocitySetpoint) {
		m_velocityPID.setSetpoint(velocitySetpoint);
		m_velocityPID.enable();
	}

	public boolean isDoneDeltaPositionPID() {
		return m_velocityPID.onTarget();
	}

	public void stopDeltaPositionPID() {
		m_velocityPID.disable();

	}
	
	// Encoder PID controller
	private PIDController m_moveWithEncoderPID;

	public PIDController getEncoderPIDcontroller() {
		return m_moveWithEncoderPID;
	}

	private class EncoderPIDin implements PIDSource {

		@Override
		public void setPIDSourceType(PIDSourceType pidSource) {

		}

		@Override
		public PIDSourceType getPIDSourceType() {
			return PIDSourceType.kDisplacement;
		}

		@Override
		public double pidGet() {
			return getVelocity();
		}

	}

	private class EncoderPIDout implements PIDOutput {

		@Override
		public void pidWrite(double output) {
			m_encoderPIDOutput = output;
		}

	}

	public void initializeEncoderPID() {
		EncoderPIDin encoderPIDin = new EncoderPIDin();
		EncoderPIDout encoderPIDout = new EncoderPIDout();
		m_moveWithEncoderPID = new PIDController(EncoderKp, EncoderKi, EncoderKd, EncoderKf, encoderPIDin,
				encoderPIDout);
		m_moveWithEncoderPID.setOutputRange(-EncoderOutputMax, EncoderOutputMax);
		m_moveWithEncoderPID.setAbsoluteTolerance(EncoderTolerance);
		LiveWindow.addActuator("DriveTrain", "EncoderPID", m_moveWithEncoderPID);
		resetEncoderPosition();
	}

	public void moveToEncoderRevolutions(double revolutionsToMove) {
		m_moveWithEncoderPID.setSetpoint(revolutionsToMove);
		m_moveWithEncoderPID.enable();
	}

	public boolean isDoneMovingToEncoderRevolutions() {
		return m_moveWithEncoderPID.onTarget();
	}

	public void stopMovingToEncoderRevolutions() {
		m_moveWithEncoderPID.disable();

	}
	
	private void setCommonMotorParameters(CANTalon motorController) {
		motorController.reverseSensor(false);
		motorController.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		motorController.setPosition(0);
		motorController.configNominalOutputVoltage(0, 0);
		motorController.configPeakOutputVoltage(12.0, -12.0);
		motorController.enableBrakeMode(true);
		motorController.setVoltageRampRate(48);
		motorController.changeControlMode(TalonControlMode.PercentVbus);
		motorController.setProfile(0);
		motorController.set(0);
	}
	
	public void setControlModeSpeed() {
		setNormalPIDParameters();
		backLeft.changeControlMode(TalonControlMode.Speed);
		backRight.changeControlMode(TalonControlMode.Speed);
		frontRight.changeControlMode(TalonControlMode.Speed);
		frontLeft.changeControlMode(TalonControlMode.Speed);
	}
	public void setControlModePercentVbus() {
		setNormalPIDParameters();
		backLeft.changeControlMode(TalonControlMode.PercentVbus);
		backRight.changeControlMode(TalonControlMode.PercentVbus);
		frontRight.changeControlMode(TalonControlMode.PercentVbus);
		frontLeft.changeControlMode(TalonControlMode.PercentVbus);
	}
	
	private void setNormalPIDParameters() {
		//                 P    I  D  F                       Izone RampRate Profile
		backLeft.setPID(   0, 0, 0, 1023.0*600.0/4096.0/890, 0,  0,       0);
		backRight.setPID(  0, 0, 0, 1023.0*600.0/4096.0/890, 0,  0,       0);
		frontLeft.setPID(  0, 0, 0, 1023.0*600.0/4096.0/890, 0,  0,       0);
		frontRight.setPID( 0, 0, 0, 1023.0*600.0/4096.0/890, 0,  0,       0);
		// Page 88 in CTR Documentation for f 
		
	}

	public void initDefaultCommand() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
