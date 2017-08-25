// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package kinematics;

import java.util.Vector;

/**
 * The equations described in this class can be found at:
 * http://www.physicsclassroom.com/Class/1DKin/U1L6b.cfm
 */
public class Kinematics {

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	private double m_trajectoryPointInterval = 0.5;

	public class InvalidDimentionException extends Exception {

		private static final long serialVersionUID = 1L;

		public InvalidDimentionException(String message) {
			super(message);
		}
	}

	public class Path extends TrajectoryPaths {

		Vector<Point> setpointVector = new Vector<Point>();
		Vector<Double> setpointMaxVelocityVector = new Vector<Double>();

		Vector<Point> setpointVector2 = new Vector<Point>();
		Vector<Double> setpointMaxVelocityVector2 = new Vector<Double>();

		Vector<Vector<Point>> setpointVectors = new Vector<Vector<Point>>();
		Vector<Vector<Double>> setpointMaxVelocityVectors = new Vector<Vector<Double>>();

		int setPointDimention = 0;
	}

	private class TrajectoryPaths {
		double maxVelocity;
		double maxAcceleration;
		double maxJerk;

		public double getMaxVelocity() {
			return maxVelocity;
		};

		public double getmaxAcceleration() {
			return maxAcceleration;
		};

		Vector<TrajectoryPoint> trajectoryVector = new Vector<TrajectoryPoint>();

		Vector<TrajectoryPoint> trajectoryVector2 = new Vector<TrajectoryPoint>();

		Vector<Vector<TrajectoryPoint>> trajectoryVectors = new Vector<Vector<TrajectoryPoint>>();

		public Vector<TrajectoryPoint> getTrajectoryVector() {
			return trajectoryVector;
		}
	}

	public class TrajectoryPoint {
		public TrajectoryPoint(double currentVelocity, double acceleration, double position, double timestamp) {
			m_currentVelocity = currentVelocity;
			m_acceleration = acceleration;
			m_timestamp = timestamp;
			m_position = position;
		}

		public TrajectoryPoint() {

		}

		public double m_currentVelocity, m_acceleration, m_timestamp, m_position = 0.0;
		/*
		 * public double getm_CurrentVelocity() { return m_currentVelocity; } public
		 * double getm_Acceleration() { return m_acceleration; } public double
		 * getm_Timestamp() { return m_timestamp; }
		 */
	}

	public class Point {
		public Point(double x) {
			m_x = x;
			m_values = new double[1];
			m_values[0] = x;
			m_dim = 1;
		}

		public Point(double x, double y) {
			m_x = x;
			m_y = y;
			m_values = new double[2];
			m_values[0] = x;
			m_values[1] = y;
			m_dim = 2;
		}

		public int getDim() {
			return m_dim;
		}

		public double getm_X() {
			return m_x;
		}

		public double getm_Y() {
			return m_y;
		}

		double startCruisingDeltaTime;
		double endCruisingDeltaTime;
		double endDeltaTime;
		double maxVelocity;

		private double m_x, m_y = 0.0;
		private double[] m_values;
		private int m_dim;

		double vi = 0.0;
		double vf = 0.0;

	}

	/**
	 * Takes a point and tries to add it to the setpoint vector inside of Key
	 * @throws InvalidDimentionException 
	 */
	public void addPointToPath(Path Key, Point point) throws InvalidDimentionException {
			privateAddPointToPath(Key, point, 0);
	}

	/**
	 * Takes a point and tries to add it to the setpoint vector inside of Key. Takes
	 * the max velocity that the user wants and adds it to a max velocity vector
	 * that will be used later on
	 * @throws InvalidDimentionException 
	 */
	public void addPointToPath(Path Key, Point point, double maxVelocity) throws InvalidDimentionException {
			privateAddPointToPath(Key, point, maxVelocity);
	}

	/**
	 * Tries to add a point to the setpoint path inside of Key Throws an exception
	 * if the point is not the same dimension as all the other points inside of the
	 * setpoint vector
	 */
	private void privateAddPointToPath(Path Key, Point point, double maxVelocity) throws InvalidDimentionException {
		// If the dimension of the path vector has not been set yet set it to the
		// dimension of the point
		if (Key.setPointDimention == 0) {
			Key.setPointDimention = point.getDim();
			// If the dimension of the point does not match the dimension of the path vector
			// throw an exception
		} else if (point.getDim() != point.getDim()) {
			String errMessage;
			if (point.getDim() == 1) {
				errMessage = "Point: (" + point.m_x + "," + point.m_y + ") is an invalid dimention.";
			} else {
				errMessage = "Point: (" + point.m_x + ") is an invalid dimention.";
			}
			InvalidDimentionException invalidDimentionException = new InvalidDimentionException(errMessage);
			throw invalidDimentionException;
		}

		if (point.getDim() == 2) {
			splineFitNewPoints(Key);
		}
		Key.setpointVector.add(point);
		Key.setpointMaxVelocityVector.add(maxVelocity);
	}

