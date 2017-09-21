package kinematics;

import java.util.Vector;

public class KinematicsSimpler {

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	private static double m_trajectoryPointInterval = 0.5;

	public static double getTrajectoryPointInterval() {
		return m_trajectoryPointInterval;
	}

	public class InvalidDimentionException extends Exception {

		private static final long serialVersionUID = 1L;

		public InvalidDimentionException(String message) {
			super(message);
		}
	}

	public class Path extends TrajectoryPaths {

		Vector<Point> setpointVector = new Vector<Point>();

		public Vector<Point> getSetpointVector() {
			return setpointVector;
		}

		int setPointDimention = 0;
	}

	private class TrajectoryPaths {
		double maxVelocity;
		double maxAcceleration;

		public double getMaxVelocity() {
			return maxVelocity;
		};

		public double getmaxAcceleration() {
			return maxAcceleration;
		};

		Vector<TrajectoryPoint> trajectoryVector = new Vector<TrajectoryPoint>();

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

		public double getMaxVelocity() {
			return maxVelocity;
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
	 * 
	 * @throws InvalidDimentionException
	 */
	public void addPointToPath(Path Key, Point point) throws InvalidDimentionException {
		privateAddPointToPath(Key, point, 0);
	}

	/**
	 * Takes a point and tries to add it to the setpoint vector inside of Key. Takes
	 * the max velocity that the user wants and adds it to a max velocity vector
	 * that will be used later on
	 * 
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
		point.maxVelocity = maxVelocity;
		Key.setpointVector.add(point);
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
	public void createTrajectory(Path Key, double maxVelocity, double maxAcceleration) {
		Key.maxAcceleration = maxAcceleration;
		Key.maxVelocity = maxVelocity;

		/*
		 * If the dimension of the vector is 2 numerically integrate the path to create
		 * two separate 1 dimensional paths Else add the another layer of vector onto
		 * this setpoint vector to keep everything uniform later on
		 */

		// For every setpoint vector in the vector of setpoint vectors

		Vector<Point> setpointVector = Key.setpointVector;

		// Final velocity and Initial Velocity are commonly referred to as vi and vf
		// respectively
		getFinalVelocityAndInitialVelocity(setpointVector, Key);

		// For every point in this setpoint vector

		for (int i1 = 0; i1 < setpointVector.size(); i1++) {

			Point setpoint = setpointVector.get(i1);

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
					+ Math.pow(setpoint.vf, 2) / (2 * Key.maxAcceleration) + Math.abs(setpoint.m_x - lastSetpoint.m_x)))
					/ 2;
			// This equation is the kinematic equation involving vf, vi, acceleration, and
			// displacement and has been rearranged to solve for vf

			double theoreticalMaxVelocity = Math.sqrt(2 * Key.maxAcceleration * theoreticalMaxVelocityDistance);

			/*
			 * This equation is the kinematic equation involving vf, vi, acceleration and
			 * time and has been rearranged to solve for the time in which it will take to
			 * reach the theoretical max velocity
			 */
			double halfWayTime = theoreticalMaxVelocity / Key.maxAcceleration;
			halfWayTime = halfWayTime - (setpoint.vi / Key.maxAcceleration);

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

			if (theoreticalMaxVelocity > setpoint.maxVelocity) {
				double distanceAccelerating = getDistanceTraveledWhileAccelerating(setpoint.vi, setpoint.maxVelocity,
						Key.maxAcceleration);

				setpoint.startCruisingDeltaTime = (setpoint.maxVelocity - setpoint.vi) / Key.maxAcceleration;

				double endCruisingDeltaTimeFromEnd = Math
						.abs((setpoint.vf - setpoint.maxVelocity) / Key.maxAcceleration);
				if (setpoint.maxVelocity < setpoint.vf) {
					endCruisingDeltaTimeFromEnd = 0.0;
				}
				double distanceDecelerating = getDistanceTraveledWhileAccelerating(setpoint.maxVelocity, setpoint.vf,
						(Key.maxAcceleration));

				double distanceCruising = Math.abs(setpoint.m_x - lastSetpoint.m_x)
						- Math.abs(distanceAccelerating + distanceDecelerating);
				setpoint.endCruisingDeltaTime = Math
						.abs((distanceCruising / setpoint.maxVelocity) + setpoint.startCruisingDeltaTime);
				setpoint.endDeltaTime = setpoint.endCruisingDeltaTime + endCruisingDeltaTimeFromEnd;

			} else {
				setpoint.startCruisingDeltaTime = Math.abs(halfWayTime);
				setpoint.endCruisingDeltaTime = Math.abs(halfWayTime);
				setpoint.maxVelocity = theoreticalMaxVelocity;
				double endCruisingDeltaTimeFromEnd = Math
						.abs((setpoint.vf - theoreticalMaxVelocity) / Key.maxAcceleration);
				setpoint.endDeltaTime = setpoint.startCruisingDeltaTime + endCruisingDeltaTimeFromEnd;
			}

