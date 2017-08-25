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
	
	private class ResetEncoderPositions{
		double backLeft;
		double backRight;
		double frontRight;
		double frontLeft;
	}
	public double getEncoderPIDOutput() {
		return m_encoderPIDOutput;
	}
	public void setDriveControllers(double value) {

	}

	private double getEncoderPosition() {
		return 0.0;
	}
	private void resetEncoderPosition(){
		m_resetEncoderPositions.backLeft = 0.0;
		m_resetEncoderPositions.backRight = 0.0;
		m_resetEncoderPositions.frontRight = 0.0;
		m_resetEncoderPositions.frontLeft = 0.0;
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
			return getEncoderPosition();
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

	public void initDefaultCommand() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