	/**
	 * This method takes a two dimensional setpoint vector and uses some sort of
	 * spline fitting to create a path from one setpoint to another
	 */
	private void splineFitNewPoints(Path Key) {

	}

	/**
	 * This method takes the setpoint vector and turns it into a trajectory vector
	 * by time parameterizing each setpoint
	 */
	public void createTrajectory(Path Key, double maxVelocity, double maxAcceleration, double maxJerk) {
		Key.maxAcceleration = maxAcceleration;
		Key.maxJerk = maxJerk;
		Key.maxVelocity = maxVelocity;

		/*
		 * If the dimension of the vector is 2 numerically integrate the path to create
		 * two separate 1 dimensional paths Else add the another layer of vector onto
		 * this setpoint vector to keep everything uniform later on
		 */
		if (Key.setPointDimention == 2) {
			NumericallyIntegratePath(Key);
		} else {
			Key.setpointVectors.add(Key.setpointVector);
			Key.setpointMaxVelocityVectors.add(Key.setpointMaxVelocityVector);
		}
		// For every setpoint vector in the vector of setpoint vectors
		for (int i = 0; i < Key.setpointVectors.size(); i++) {
			Vector<Point> setpointVector = Key.setpointVectors.get(i);
			Vector<Double> setpointMaxVelocityVector = Key.setpointMaxVelocityVectors.get(i);

			// Final velocity and Initial Velocity are commonly referred to as vi and vf
			// respectively
			getFinalVelocityAndInitialVelocity(setpointVector, setpointMaxVelocityVector, Key);

			// For every point in this setpoint vector

			for (int i1 = 0; i1 < setpointVector.size(); i1++) {
				Point setpoint = setpointVector.get(i1);

				// Allows the user to customize the maximum velocity that they want for a
				// specific move in their path

				double nextMaxVelocity = 0.0;
				try {
					nextMaxVelocity = setpointMaxVelocityVector.get(i1);
				} catch (ArrayIndexOutOfBoundsException e) {

				}
				if (nextMaxVelocity != 0.0 && nextMaxVelocity <= maxVelocity) {
					setpoint.maxVelocity = nextMaxVelocity;
				} else {
					setpoint.maxVelocity = maxVelocity;
				}
				/*
				 * This equation pretend that the initial velocity and the final velocities are
				 * both 0, calculates the total distance covered if their was no velocity limit
				 * and then cuts that number in half in order to find the distance traveled at
				 * the peek of velocity before the trajectory starts to decelerate
				 */
				Point lastSetpoint = new Point(0, 0);
				try {
					lastSetpoint = setpointVector.get(i1 - 1);
				} catch (ArrayIndexOutOfBoundsException a) {

				}
				double theoreticalMaxVelocityDistance = ((Math.pow(setpoint.vi, 2) / (2 * Key.maxAcceleration)
						+ Math.pow(setpoint.vf, 2) / (2 * Key.maxAcceleration)
						+ Math.abs(setpoint.m_x - lastSetpoint.m_x))) / 2;
				// This equation is the kinematic equation involving vf, vi, acceleration, and
				// displacement and has been rearranged to solve for vf

				double theoreticalMaxVelocity = Math
						.sqrt(Math.pow(setpoint.vi, 2) + 2 * Key.maxAcceleration * theoreticalMaxVelocityDistance);

				/*
				 * This equation is the kinematic equation involving vf, vi, acceleration and
				 * time and has been rearranged to solve for the time in which it will take to
				 * reach the theoretical max velocity
				 */
				double halfWayTime = (theoreticalMaxVelocity - setpoint.vi) / Key.maxAcceleration;

				/*
				 * If the theoretical max velocity is impossible to reach due to design
				 * constraints or user constraints that limit max velocity find when the max
				 * velocity will be reached and how long it will stay or "cruise" at that
				 * velocity before it needs to decelerate down to reach the vf
				 * 
				 * Else set the distance cruising to 0 and all the times associated with
				 * cruising to the halfway time which is when the maximum theoretical velocity
				 * will be reached and pretend that you are cruising for 0 seconds
				 */

				if (theoreticalMaxVelocity > Key.maxVelocity) {
					double distanceAccelerating = getDistanceTraveledWhileAccelerating(setpoint.vi,
							setpoint.maxVelocity, Key.maxAcceleration);

					setpoint.startCruisingDeltaTime = (setpoint.maxVelocity - setpoint.vi) / Key.maxAcceleration;

					double endCruisingDeltaTimeFromEnd = Math
							.abs((setpoint.vf - setpoint.maxVelocity) / Key.maxAcceleration);

					double distanceDecelerating = getDistanceTraveledWhileAccelerating(setpoint.maxVelocity,
							setpoint.vf, Key.maxAcceleration);

					double distanceCruising = (setpoint.m_x - lastSetpoint.m_x)
							- (distanceAccelerating + distanceDecelerating);
					setpoint.endCruisingDeltaTime = (distanceCruising / setpoint.maxVelocity)
							+ setpoint.startCruisingDeltaTime;
					setpoint.endDeltaTime = setpoint.endCruisingDeltaTime + endCruisingDeltaTimeFromEnd;

				} else {
					setpoint.startCruisingDeltaTime = halfWayTime;
					setpoint.endCruisingDeltaTime = halfWayTime;
					setpoint.maxVelocity = theoreticalMaxVelocity;
					double endCruisingDeltaTimeFromEnd = Math
							.abs((setpoint.vf - theoreticalMaxVelocity) / Key.maxAcceleration);
					setpoint.endDeltaTime = setpoint.startCruisingDeltaTime + endCruisingDeltaTimeFromEnd;
				}

				if (i1 == setpointVector.size() - 1) {
					System.out.println("");
					System.out.println("setpoint.vi: " + setpoint.vi);
					System.out.println("setpoint.vf: " + setpoint.vf);
					System.out.println("Key.maxVelocity: " + Key.maxVelocity);
					System.out.println("Key.maxAcceleration: " + Key.maxAcceleration);
					System.out.println("startCruisingDeltaTime: " + setpoint.startCruisingDeltaTime);
					System.out.println("End Cruising Delta Time: " + setpoint.endCruisingDeltaTime);
					System.out.println("End Delta Time: " + setpoint.endDeltaTime);
					System.out.println("theoreticalMaxVelocityDistance: " + theoreticalMaxVelocityDistance);
					System.out.println("theoreticalMaxVelocity: " + theoreticalMaxVelocity);
					System.out.println("setpoint.maxVelocity: " + setpoint.maxVelocity);
					System.out.println("nextMaxVelocity: " + nextMaxVelocity);
					System.out.println("maxVelocity: " + maxVelocity);
					System.out.println("");
				}

				// Needs to do this so that the last time through the code the max velocity is
				// not left at some obscure value

				Key.maxVelocity = maxVelocity;
			}

		}
		System.out.println("Starting to create velocity vector");
		setTrajectoryVector(Key);

	}

