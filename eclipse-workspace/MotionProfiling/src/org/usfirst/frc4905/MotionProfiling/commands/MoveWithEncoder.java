// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc4905.MotionProfiling.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import kinematics.KinematicsSimpler;
import kinematics.KinematicsSimpler.*;

import org.usfirst.frc4905.MotionProfiling.Robot;

/**
 *
 */
public class MoveWithEncoder extends Command {

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
	// org.usfirst.frc.team4905.robot.Robot
	Path m_path;
	double m_initialTimeStamp;
	double m_currentTimeStamp;
	double deltaTime;
	double m_velocityToMotorOutputRatio;
	double m_accelerationToMotorOutputRatio;
	double m_PIDOut;
	double m_positionToEncoderRevolutionsRatio = 5.0;

	KinematicsSimpler.TrajectoryPoint trajectoryPoint = Robot.kinematicsSimpler.new TrajectoryPoint();

	public MoveWithEncoder() {

	}
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR

	public MoveWithEncoder(Path path) {
		m_path = path;
		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		m_velocityToMotorOutputRatio = 1.0 / m_path.getMaxVelocity();
		m_accelerationToMotorOutputRatio = 1.0 / m_path.getMaxAcceleration();
		m_initialTimeStamp = Timer.getFPGATimestamp();
		Robot.driveTrain.initializeEncoderPID();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		m_currentTimeStamp = Timer.getFPGATimestamp();
		deltaTime = m_currentTimeStamp - m_initialTimeStamp;
		trajectoryPoint = Robot.kinematicsSimpler.getTrajectoryPoint(m_path.getTrajectoryVector(), deltaTime);
		Robot.driveTrain.moveToEncoderRevolutions(trajectoryPoint.m_position * m_positionToEncoderRevolutionsRatio);
		m_PIDOut = Robot.driveTrain.getEncoderPIDOutput();

		Robot.driveTrain.setAllDriveControllers(trajectoryPoint.m_currentVelocity * m_velocityToMotorOutputRatio
				+ trajectoryPoint.m_acceleration * m_accelerationToMotorOutputRatio + m_PIDOut);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return trajectoryPoint.m_timestamp == m_path.getTrajectoryVector()
				.get(m_path.getTrajectoryVector().size() - 1).m_timestamp
				&& Robot.driveTrain.isDoneMovingToEncoderRevolutions();
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
