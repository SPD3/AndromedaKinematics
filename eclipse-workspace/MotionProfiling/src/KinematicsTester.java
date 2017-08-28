import kinematics.KinematicsSimpler;
import kinematics.KinematicsSimpler.InvalidDimentionException;
import kinematics.KinematicsSimpler.Path;
import kinematics.KinematicsSimpler.TrajectoryPoint;

public class KinematicsTester {

	static KinematicsSimpler m_kinematicsSmallSteps = new KinematicsSimpler();

	public static void main(String[] args) {

		createPositiveTrajectoryGreaterThanTheDistanceCoveredWhileAcceleratingCase();

		createPositiveTrajectoryLessThanTwiceTheDistanceCoveredWhileAcceleratingCase();

		createNegativeTrajectoryGreaterThanDistanceCoveredWhileAcceleratingCase();

		createNegativeTrajectoryLessThanTwiceTheDistanceCoveredWhileAcceleratingCase();

		createPositiveTrajectoryToNegativeTrajectoryGreaterThanTwiceTheDistanceCoveredWhileAcceleratingCase();

		createNegativeTrajectoryToPositiveTrajectoryGreaterThanTwiceTheDistanceCoveredWhileAcceleratingCase();

		createPositiveTrajectoryToNegativeTrajectory2ndPointLessThanTwiceTheDistanceCoveredWhileAcceleratingCase();

		createNegativeTrajectoryToPositiveTrajectory2ndPointLessThanTwiceTheDistanceCoveredWhileAcceleratingCase();

		createNegativeTrajectoryToPositiveTrajectoryLessThanTwiceTheDistanceCoveredWhileAcceleratingCase();

		createPositiveTrajectoryToNegativeTrajectoryLessThanTwiceTheDistanceCoveredWhileAcceleratingCase();
		
		createPositiveTrajectoryToPositiveTrajectoryGreaterThanTwiceTheDistanceCoveredWhileAcceleratingCase();
		
		createPositiveTrajectoryToPositiveTrajectory2ndPointLessThanTwiceTheDistanceCoveredWhileAcceleratingCase();
	}