	/**
	 * This is where the left and right wheels are split into two different paths
	 */
	private void NumericallyIntegratePath(Path Key) {
		Key.setpointVectors.add(Key.setpointVector);
		Key.setpointVectors.add(Key.setpointVector2);

		Key.setpointMaxVelocityVectors.add(Key.setpointMaxVelocityVector);
		Key.setpointMaxVelocityVectors.add(Key.setpointMaxVelocityVector2);
	}

	/**
	 * This method uses takes all the setpoints and finds the vi and vf for each of
	 * them
	 */
	private void getFinalVelocityAndInitialVelocity(Vector<Point> setpointVector,
			Vector<Double> setpointMaxVelocityVector, Path Key) {
		
		// For every point inside of the setpoint vector
		for (int i1 = 0; i1 < setpointVector.size(); i1++) {
			boolean traveledInAPositiveDirection;
			boolean willTravelInAPositiveDirection;
			Point setpoint = setpointVector.get(i1);

			/*
			 * If this is the first setpoint being looked at set the vi to 0.0
			 * 
			 * Else set vi to the vf of the last setpoint looked at
			 */
			if (i1 == 0) {
				setpoint.vi = 0.0;
			} else {
				setpoint.vi = setpointVector.get(i1 - 1).vf;
			}

			/*
			 * If this is the first setpoint being looked at set
			 * traveledInAPositiveDirection according to whether or not setpoint is positive
			 * or negative
			 * 
			 * Else if the setpoint is greater than the last setpoint set
			 * traveledInAPositiveDirection to true
			 * 
			 * Else set traveledInAPositiveDirection to false
			 */
			if (i1 == 0) {
				if (setpoint.m_x > 0) {
					traveledInAPositiveDirection = true;
				} else {
					traveledInAPositiveDirection = false;
				}
			} else if (setpoint.m_x > setpointVector.get(i1 - 1).m_x) {
				traveledInAPositiveDirection = true;
			} else {
				traveledInAPositiveDirection = false;
			}

			/*
			 * If this is the very last setpoint willTravelInAPositiveDirection does not
			 * matter so set it to false
			 * 
			 * Else if this setpoint is greater than the next setpoint set
			 * willTravelInAPositiveDirection to false
			 * 
			 * Else set willTravelInAPositiveDirection to true
			 */
			if (i1 == (setpointVector.size() - 1)) {
				willTravelInAPositiveDirection = false;
			} else if (setpoint.m_x > setpointVector.get(i1 + 1).m_x) {
				willTravelInAPositiveDirection = false;
			} else {
				willTravelInAPositiveDirection = true;
			}

			/*
			 * If this is the final setpoint in the vector you want the final velocity to be
			 * 0 so set vf to 0
			 * 
			 * Else if you have been traveling in a positive direction and you will continue
			 * traveling in a positive direction or you have been traveling in a negative
			 * direction and you will continue traveling in a negative direction calculate
			 * whether or not you have to slow down when going to the current setpoint in
			 * order to prepare to reach the other setpoints
			 * 
			 * Else you will be reversing direction so your vf will be 0.0
			 */
			if (i1 == (setpointVector.size() - 1)) {
				setpoint.vf = 0.0;
			} else if ((traveledInAPositiveDirection && willTravelInAPositiveDirection)
					|| (!traveledInAPositiveDirection && !willTravelInAPositiveDirection)) {
				/*
				 * This max velocity reachable is different from the theoretical max velocity
				 * reachable back in the method createTrajectory because it does account for the
				 * max velocity either specified inside of Key or inside of the maximum velocity
				 * vector
				 */
				double maxVelocityReachable;
				double distanceTraveledWhileAcceleratingToMaxVelocity;

				/*
				 * If the max velocity specified is valid use it to find the distance traveled
				 * while accelerating
				 * 
				 * Else use the max velocity specified inside of Key
				 */

				double nextMaxVelocity = 0.0;
				try {
					nextMaxVelocity = setpointMaxVelocityVector.get(i1);
				} catch (ArrayIndexOutOfBoundsException a) {

				}

				if (nextMaxVelocity != 0.0 && nextMaxVelocity < Key.maxVelocity) {
					setpoint.maxVelocity = nextMaxVelocity;
				} else {
					setpoint.maxVelocity = Key.maxVelocity;
				}
				distanceTraveledWhileAcceleratingToMaxVelocity = getDistanceTraveledWhileAccelerating(
						0.0, setpoint.maxVelocity, Key.maxAcceleration);

				/*
				 * If the distance traveled while accelerating up to max velocity is not past
				 * the setpoint set maxVelocityReachable to the max velocity either specified
				 * inside of Key or in the max velocity vector
				 * 
				 * Else assign it to the final velocity reached during the process of
				 * accelerating to the setpoint
				 */
				Point nextPoint = new Point(0, 0);
				try {
					nextPoint = setpointVector.get(i1 + 1);
				} catch (ArrayIndexOutOfBoundsException a) {

				}
				System.out.println("distanceTraveledWhileAcceleratingToMaxVelocity: "
						+ distanceTraveledWhileAcceleratingToMaxVelocity);
				System.out.println("((Math.abs(setpoint.m_x - nextPoint.m_x) / 2)): "
						+ ((Math.abs(setpoint.m_x - nextPoint.m_x) / 2)));
				if (distanceTraveledWhileAcceleratingToMaxVelocity < ((Math.abs(setpoint.m_x - nextPoint.m_x)))) {
					maxVelocityReachable = setpoint.maxVelocity;
				} else {
					// This equation is the kinematic equation involving vf, vi, acceleration, and
					// displacement and has been rearranged to solve for vf
					maxVelocityReachable = Math.sqrt(Math.pow(setpointVector.get(i1).vf, 2)
							+ 2 * Key.maxAcceleration * (setpoint.m_x - nextPoint.m_x));
					System.out.println("maxVelocityReachable: " + maxVelocityReachable);
				}

				getVfForPoint(setpoint, setpointVector, willTravelInAPositiveDirection, maxVelocityReachable,
						Key.maxAcceleration, setpointMaxVelocityVector, Key.maxVelocity, i1);

			} else {
				setpoint.vf = 0.0;
			}

		}

	}