			// Needs to do this so that the last time through the code the max velocity is
			// not left at some obscure value

			Key.maxVelocity = maxVelocity;

		}

		setTrajectoryVector(Key);
	}

	private void getFinalVelocityAndInitialVelocity(Vector<Point> setpointVector, Path Key) {

		// For every point inside of the setpoint vector

		for (int i1 = 0; i1 < setpointVector.size(); i1++) {
			boolean traveledInAPositiveDirection;
			boolean willTravelInAPositiveDirection;

			Point setpoint = setpointVector.get(i1);

			if (setpoint.maxVelocity >= Key.maxVelocity || setpoint.maxVelocity <= 0.0) {
				setpoint.maxVelocity = Key.maxVelocity;
			}

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
			Point nextSetpoint = new Point(0, 0);
			try {
				nextSetpoint = setpointVector.get(i1 + 1);

			} catch (ArrayIndexOutOfBoundsException a) {

			}
			Point previousSetpoint = new Point(0, 0);
			try {
				previousSetpoint = setpointVector.get(i1 - 1);

			} catch (ArrayIndexOutOfBoundsException a) {

			}
			if (nextSetpoint.maxVelocity >= Key.maxVelocity || nextSetpoint.maxVelocity <= 0.0) {
				nextSetpoint.maxVelocity = Key.maxVelocity;
			}

			double distanceTraveledWhileAcceleratingToMaxVelocityFromVi = (Math.pow(setpoint.maxVelocity, 2)
					- Math.pow(setpoint.vi, 2)) / (2 * Key.maxAcceleration);
			double deltaDistanceBetweenCurrentSetpointAndPreviousSetpoint = Math
					.abs(setpoint.m_x - previousSetpoint.m_x);
			if (distanceTraveledWhileAcceleratingToMaxVelocityFromVi > deltaDistanceBetweenCurrentSetpointAndPreviousSetpoint) {
				setpoint.vf = Math.sqrt(Math.abs(Math.pow(setpoint.vi, 2)
						+ 2 * Key.maxAcceleration * deltaDistanceBetweenCurrentSetpointAndPreviousSetpoint));

			} else {
				setpoint.vf = setpoint.maxVelocity;
			}
			setpoint.vf = Math.abs(setpoint.vf);

			if (i1 == (setpointVector.size() - 1)) {
				setpoint.vf = 0.0;
			} else if ((traveledInAPositiveDirection && willTravelInAPositiveDirection)
					|| (!traveledInAPositiveDirection && !willTravelInAPositiveDirection)) {

				double distanceCoveredWhileAcceleratingToMaxVelocity = getDistanceTraveledWhileAccelerating(0.0,
						setpoint.maxVelocity, Key.maxAcceleration);
				Point previousPoint = setpoint;
				Vector<Point> possibleFinalVelocityDeterminingSetpoints = new Vector<Point>();
				Vector<Integer> possibleFinalVelocityDeterminingSetpointIndexes = new Vector<Integer>();

				for (int i = i1; i < setpointVector.size(); i++) {

					nextSetpoint = setpointVector.get(i);
					if (Math.abs(previousPoint.m_x) > Math.abs(nextSetpoint.m_x)) {
						possibleFinalVelocityDeterminingSetpointIndexes.addElement(i - 1);
						break;
					}

					possibleFinalVelocityDeterminingSetpoints.add(nextSetpoint);
					if (i == i1) {
						continue;
					}

					if (nextSetpoint.maxVelocity >= Key.maxVelocity || nextSetpoint.maxVelocity <= 0.0) {
						nextSetpoint.maxVelocity = Key.maxVelocity;
					} else {
						possibleFinalVelocityDeterminingSetpointIndexes.addElement(i);

					}

					if (Math.abs(nextSetpoint.m_x)
							- Math.abs(setpoint.m_x) > distanceCoveredWhileAcceleratingToMaxVelocity) {
						possibleFinalVelocityDeterminingSetpointIndexes.addElement(i);
						break;
					}

					if (i + 1 == setpointVector.size()) {
						possibleFinalVelocityDeterminingSetpointIndexes.addElement(i);
						break;
					}
					previousPoint = nextSetpoint;

				}
				if (setpoint.m_x == -14.74165235513177 && false) {
					System.out.println("");
					System.out.println("i1: " + i1);
					for (int i = 0; i < possibleFinalVelocityDeterminingSetpointIndexes.size(); i++) {
						System.out.println(possibleFinalVelocityDeterminingSetpointIndexes.get(i));
					}
					for (int i = 0; i < possibleFinalVelocityDeterminingSetpoints.size(); i++) {
						System.out.println(possibleFinalVelocityDeterminingSetpoints.get(i).m_x);
					}
					System.out.println("");
				}
				for (int i11 = 0; i11 < possibleFinalVelocityDeterminingSetpointIndexes.size(); i11++) {
					Point possibleFinalVelocityDeterminingSetpoint = new Point(0, 0);

					double possibleFinalVelocityDeterminingSetpointMaxVelocity = possibleFinalVelocityDeterminingSetpoints
							.elementAt(possibleFinalVelocityDeterminingSetpointIndexes.elementAt(i11) - i1).maxVelocity;
					try {
						possibleFinalVelocityDeterminingSetpoint = possibleFinalVelocityDeterminingSetpoints
								.elementAt(possibleFinalVelocityDeterminingSetpointIndexes.elementAt(i11) - 1 - i1);
					} catch (ArrayIndexOutOfBoundsException a) {

					}
					double deltaDistanceFromPossibleFinalVelocityDeterminingSetpointToStartDecceleratingAt = (Math.pow(
							possibleFinalVelocityDeterminingSetpointMaxVelocity, 2) - Math.pow(setpoint.maxVelocity, 2))
							/ (-2 * Key.maxAcceleration);
					double deltaDistanceFromSetpointToStartDecceleratingAt = setpoint.m_x
							- (possibleFinalVelocityDeterminingSetpoint.m_x
									- deltaDistanceFromPossibleFinalVelocityDeterminingSetpointToStartDecceleratingAt);
					double tempVf = Math.sqrt(Math.pow(setpoint.maxVelocity, 2)
							- 2 * Key.maxAcceleration * deltaDistanceFromSetpointToStartDecceleratingAt);
					tempVf = Math.abs(tempVf);

					if (setpoint.vf > tempVf) {
						setpoint.vf = tempVf;
					}
					// MAYBE CHANGE THE WAY I GET VF UP HERE WITH A CUSTOM MAXV IN THE SAME WAY I DID IT BELOW????
					if (i11 + 1 == possibleFinalVelocityDeterminingSetpointIndexes.size()) {
						possibleFinalVelocityDeterminingSetpoint = possibleFinalVelocityDeterminingSetpoints
								.elementAt(possibleFinalVelocityDeterminingSetpointIndexes.elementAt(i11) - i1);
						double distanceCoveredWhileacceleratingFrom0ToVi = Math.pow(setpoint.vi, 2)
								/ (2 * Key.maxAcceleration);
						double deltaDistanceBetweenSetpoints = Math
								.abs(possibleFinalVelocityDeterminingSetpoint.m_x - setpoint.m_x);
						double combinedDistance = deltaDistanceBetweenSetpoints
								+ distanceCoveredWhileacceleratingFrom0ToVi
								+ Math.abs(deltaDistanceBetweenCurrentSetpointAndPreviousSetpoint);
						double maxVelocityDistance = Math.abs(combinedDistance / 2);
						double theoreticalMaxVelocity = Math.sqrt(2 * Key.maxAcceleration * maxVelocityDistance);
						double highestVelocityHitWhileAcceleratingToSetpoint = Math.sqrt(Math.pow(setpoint.vi, 2)
								+ 2 * Key.maxAcceleration * Math.abs(setpoint.m_x - previousSetpoint.m_x));
						double highestVelocityHitWhileTravelingToSetpoint;
						if (highestVelocityHitWhileAcceleratingToSetpoint > theoreticalMaxVelocity) {
							highestVelocityHitWhileTravelingToSetpoint = theoreticalMaxVelocity;
							double distanceTraveledWhileAcceleratingFormViToHighestVelocityHitWhileTravelingToSetpoint = (Math
									.pow(theoreticalMaxVelocity, 2) - Math.pow(setpoint.vi, 2))
									/ (2 * Key.maxAcceleration);
							double distanceBetweenTheoreticalMaxVelocityAndTempVf = deltaDistanceBetweenCurrentSetpointAndPreviousSetpoint
									- distanceTraveledWhileAcceleratingFormViToHighestVelocityHitWhileTravelingToSetpoint;
							tempVf = Math.sqrt(Math.pow(highestVelocityHitWhileTravelingToSetpoint, 2)
									- 2 * Key.maxAcceleration * distanceBetweenTheoreticalMaxVelocityAndTempVf);
						} else {
							highestVelocityHitWhileTravelingToSetpoint = highestVelocityHitWhileAcceleratingToSetpoint;
							tempVf = highestVelocityHitWhileTravelingToSetpoint;
						}
						tempVf = Math.abs(tempVf);

						if (setpoint.vf > tempVf) {
							setpoint.vf = tempVf;
						}
						if (setpoint.m_x == -14.74165235513177 && false) {
							System.out.println("");
							System.out.println("setpoint.m_x: " + setpoint.m_x);
							System.out.println("possibleFinalVelocityDeterminingSetpoint.m_x: "
									+ possibleFinalVelocityDeterminingSetpoint.m_x);
							System.out.println("highestVelocityHitWhileAcceleratingToSetpoint: "
									+ highestVelocityHitWhileAcceleratingToSetpoint);
							System.out.println("distanceCoveredWhileacceleratingFrom0ToVi: "
									+ distanceCoveredWhileacceleratingFrom0ToVi);
							System.out.println("deltaDistanceBetweenSetpoints: " + deltaDistanceBetweenSetpoints);
							System.out.println("deltaDistanceBetweenCurrentSetpointAndPreviousSetpoint: "
									+ deltaDistanceBetweenCurrentSetpointAndPreviousSetpoint);
							System.out.println("combinedDistance: " + combinedDistance);
							System.out.println("maxVelocityDistance: " + maxVelocityDistance);
							System.out.println("theoreticalMaxVelocity: " + theoreticalMaxVelocity);
							System.out.println("possibleFinalVelocityDeterminingSetpoint: "
									+ possibleFinalVelocityDeterminingSetpoint.m_x);
							System.out.println("tempVf: " + tempVf);
							System.out.println("");
						}
					}
				}

			} else {
				setpoint.vf = 0.0;
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

		// This for loop goes through all of the trajectory vectors inside of
		// trajectoryVectors.
		// Gets the vectors needed
		Vector<Point> setpointVector = Key.setpointVector;
		Vector<TrajectoryPoint> trajectoryVector = Key.trajectoryVector;

		// currentTime is where the delta time from the beginning of the trajectory
		// matrix is stored
		double currentTime = 0.0;
		// previousTime is where the delta Time from the beginning of the trajectory
		// matrix to the last setpoint's final timestamp is stored
		double previousTime = 0.0;
		double directionConstant = 1.0;
		// This for loop goes though all of the points inside of the setpointVector
		for (int i1 = 0; i1 < setpointVector.size(); i1++) {
			// Gets the next point
			Point setpoint = setpointVector.get(i1);
			Point previousSetpoint = new Point(0, 0);
			try {
				previousSetpoint = setpointVector.get(i1 - 1);
			} catch (ArrayIndexOutOfBoundsException a) {

			}
			if (previousSetpoint.m_x > setpoint.m_x) {
				directionConstant = -1;
			} else {
				directionConstant = 1;
			}

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
					trajectoryPoint.m_currentVelocity *= directionConstant;

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
					trajectoryPoint.m_position *= directionConstant;

				} else if (currentTime < setpoint.startCruisingDeltaTime + previousTime) {
					// This is the kinematic equation which uses initial velocity, acceleration and
					// time to calculate final velocity. In this instance the current velocity is
					// the final velocity that is being solved for and the time is the delta time
					// gone by from the start time of the setpoint to the currentTime
					trajectoryPoint.m_currentVelocity = setpoint.vi
							+ Key.maxAcceleration * (currentTime - previousTime);
					trajectoryPoint.m_currentVelocity *= directionConstant;
					// Finds delta distance from the starting position of the setpoint
					trajectoryPoint.m_position = getDistanceTraveledWhileAccelerating(setpoint.vi,
							trajectoryPoint.m_currentVelocity, Key.maxAcceleration);
					trajectoryPoint.m_position *= directionConstant;
				} else {
					// This is the kinematic equation which uses initial velocity, acceleration and
					// time to calculate final velocity. In this instance the current velocity is
					// the final velocity that is being solved for and the time is the delta time
					// gone by from the end time of the setpoint to the currentTime
					trajectoryPoint.m_currentVelocity = setpoint.vf
							+ Key.maxAcceleration * (setpoint.endDeltaTime + previousTime - currentTime);
					trajectoryPoint.m_currentVelocity *= directionConstant;
					// Finds the distance traveled while accelerating up to max velocity from the
					// initial velocity
					Point lastSetpoint = new Point(0, 0);
					try {
						lastSetpoint = setpointVector.get(i1 - 1);
					} catch (ArrayIndexOutOfBoundsException a) {

					}
					double distanceTraveledWhileAccelerating;
					double distanceTraveledWhileDecelerating;
					double distanceCoveredWhileAcceleratingFromTheInitialVelocityToTheFinalVelocity = getDistanceTraveledWhileAccelerating(
							setpoint.vi, setpoint.vf, Key.maxAcceleration);
					if (distanceCoveredWhileAcceleratingFromTheInitialVelocityToTheFinalVelocity
							- Math.abs(setpoint.m_x - lastSetpoint.m_x) <= 0.1
							&& distanceCoveredWhileAcceleratingFromTheInitialVelocityToTheFinalVelocity
									- Math.abs(setpoint.m_x - lastSetpoint.m_x) >= -0.1) {
						distanceTraveledWhileAccelerating = 0.0;
						distanceTraveledWhileDecelerating = getDistanceTraveledWhileAccelerating(setpoint.vi,
								trajectoryPoint.m_currentVelocity, Key.maxAcceleration);
					} else {

						distanceTraveledWhileAccelerating = getDistanceTraveledWhileAccelerating(setpoint.vi,
								setpoint.maxVelocity, Key.maxAcceleration);
						distanceTraveledWhileDecelerating = getDistanceTraveledWhileAccelerating(setpoint.maxVelocity,
								trajectoryPoint.m_currentVelocity, Key.maxAcceleration);
					}
					// Finds the distance traveled while cruising
					double distanceTraveledWhileCruising = setpoint.maxVelocity
							* ((setpoint.endCruisingDeltaTime + previousTime)
									- (setpoint.startCruisingDeltaTime + previousTime));

					// Finds the distance covered while decelerating from the cruising
					// velocity(maxVelocity) to the current velocity

					// Calculate the delta position from the starting position of the setpoint by
					// adding the
					// distanceTraveledWhileAccelerating to the distanceTraveledWhileCruising to the
					// distanceTraveledWhileDecelerating

					trajectoryPoint.m_position = distanceTraveledWhileAccelerating + distanceTraveledWhileCruising
							+ distanceTraveledWhileDecelerating;

					trajectoryPoint.m_position *= directionConstant;
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
					for (int a = i1; a < Key.setpointVector.size(); a++) {
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
					} else if (lastSetpoint.startCruisingDeltaTime + previousTime + nextSetpointsEndTimes <= nextTime
							&& nextTime < lastSetpoint.endCruisingDeltaTime + previousTime + nextSetpointsEndTimes) {

						nextVelocity = lastSetpoint.maxVelocity;
					} else if (nextTime < lastSetpoint.startCruisingDeltaTime + previousTime + nextSetpointsEndTimes) {

						nextVelocity = lastSetpoint.vi
								+ Key.maxAcceleration * (nextTime - (setpoint.endDeltaTime + previousTime));
					} else {

						nextVelocity = lastSetpoint.vf + Key.maxAcceleration
								* (lastSetpoint.endDeltaTime + previousTime + nextSetpointsEndTimes - nextTime);
					}
					if (lastSetpoint.endDeltaTime != 0.0) {
						if (setpoint.m_x > lastSetpoint.m_x) {
							directionConstant = -1;
						} else {
							directionConstant = 1;
						}
					}
				} else if (setpoint.startCruisingDeltaTime + previousTime <= nextTime
						&& nextTime < setpoint.endCruisingDeltaTime + previousTime) {
					nextVelocity = setpoint.maxVelocity;
				} else if (nextTime < setpoint.startCruisingDeltaTime + previousTime) {
					nextVelocity = setpoint.vi + Key.maxAcceleration * (nextTime - previousTime);
				} else {
					nextVelocity = setpoint.vf
							+ Key.maxAcceleration * (setpoint.endDeltaTime + previousTime - nextTime);
				}

				// Find the acceleration by subtracting the current velocity from the next
				// velocity
				trajectoryPoint.m_acceleration = (nextVelocity * directionConstant) - trajectoryPoint.m_currentVelocity;
				try {
					if (trajectoryPoint.m_timestamp == -70.0 && Key.setpointVector.get(0).m_x == 0.6676984378508238) {
						System.out.println("");
						System.out.println("currentTime: " + currentTime);
						System.out.println("trajectoryPoint.m_timestamp: " + trajectoryPoint.m_timestamp);
						System.out.println(
								"setpoint.startCruisingDeltaTime: " + (setpoint.startCruisingDeltaTime + previousTime));
						System.out.println(
								"setpoint.endCruisingDeltaTime: " + (setpoint.endCruisingDeltaTime + previousTime));
						System.out.println("setpoint.endDeltaTime: " + (setpoint.endDeltaTime + previousTime));
						System.out.println("i11: " + i11);
						System.out.println("setpoint.vi: " + setpoint.vi);
						System.out.println("setpoint.vf: " + setpoint.vf);
						System.out.println("directionConstant: " + directionConstant);
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
						System.out.println("setpoint.m_x: " + setpoint.m_x);
						System.out.println("lastSetpoint.m_x: " + lastSetpoint.m_x);
						System.out.println("lastSetpoint.vi: " + lastSetpoint.vi);
						System.out.println("");
					}
				} catch (ArrayIndexOutOfBoundsException a) {

				}
				// Add this trajectory point to the trajectory vector
				trajectoryVector.add(trajectoryPoint);

				currentTime += m_trajectoryPointInterval;

			}

			// Keep the running count of delta time from the start of the trajectory vector
			previousTime += setpoint.endDeltaTime;
		}
		try {
			if (trajectoryVector.get(trajectoryVector.size() - 1).m_position != setpointVector
					.get(setpointVector.size() - 1).m_x) {
				TrajectoryPoint trajectoryPoint = new TrajectoryPoint(0.0, 0.0, 0.0, currentTime);
				TrajectoryPoint lastTrajectoryPoint = trajectoryVector.get(trajectoryVector.size() - 1);
				trajectoryPoint.m_acceleration = 0.0;
				trajectoryPoint.m_currentVelocity = lastTrajectoryPoint.m_currentVelocity
						+ lastTrajectoryPoint.m_acceleration;
				trajectoryPoint.m_position = lastTrajectoryPoint.m_position
						+ (getDistanceTraveledWhileAccelerating(lastTrajectoryPoint.m_currentVelocity,
								trajectoryPoint.m_currentVelocity, Key.maxAcceleration) * directionConstant);
				trajectoryVector.add(trajectoryPoint);
			}
		} catch (ArrayIndexOutOfBoundsException a) {

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

}