	private static void createPositiveTrajectoryGreaterThanTheDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSmallSteps.new Path();
		KinematicsTester kinematicsTester = new KinematicsTester();
		try {
			m_kinematicsSmallSteps.addPointToPath(myPath, m_kinematicsSmallSteps.new Point(10));
			m_kinematicsSmallSteps.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void createPositiveTrajectoryLessThanTwiceTheDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSmallSteps.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSmallSteps.addPointToPath(myPath, m_kinematicsSmallSteps.new Point(6));
			m_kinematicsSmallSteps.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void createNegativeTrajectoryGreaterThanDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSmallSteps.new Path();
		KinematicsTester kinematicsTester = new KinematicsTester();
		try {
			m_kinematicsSmallSteps.addPointToPath(myPath, m_kinematicsSmallSteps.new Point(-10));
			m_kinematicsSmallSteps.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void createNegativeTrajectoryLessThanTwiceTheDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSmallSteps.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSmallSteps.addPointToPath(myPath, m_kinematicsSmallSteps.new Point(-6));
			m_kinematicsSmallSteps.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void createPositiveTrajectoryToNegativeTrajectoryGreaterThanTwiceTheDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSmallSteps.new Path();
		KinematicsTester kinematicsTester = new KinematicsTester();
		try {
			m_kinematicsSmallSteps.addPointToPath(myPath, m_kinematicsSmallSteps.new Point(10));
			m_kinematicsSmallSteps.addPointToPath(myPath, m_kinematicsSmallSteps.new Point(-2));
			m_kinematicsSmallSteps.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void createPositiveTrajectoryToNegativeTrajectory2ndPointLessThanTwiceTheDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSmallSteps.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSmallSteps.addPointToPath(myPath, m_kinematicsSmallSteps.new Point(10));
			m_kinematicsSmallSteps.addPointToPath(myPath, m_kinematicsSmallSteps.new Point(8));
			m_kinematicsSmallSteps.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void createNegativeTrajectoryToPositiveTrajectoryGreaterThanTwiceTheDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSmallSteps.new Path();
		KinematicsTester kinematicsTester = new KinematicsTester();
		try {
			m_kinematicsSmallSteps.addPointToPath(myPath, m_kinematicsSmallSteps.new Point(-10));
			m_kinematicsSmallSteps.addPointToPath(myPath, m_kinematicsSmallSteps.new Point(2));
			m_kinematicsSmallSteps.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void createNegativeTrajectoryToPositiveTrajectory2ndPointLessThanTwiceTheDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSmallSteps.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSmallSteps.addPointToPath(myPath, m_kinematicsSmallSteps.new Point(-10));
			m_kinematicsSmallSteps.addPointToPath(myPath, m_kinematicsSmallSteps.new Point(-8));
			m_kinematicsSmallSteps.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void createNegativeTrajectoryToPositiveTrajectoryLessThanTwiceTheDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSmallSteps.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSmallSteps.addPointToPath(myPath, m_kinematicsSmallSteps.new Point(-6));
			m_kinematicsSmallSteps.addPointToPath(myPath, m_kinematicsSmallSteps.new Point(-2));
			m_kinematicsSmallSteps.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void createPositiveTrajectoryToNegativeTrajectoryLessThanTwiceTheDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSmallSteps.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSmallSteps.addPointToPath(myPath, m_kinematicsSmallSteps.new Point(6));
			m_kinematicsSmallSteps.addPointToPath(myPath, m_kinematicsSmallSteps.new Point(2));
			m_kinematicsSmallSteps.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void createNegativeTrajectoryToNegativeTrajectoryGreaterThanTwiceTheDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSmallSteps.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSmallSteps.addPointToPath(myPath, m_kinematicsSmallSteps.new Point(-10));
			m_kinematicsSmallSteps.addPointToPath(myPath, m_kinematicsSmallSteps.new Point(-20));
			m_kinematicsSmallSteps.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		printTrajectory(myPath);
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void createNegativeTrajectoryToNegativeTrajectory2ndPointLessThanTwiceTheDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSmallSteps.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSmallSteps.addPointToPath(myPath, m_kinematicsSmallSteps.new Point(-10));
			m_kinematicsSmallSteps.addPointToPath(myPath, m_kinematicsSmallSteps.new Point(-12));
			m_kinematicsSmallSteps.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		printTrajectory(myPath);
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void createNegativeTrajectoryToNegativeTrajectory1stPointLessThanTwiceTheDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSmallSteps.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSmallSteps.addPointToPath(myPath, m_kinematicsSmallSteps.new Point(-6));
			m_kinematicsSmallSteps.addPointToPath(myPath, m_kinematicsSmallSteps.new Point(-20));
			m_kinematicsSmallSteps.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		printTrajectory(myPath);
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void createNegativeTrajectoryToNegativeTrajectoryLessThanTwiceTheDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSmallSteps.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSmallSteps.addPointToPath(myPath, m_kinematicsSmallSteps.new Point(-2));
			m_kinematicsSmallSteps.addPointToPath(myPath, m_kinematicsSmallSteps.new Point(-6));
			m_kinematicsSmallSteps.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		printTrajectory(myPath);
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void createPositiveTrajectoryToPositiveTrajectoryGreaterThanTwiceTheDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSmallSteps.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSmallSteps.addPointToPath(myPath, m_kinematicsSmallSteps.new Point(10));
			m_kinematicsSmallSteps.addPointToPath(myPath, m_kinematicsSmallSteps.new Point(20));
			m_kinematicsSmallSteps.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
	
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void createPositiveTrajectoryToPositiveTrajectory2ndPointLessThanTwiceTheDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSmallSteps.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSmallSteps.addPointToPath(myPath, m_kinematicsSmallSteps.new Point(10));
			m_kinematicsSmallSteps.addPointToPath(myPath, m_kinematicsSmallSteps.new Point(12));
			m_kinematicsSmallSteps.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		printTrajectory(myPath);
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void createPositiveTrajectoryToPositiveTrajectory1stPointLessThanTwiceTheDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSmallSteps.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSmallSteps.addPointToPath(myPath, m_kinematicsSmallSteps.new Point(6));
			m_kinematicsSmallSteps.addPointToPath(myPath, m_kinematicsSmallSteps.new Point(20));
			m_kinematicsSmallSteps.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		printTrajectory(myPath);
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void createPositiveTrajectoryToPositiveTrajectoryLessThanTwiceTheDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSmallSteps.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSmallSteps.addPointToPath(myPath, m_kinematicsSmallSteps.new Point(2));
			m_kinematicsSmallSteps.addPointToPath(myPath, m_kinematicsSmallSteps.new Point(6));
			m_kinematicsSmallSteps.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		printTrajectory(myPath);
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void checkTrajectoryPath(Path Key, KinematicsTester kinematicsTester)
			throws InvalidVelocityException, InvalidNextVelocityFromLastAcceleration, InvalidAccelerationException,
			InvalidFinalPosition {
		checkAcceleration(Key, kinematicsTester);
		checkVelocity(Key, kinematicsTester);
		checkFinalPosition(Key, kinematicsTester);
	}

	private static void checkVelocity(Path Key, KinematicsTester kinematicsTester)
			throws InvalidVelocityException, InvalidNextVelocityFromLastAcceleration {
		InvalidVelocityException invalidVelocityException;
		String errMessage;
		for (int i = 0; i < Key.getTrajectoryVector().size(); i++) {
			TrajectoryPoint currentPoint = Key.getTrajectoryVector().get(i);
			if (currentPoint.m_currentVelocity > Key.getMaxVelocity()
					|| currentPoint.m_currentVelocity < -Key.getMaxVelocity()) {
				errMessage = "The Current Velocity at time: " + currentPoint.m_timestamp
						+ " is above the maximum velocity!";
				invalidVelocityException = kinematicsTester.new InvalidVelocityException(errMessage);
				throw invalidVelocityException;
			}
		}
		checkNextVelocityFromLastAcceleration(Key, kinematicsTester);
	}

	private static void checkAcceleration(Path Key, KinematicsTester kinematicsTester)
			throws InvalidAccelerationException {
		InvalidAccelerationException invalidAccelerationException;
		String errMessage;
		for (int i = 0; i < Key.getTrajectoryVector().size(); i++) {
			TrajectoryPoint currentPoint = Key.getTrajectoryVector().get(i);
			if (currentPoint.m_acceleration > (Key.getmaxAcceleration()
					* KinematicsSimpler.getTrajectoryPointInterval() + 0.1)
					|| currentPoint.m_acceleration < (-Key.getmaxAcceleration()
							* KinematicsSimpler.getTrajectoryPointInterval() - 0.1)) {
				errMessage = "The Current Acceleration at time: " + currentPoint.m_timestamp
						+ " is above the maximum acceleration!";
				invalidAccelerationException = kinematicsTester.new InvalidAccelerationException(errMessage);
				throw invalidAccelerationException;
			}
		}
	}

	private static void checkFinalPosition(Path Key, KinematicsTester kinematicsTester) throws InvalidFinalPosition {
		InvalidFinalPosition invalidFinalPosition;
		String errMesage;
		if (Key.getTrajectoryVector().get(Key.getTrajectoryVector().size() - 1).m_position
				- Key.getSetpointVector().get(Key.getSetpointVector().size() - 1).getm_X() > 0.1
				|| Key.getTrajectoryVector().get(Key.getTrajectoryVector().size() - 1).m_position
						- Key.getSetpointVector().get(Key.getSetpointVector().size() - 1).getm_X() < -0.1) {
			errMesage = "The final position of the trajectory path does not match the final position of the setpoint path!";
			invalidFinalPosition = kinematicsTester.new InvalidFinalPosition(errMesage);
			throw invalidFinalPosition;
		}
	}

	private static void checkNextVelocityFromLastAcceleration(Path Key, KinematicsTester kinematicsTester)
			throws InvalidNextVelocityFromLastAcceleration {
		for (int i = 0; i < Key.getTrajectoryVector().size(); i++) {
			TrajectoryPoint currentPoint = Key.getTrajectoryVector().get(i);
			TrajectoryPoint lastPoint;
			InvalidNextVelocityFromLastAcceleration invalidNextVelocityFromLastAcceleration;
			String errMessage;
			try {
				lastPoint = Key.getTrajectoryVector().get(i - 1);
			} catch (ArrayIndexOutOfBoundsException a) {
				continue;
			}
			if (lastPoint.m_currentVelocity + lastPoint.m_acceleration - currentPoint.m_currentVelocity > 0.5
					|| lastPoint.m_currentVelocity + lastPoint.m_acceleration - currentPoint.m_currentVelocity < -0.5) {
				errMessage = "The Current Acceleration added to the Current Velocity at time: " + lastPoint.m_timestamp
						+ " Do not equal the next Velocity at time: " + currentPoint.m_timestamp;
				invalidNextVelocityFromLastAcceleration = kinematicsTester.new InvalidNextVelocityFromLastAcceleration(
						errMessage);
				throw invalidNextVelocityFromLastAcceleration;
			}
		}
	}

	public class InvalidVelocityException extends Exception {
		public InvalidVelocityException(String errMessage) {
			super(errMessage);
		}

		private static final long serialVersionUID = 1L;

	}

	public class InvalidAccelerationException extends Exception {
		public InvalidAccelerationException(String errMessage) {
			super(errMessage);
		}

		private static final long serialVersionUID = 1L;

	}

	public class InvalidNextVelocityFromLastAcceleration extends Exception {
		public InvalidNextVelocityFromLastAcceleration(String errMessage) {
			super(errMessage);
		}

		private static final long serialVersionUID = 1L;
	}

	public class InvalidFinalPosition extends Exception {
		public InvalidFinalPosition(String errMessage) {
			super(errMessage);
		}

		private static final long serialVersionUID = 1L;

	}

	private static void printTrajectory(Path Key) {
		System.out.println("Trajectory Point: [vel, acc, pos, time]");
		for (int i = 0; i < Key.getTrajectoryVector().size(); i++) {
			System.out.println("Trajectory Point: [" + Key.getTrajectoryVector().get(i).m_currentVelocity + ", "
					+ Key.getTrajectoryVector().get(i).m_acceleration + ", "
					+ Key.getTrajectoryVector().get(i).m_position + ", " + Key.getTrajectoryVector().get(i).m_timestamp
					+ "]");
		}
		System.out.print("The Setpoints are: ");
		for (int i = 0; i < Key.getSetpointVector().size(); i++) {
			if(i == 0) {
				System.out.print(Key.getSetpointVector().get(i).getm_X());
			}else {
				System.out.print(", " + Key.getSetpointVector().get(i).getm_X());
			}
		}
		System.out.println("");
	}
}