	/**
	 * This method takes a point and looks at the next setpoint(s) in order to
	 * determine the final velocity of the original point
	 * 
	 * 
	 */
	private void getVfForPoint(Point setpoint, Vector<Point> setpointVector, Boolean travelingInPositiveDirection,
			double maxVelocityReachable, double maxAcceleration, Vector<Double> setpointMaxVelocityVector,
			double maxVelocity, int currentSetpointIndex) {

		// This finds the distance traveled between a velocity of 0 and
		// maxVelocityReachable
		double distanceTraveledWhileAcceleratingFrom0ToMaxVelocityReachable = getDistanceTraveledWhileAccelerating(0.0,
				maxVelocityReachable, maxAcceleration);

		// Creates a point for the last setpoint looked at to be stored in
		Point lastSetpoint = new Point(0, 0);

		// The if and else statements here are the exact same except for some negative
		// signs switched around and greater than signs switched to less than or vice
		// versa depending on whether travelingInPositiveDirection is true of false
		if (travelingInPositiveDirection) {
			// This is the delta index of the point being looked at from the
			// currentSetpointIndex
			int deltaIndexFromCurrentSetpointIndex = 1;

			// If the next setpoint has a distance that is further than the current distance
			// + the distance covered while accelerating that means that any deceleration
			// doesn't need to start until at least the next setpoint so the final velocity
			// can be the max velocity reachable. Also check to make sure that the user
			// didn't set the next setpoint's max velocity
			if (setpointVector.get(currentSetpointIndex
					+ deltaIndexFromCurrentSetpointIndex).m_x >= distanceTraveledWhileAcceleratingFrom0ToMaxVelocityReachable
							+ setpoint.m_x
					&& (setpointVector.get(currentSetpointIndex + deltaIndexFromCurrentSetpointIndex).maxVelocity == 0
							|| setpointVector.get(currentSetpointIndex
									+ deltaIndexFromCurrentSetpointIndex).maxVelocity <= maxVelocityReachable)) {

				setpoint.vf = maxVelocityReachable;
				return;
			}

			// This for loop goes through 
			for (double i = setpointVector.get(currentSetpointIndex
					+ deltaIndexFromCurrentSetpointIndex).m_x; i < distanceTraveledWhileAcceleratingFrom0ToMaxVelocityReachable
							+ setpoint.m_x; deltaIndexFromCurrentSetpointIndex++) {
				System.out.println("Gone through for loop");
				Point nextSetpoint = setpointVector.get(currentSetpointIndex + 1);
				double nextSetpointMaxVelocity = setpointMaxVelocityVector.get(currentSetpointIndex + 1);

				if (nextSetpoint.m_x < lastSetpoint.m_x) {
					double tempVf = Math.sqrt(-2 * maxAcceleration * (nextSetpoint.m_x - setpoint.m_x));
					if (tempVf < setpoint.vf) {
						setpoint.vf = tempVf;
					}
					break;
				}
				if (nextSetpointMaxVelocity == 0.0 || nextSetpointMaxVelocity >= maxVelocityReachable) {
					setpoint.vf = maxVelocityReachable;
				} else if (0.0 < nextSetpointMaxVelocity && nextSetpointMaxVelocity < maxVelocityReachable) {
					double distanceTraveledWhileAcceleratingFromMaxVelocityReachableToNextSetpointMaxVelocity = getDistanceTraveledWhileAccelerating(
							nextSetpointMaxVelocity, maxVelocityReachable, maxAcceleration);
					if (distanceTraveledWhileAcceleratingFromMaxVelocityReachableToNextSetpointMaxVelocity < nextSetpoint.m_x
							- setpoint.m_x) {
						setpoint.vf = maxVelocityReachable;
					} else {
						double tempVf = Math.sqrt(Math.pow(nextSetpointMaxVelocity, 2)
								- 2 * maxAcceleration * (nextSetpoint.m_x - setpoint.m_x));
						if (tempVf < setpoint.vf) {
							setpoint.vf = tempVf;
						}
					}
				}
				nextSetpoint = lastSetpoint;
			}
		} else {
			int x = 1;

			if (setpointVector
					.get(currentSetpointIndex + x).m_x <= -distanceTraveledWhileAcceleratingFrom0ToMaxVelocityReachable
							+ setpoint.m_x) {
				setpoint.vf = setpoint.maxVelocity;
				return;
			}
			for (double i = setpointVector.get(
					currentSetpointIndex + x).m_x; i > -distanceTraveledWhileAcceleratingFrom0ToMaxVelocityReachable
							+ setpoint.m_x; x++) {
				System.out.println("Gone through for loop");
				Point nextSetpoint = setpointVector.get(currentSetpointIndex + 1);
				double nextSetpointMaxVelocity = setpointMaxVelocityVector.get(currentSetpointIndex + 1);

				if (nextSetpoint.m_x > lastSetpoint.m_x) {
					double tempVf = Math.sqrt(-2 * maxAcceleration * (nextSetpoint.m_x - setpoint.m_x));
					if (tempVf < setpoint.vf) {
						setpoint.vf = tempVf;
					}
					break;
				}
				if (nextSetpointMaxVelocity == 0.0 || nextSetpointMaxVelocity >= maxVelocityReachable) {
					setpoint.vf = maxVelocityReachable;
				} else if (0.0 < nextSetpointMaxVelocity && nextSetpointMaxVelocity < maxVelocityReachable) {
					double distanceTraveledWhileAcceleratingFromMaxVelocityReachableToNextSetpointMaxVelocity = getDistanceTraveledWhileAccelerating(
							nextSetpointMaxVelocity, maxVelocityReachable, maxAcceleration);
					if (-distanceTraveledWhileAcceleratingFromMaxVelocityReachableToNextSetpointMaxVelocity > (nextSetpoint.m_x
							- setpoint.m_x)) {
						setpoint.vf = maxVelocityReachable;
					} else {
						double tempVf = Math.sqrt(Math.pow(nextSetpointMaxVelocity, 2)
								- 2 * maxAcceleration * (nextSetpoint.m_x - setpoint.m_x));
						if (tempVf < setpoint.vf) {
							setpoint.vf = tempVf;
						}
					}
				}
				nextSetpoint = lastSetpoint;
			}
		}

	}

	/**
	 * This method uses the kinematic equation involving vi, vf, acceleration and
	 * displacement to get distance traveled while accelerating
	 */
	private double getDistanceTraveledWhileAccelerating(double vi, double vf, double maxAcceleration) {
		double distance = Math.abs((Math.pow(vf, 2) - Math.pow(vi, 2)) / (2 * maxAcceleration));
		return distance;
	}

	/**
	 * This method uses the trajectory parameters set inside of key to create a
	 * matrix in which current velocity, acceleration, position and timestamps are
	 * stored
	 */
	private void setTrajectoryVector(Path Key) {
		// If the dimension of the first point is equal to 2 add the two setpointVectors
		// to the setpointVectors vector so that later on things can stay uniform for
		// one dimension or for two.

		if (Key.setpointVector.get(0).m_dim == 2) {
			Key.trajectoryVectors.add(Key.trajectoryVector);
			Key.trajectoryVectors.add(Key.trajectoryVector2);
		} else {
			Key.trajectoryVectors.add(Key.trajectoryVector);
		}

		// This for loop goes through all of the trajectory vectors inside of
		// trajectoryVectors.
		for (int i = 0; i < Key.setpointVectors.size(); i++) {
			// Gets the vectors needed
			Vector<Point> setpointVector = Key.setpointVectors.get(i);
			Vector<TrajectoryPoint> trajectoryVector = Key.trajectoryVectors.get(i);

			// currentTime is where the delta time from the beginning of the trajectory
			// matrix is stored
			double currentTime = 0.0;
			// previousTime is where the delta Time from the beginning of the trajectory
			// matrix to the last setpoint's final timestamp is stored
			double previousTime = 0.0;

			// This for loop goes though all of the points inside of the setpointVector
			for (int i1 = 0; i1 < setpointVector.size(); i1++) {
				// Gets the next point
				Point setpoint = setpointVector.get(i1);

				// This is where the last setpoint's m_x is stored so that later on when there
				// is a delta distance from the starting position of the the setpoint it can be
				// converted into a delta distance form the starting position of the trajectory
				// vector
				double lastSetpointm_x = 0.0;

				// Try to see what the last setpoint's m_x was but if this is the first point
				// being looked at there was no last point so just keep lastSetpointm_x 0
				try {
					lastSetpointm_x = setpointVector.get(i1 - 1).m_x;
				} catch (ArrayIndexOutOfBoundsException a) {
				}

				// This for loop creates a trajectory point for every point in time in between
				// the starting time for the setpoint and the endDeltaTime

				// i11 is set to current Time because if it were set to 0 then it would repeat
				// some time. For example if when looking at the last setpoint, i11 +
				// m_trajectoryPointInterval was 3.5 and the endDeltaTime was 3 it
				// would break out of this loop and go on to the next setpoint setting i11 back
				// to 0. In this example the next point in time should really be 0.5 second more
				// than the endDeltatTime of the last setpoint however if i11 is set to 0 it
				// will not be greater than the last setpoint's end delta time at all.

				// previousTime is added to endDeltaTime so that the times can be kept on the
				// same scale
				for (double i11 = currentTime; currentTime < setpoint.endDeltaTime
						+ previousTime; i11 += m_trajectoryPointInterval) {
					// Sets the current time for the trajectory point being created
					TrajectoryPoint trajectoryPoint = new TrajectoryPoint(0, 0, 0, currentTime);

					// If currentTime is between startCruisingDeltaTime and endCruisingDeltaTime set
					// the
					// current velocity to the setpoint's max velocity

					// Else if currentTime is before the startDeltaTime

					// Else the currentTime is after endCruisingDeltaTime
					if (setpoint.startCruisingDeltaTime + previousTime <= currentTime
							&& i11 < setpoint.endCruisingDeltaTime + previousTime) {
						trajectoryPoint.m_currentVelocity = setpoint.maxVelocity;

						// Gets the distance traveled to accelerate up to the max velocity from the
						// initial velocity of the setpoint
						double distanceTraveledWhileAccelerating = getDistanceTraveledWhileAccelerating(setpoint.vi,
								setpoint.maxVelocity, Key.maxAcceleration);

						// Gets the distance covered from the startCruisingDeltaTime to currentTime
						double distanceTraveledWhileCruising = setpoint.maxVelocity
								* (currentTime - (setpoint.startCruisingDeltaTime + previousTime));

						// Calculate the delta position from the starting position of the setpoint by
						// adding the
						// distanceTraveledWhileAccelerating to distanceTraveledWhileCruising
						trajectoryPoint.m_position = distanceTraveledWhileAccelerating + distanceTraveledWhileCruising;

					} else if (currentTime < setpoint.startCruisingDeltaTime + previousTime) {
						// This is the kinematic equation which uses initial velocity, acceleration and
						// time to calculate final velocity. In this instance the current velocity is
						// the final velocity that is being solved for and the time is the delta time
						// gone by from the start time of the setpoint to the currentTime
						trajectoryPoint.m_currentVelocity = setpoint.vi
								+ Key.maxAcceleration * (currentTime - previousTime);

						// Finds delta distance from the starting position of the setpoint
						trajectoryPoint.m_position = getDistanceTraveledWhileAccelerating(setpoint.vi,
								trajectoryPoint.m_currentVelocity, Key.maxAcceleration);
					} else {
						// This is the kinematic equation which uses initial velocity, acceleration and
						// time to calculate final velocity. In this instance the current velocity is
						// the final velocity that is being solved for and the time is the delta time
						// gone by from the end time of the setpoint to the currentTime
						trajectoryPoint.m_currentVelocity = setpoint.vf
								+ Key.maxAcceleration * (setpoint.endDeltaTime + previousTime - currentTime);

						// Finds the distance traveled while accelerating up to max velocity from the
						// initial velocity
						double distanceTraveledWhileAccelerating = getDistanceTraveledWhileAccelerating(setpoint.vi,
								setpoint.maxVelocity, Key.maxAcceleration);

						// Finds the distance traveled while cruising
						double distanceTraveledWhileCruising = setpoint.maxVelocity
								* ((setpoint.endCruisingDeltaTime + previousTime)
										- (setpoint.startCruisingDeltaTime + previousTime));

						// Finds the distance covered while decelerating from the cruising
						// velocity(maxVelocity) to the current velocity
						double distanceTraveledWhileDecelerating = getDistanceTraveledWhileAccelerating(
								setpoint.maxVelocity, trajectoryPoint.m_currentVelocity, Key.maxAcceleration);

						// Calculate the delta position from the starting position of the setpoint by
						// adding the
						// distanceTraveledWhileAccelerating to the distanceTraveledWhileCruising to the
						// distanceTraveledWhileDecelerating
						trajectoryPoint.m_position = distanceTraveledWhileAccelerating + distanceTraveledWhileCruising
								+ distanceTraveledWhileDecelerating;
					}

					// Calculates the delta position from the starting position of the trajectory
					// vector by adding the last setpoint's m_x to it because that was the last
					// delta distance from the starting position of the trajectory vector
					trajectoryPoint.m_position += lastSetpointm_x;

					// Finds what the next trajectory Point's time will be in order
					double nextTime = currentTime + m_trajectoryPointInterval;

					// This is where the next velocity will be stored
					double nextVelocity = 0.0;

					// This is where all of the endDeltaTimes of the setpoints looked at after the
					// current setpoint will be stored so that lastSetpoint's times can be put to
					// scale
					double nextSetpointsEndTimes = 0.0;

					// This is the setpoint with the lowest setpoint's endDeltaTime + previousTime
					// in which nextTime will be less than endDeltaTime + previousTime if nextTime
					// is past the current setpoint's endDeltaTime
					Point lastSetpoint = new Point(0.0, 0.0);

					// Sets lastSetpoint's endDeltaTime to 0 because that is a way to check later on
					// if lastSetpoint has been set to anything
					lastSetpoint.endDeltaTime = 0.0;

					// If nextTime is past setpoint's end time

					// Else go though the same logic as above when trying to find the current
					// setpoint just use nextTime for the time
					if (nextTime > setpoint.endDeltaTime + previousTime) {
						// This for loop goes though all of the rest of the setpoints after the current
						// setpoint
						for (int a = i1 + 1; a < Key.setpointVector.size(); a += m_trajectoryPointInterval) {
							System.out.println("a: " + a);
							System.out.println(
									"setpointVector.get(a).endDeltaTime: " + setpointVector.get(a).endDeltaTime);
							System.out.println("previousTime: " + previousTime);

							// If the end time of the setpoint being looked at is greater than the nextTime
							// set it to lastSetpoint and break out of the for loop
							if (setpointVector.get(a).endDeltaTime + previousTime + nextSetpointsEndTimes > nextTime) {
								lastSetpoint = setpointVector.get(a);
								break;
							}

							// Keeps a record of the total time covered from the current setpoint to the
							// setpoint at setpointVector.get(a)
							nextSetpointsEndTimes += setpointVector.get(a).endDeltaTime;

						}
						// If lastSetpoint was not set to anything this means that by nextTime there
						// will not be another setpoint so the next velocity must be 0 because every
						// trajectory vector ends with a velocity of 0.0

						// All the rest is the same logic as above when trying to find the current
						// velocity just applied to this nextTime and lastsetpoint
						if (lastSetpoint.endDeltaTime == 0.0) {
							nextVelocity = 0.0;
						} else if (lastSetpoint.startCruisingDeltaTime + previousTime
								+ nextSetpointsEndTimes <= nextTime
								&& nextTime < lastSetpoint.endCruisingDeltaTime + previousTime
										+ nextSetpointsEndTimes) {
							System.out.println("1");
							nextVelocity = lastSetpoint.maxVelocity;
						} else if (nextTime < lastSetpoint.startCruisingDeltaTime + previousTime
								+ nextSetpointsEndTimes) {
							System.out.println("2");
							nextVelocity = lastSetpoint.vi + Key.maxAcceleration * nextTime;
						} else {
							System.out.println("3");
							nextVelocity = lastSetpoint.vf + Key.maxAcceleration
									* (lastSetpoint.endDeltaTime + previousTime + nextSetpointsEndTimes - nextTime);
						}
					} else if (setpoint.startCruisingDeltaTime + previousTime <= nextTime
							&& nextTime <= setpoint.endCruisingDeltaTime + previousTime) {
						nextVelocity = setpoint.maxVelocity;
					} else if (nextTime < setpoint.startCruisingDeltaTime + previousTime) {
						nextVelocity = setpoint.vi + Key.maxAcceleration * nextTime;
					} else {
						nextVelocity = setpoint.vf
								+ Key.maxAcceleration * (setpoint.endDeltaTime + previousTime - nextTime);
					}

					// Find the acceleration by subtracting the current velocity from the next
					// velocity
					trajectoryPoint.m_acceleration = nextVelocity - trajectoryPoint.m_currentVelocity;

					if (trajectoryPoint.m_timestamp == 17.0) {
						System.out.println("");
						System.out.println("trajectoryPoint.m_timestamp: " + trajectoryPoint.m_timestamp);
						System.out.println("setpoint.startCruisingDeltaTime: " + setpoint.startCruisingDeltaTime);
						System.out.println("setpoint.endCruisingDeltaTime: " + setpoint.endCruisingDeltaTime);
						System.out.println("setpoint.endDeltaTime: " + setpoint.endDeltaTime);
						System.out.println("i11: " + i11);
						System.out.println("");

						System.out.println("nextSetpointsEndTimes: " + +nextSetpointsEndTimes);
						System.out.println("lastSetpoint.vf: " + lastSetpoint.vf);
						System.out.println("nextTime: " + nextTime);
						System.out.println("setpoint.endDeltaTime: " + setpoint.endDeltaTime);
						System.out.println("i1: " + i1);
						System.out.println("nextVelocity: " + nextVelocity);
						System.out.println("trajectoryPoint.m_currentVelocity: " + trajectoryPoint.m_currentVelocity);
						System.out.println("trajectoryPoint.m_acceleration: " + trajectoryPoint.m_acceleration);
						System.out
								.println("lastSetpoint.startCruisingDeltaTime: " + lastSetpoint.startCruisingDeltaTime);
						System.out.println("lastSetpoint.endCruisingDeltaTime: " + lastSetpoint.endCruisingDeltaTime);
						System.out.println("lastSetpoint.endDeltaTime: " + lastSetpoint.endDeltaTime);
						System.out.println("(nextTime - setpoint.endDeltaTime): " + (nextTime - previousTime));
						System.out.println("lastSetpoint.maxVelocity: " + lastSetpoint.maxVelocity);
						System.out.println("previousTime: " + previousTime);
						System.out.println("");
					}

					// Add this trajectory point to the trajectory vector
					trajectoryVector.add(trajectoryPoint);

					currentTime += m_trajectoryPointInterval;
				}

				// Keep the running count of delta time from the start of the trajectory vector
				previousTime += setpoint.endDeltaTime;
			}
		}
	}

	/**
	 * This method takes a delta time from the beginning of a trajectory path and
	 * returns the point where that time is
	 */
	public TrajectoryPoint getTrajectoryPoint(Vector<TrajectoryPoint> trajectoryPath, double deltaTime) {
		// Creates a point for the point being returned to be stored in
		TrajectoryPoint point = new TrajectoryPoint();

		// This for loop goes through the trajectory vector called trajectoryPath
		for (int i = 0; i < trajectoryPath.size(); i++) {

			// Assigns the point to i
			point = trajectoryPath.get(i);

			// If this point is on or past the deltaTime it is the point being looked for
			// and return that point
			if (point.m_timestamp >= deltaTime) {
				return point;
			}
		}
		return point;
	}

	public void initDefaultCommand() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
