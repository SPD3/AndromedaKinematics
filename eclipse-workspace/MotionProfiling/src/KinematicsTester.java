import kinematics.KinematicsSimpler;
import kinematics.KinematicsSimpler.InvalidDimentionException;
import kinematics.KinematicsSimpler.Path;
import kinematics.KinematicsSimpler.Point;
import kinematics.KinematicsSimpler.TrajectoryPoint;

public class KinematicsTester {

	static KinematicsSimpler m_kinematicsSimpler = new KinematicsSimpler();

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
		
		
		createPositiveTrajectoryToPositiveTrajectory2ndPointLessThanTheDistanceCoveredWhileAcceleratingCase();
		
		createPositiveTrajectoryToPositiveTrajectoryGreaterThanTwiceTheDistanceCoveredWhileAcceleratingCase();
		
		createPositiveTrajectoryToPositiveTrajectory2ndPointLessThanTwiceTheDistanceCoveredWhileAcceleratingCase();
		
		createPositiveTrajectoryToPositiveTrajectory1stPointLessThanTwiceTheDistanceCoveredWhileAcceleratingCase();
		
		createPositiveTrajectoryToPositiveTrajectory1stPointLessThanTheDistanceCoveredWhileAcceleratingCase();
		
		createPositiveTrajectoryToPositiveTrajectoryLessThanTwiceTheDistanceCoveredWhileAcceleratingCase();
		
		createPositiveTrajectoryToPositiveTrajectoryLessThanTheDistanceCoveredWhileAcceleratingCase();
		
		createPositiveTrajectoryToPositiveTrajectoryLessThanAndGreaterThanTheDistanceCoveredWhileAcceleratingCase();
		
		
		createNegativeTrajectoryToNegativeTrajectory1stPointLessThanTheDistanceCoveredWhileAcceleratingCase();
		
		createNegativeTrajectoryToNegativeTrajectory1stPointLessThanTwiceTheDistanceCoveredWhileAcceleratingCase();
		
		createNegativeTrajectoryToNegativeTrajectory2ndPointLessThanTheDistanceCoveredWhileAcceleratingCase();
		
		createNegativeTrajectoryToNegativeTrajectory2ndPointLessThanTwiceTheDistanceCoveredWhileAcceleratingCase();
		
		createNegativeTrajectoryToNegativeTrajectoryGreaterThanTwiceTheDistanceCoveredWhileAcceleratingCase();
		
		createNegativeTrajectoryToNegativeTrajectoryLessThanAndGreaterThanTheDistanceCoveredWhileAcceleratingCase();
		
		createNegativeTrajectoryToNegativeTrajectoryLessThanTheDistanceCoveredWhileAcceleratingCase();
		
		createNegativeTrajectoryToNegativeTrajectoryLessThanTwiceTheDistanceCoveredWhileAcceleratingCase();
		
		
		createPositiveTrajectoryWithACustomMaxAccelerationGreaterThanTwiceTheDistanceCoveredWhileAcceleratingCase();
		
		createNegativeTrajectoryWithACustomMaxAccelerationGreaterThanTwiceTheDistanceCoveredWhileAcceleratingCase();
		
		createPositiveTrajectoryToPositiveTrajectoryGreaterThanTwiceTheDistanceCoveredWhileAcceleratingFirstPointWithCustomMaxVelocityCase();
		
		createPositiveTrajectoryToPositiveTrajectoryGreaterThanTwiceTheDistanceCoveredWhileAcceleratingSecondPointWithCustomMaxVelocityCase();
		
		}

	private static void createPositiveTrajectoryGreaterThanTheDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester = new KinematicsTester();
		try {
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(10));
			m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition | InvalidTrajectoryLogic e) {
			e.printStackTrace();
		}

	}

	private static void createPositiveTrajectoryLessThanTwiceTheDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(6));
			m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition | InvalidTrajectoryLogic e) {
			e.printStackTrace();
		}
	}

	private static void createNegativeTrajectoryGreaterThanDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester = new KinematicsTester();
		try {
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-10));
			m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition | InvalidTrajectoryLogic e) {
			e.printStackTrace();
		}
	}

	private static void createNegativeTrajectoryLessThanTwiceTheDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-6));
			m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition | InvalidTrajectoryLogic e) {
			e.printStackTrace();
		}
	}

	private static void createPositiveTrajectoryToNegativeTrajectoryGreaterThanTwiceTheDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester = new KinematicsTester();
		try {
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(10));
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-2));
			m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition | InvalidTrajectoryLogic e) {
			e.printStackTrace();
		}

	}

	private static void createPositiveTrajectoryToNegativeTrajectory2ndPointLessThanTwiceTheDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(10));
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(8));
			m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition | InvalidTrajectoryLogic e) {
			e.printStackTrace();
		}
	}

	private static void createNegativeTrajectoryToPositiveTrajectoryGreaterThanTwiceTheDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester = new KinematicsTester();
		try {
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-10));
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(2));
			m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition | InvalidTrajectoryLogic e) {
			e.printStackTrace();
		}
	}

	private static void createNegativeTrajectoryToPositiveTrajectory2ndPointLessThanTwiceTheDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-10));
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-8));
			m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition | InvalidTrajectoryLogic e) {
			e.printStackTrace();
		}
	}

	private static void createNegativeTrajectoryToPositiveTrajectoryLessThanTwiceTheDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-6));
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-2));
			m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition | InvalidTrajectoryLogic e) {
			e.printStackTrace();
		}
	}

	private static void createPositiveTrajectoryToNegativeTrajectoryLessThanTwiceTheDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(6));
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(2));
			m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition | InvalidTrajectoryLogic e) {
			e.printStackTrace();
		}
	}

	private static void createNegativeTrajectoryToNegativeTrajectoryGreaterThanTwiceTheDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-10));
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-20));
			m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition | InvalidTrajectoryLogic e) {
			e.printStackTrace();
		}
	}

	private static void createNegativeTrajectoryToNegativeTrajectory2ndPointLessThanTwiceTheDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-10));
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-16));
			m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition | InvalidTrajectoryLogic e) {
			e.printStackTrace();
		}
	}
	
	private static void createNegativeTrajectoryToNegativeTrajectory2ndPointLessThanTheDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-10));
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-12));
			m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition | InvalidTrajectoryLogic e) {
			e.printStackTrace();
		}
	}

	private static void createNegativeTrajectoryToNegativeTrajectory1stPointLessThanTwiceTheDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-6));
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-20));
			m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition | InvalidTrajectoryLogic e) {
			e.printStackTrace();
		}
	}
	
	private static void createNegativeTrajectoryToNegativeTrajectory1stPointLessThanTheDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-2));
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-20));
			m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition | InvalidTrajectoryLogic e) {
			e.printStackTrace();
		}
	}

	private static void createNegativeTrajectoryToNegativeTrajectoryLessThanTwiceTheDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-5));
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-7));
			m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition | InvalidTrajectoryLogic e) {
			e.printStackTrace();
		}
	}
	
	private static void createNegativeTrajectoryToNegativeTrajectoryLessThanTheDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-1));
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-3));
			m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition | InvalidTrajectoryLogic e) {
			e.printStackTrace();
		}
	}
	
	private static void createNegativeTrajectoryToNegativeTrajectoryLessThanAndGreaterThanTheDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-2));
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-6));
			m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}

		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition | InvalidTrajectoryLogic e) {
			e.printStackTrace();
		}
	}
	
	private static void createPositiveTrajectoryToPositiveTrajectoryGreaterThanTwiceTheDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(10));
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(20));
			m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition | InvalidTrajectoryLogic e) {
			e.printStackTrace();
		}
	}

	private static void createPositiveTrajectoryToPositiveTrajectory2ndPointLessThanTwiceTheDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(10));
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(16));
			m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition | InvalidTrajectoryLogic e) {
			e.printStackTrace();
		}
	}
	
	private static void createPositiveTrajectoryToPositiveTrajectory2ndPointLessThanTheDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(10));
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(12));
			m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition | InvalidTrajectoryLogic e) {
			e.printStackTrace();
		}
	}

	private static void createPositiveTrajectoryToPositiveTrajectory1stPointLessThanTwiceTheDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(6));
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(20));
			m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition | InvalidTrajectoryLogic e) {
			e.printStackTrace();
		}
	}
	
	private static void createPositiveTrajectoryToPositiveTrajectory1stPointLessThanTheDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(2));
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(20));
			m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition | InvalidTrajectoryLogic e) {
			e.printStackTrace();
		}
	}

	private static void createPositiveTrajectoryToPositiveTrajectoryLessThanTwiceTheDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(5));
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(7));
			m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition | InvalidTrajectoryLogic e) {
			e.printStackTrace();
		}
	}
	
	private static void createPositiveTrajectoryToPositiveTrajectoryLessThanTheDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(1));
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(3));
			m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition | InvalidTrajectoryLogic e) {
			e.printStackTrace();
		}
	}
	
	private static void createPositiveTrajectoryToPositiveTrajectoryLessThanAndGreaterThanTheDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(2));
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(6));
			m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition | InvalidTrajectoryLogic e) {
			e.printStackTrace();
		}
	}
	
	private static void createPositiveTrajectoryWithACustomMaxAccelerationGreaterThanTwiceTheDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(10), 1.0);
			
			m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition | InvalidTrajectoryLogic e) {
			e.printStackTrace();
		}
	}
	
	private static void createNegativeTrajectoryWithACustomMaxAccelerationGreaterThanTwiceTheDistanceCoveredWhileAcceleratingCase() {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-10), 1.0);
			
			m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition | InvalidTrajectoryLogic e) {
			e.printStackTrace();
		}
	}
	
	private static void createPositiveTrajectoryLessThanTwiceTheDistanceCoveredWhileAcceleratingWithACustomMaxAccelerationCase() {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(2), 1.0);
			m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition | InvalidTrajectoryLogic e) {
			e.printStackTrace();
		}
	}
	
	private static void createPositiveTrajectoryToPositiveTrajectoryGreaterThanTwiceTheDistanceCoveredWhileAcceleratingFirstPointWithCustomMaxVelocityCase() {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(10), 1.0);
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(20));
			m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition | InvalidTrajectoryLogic e) {
			e.printStackTrace();
		}
	}

	private static void createPositiveTrajectoryToPositiveTrajectory2ndPointLessThanTwiceTheDistanceCoveredWhileAcceleratingFirstPointWithCustomMaxVelocityCase() {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(10), 1.0);
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(11.5));
			m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition | InvalidTrajectoryLogic e) {
			e.printStackTrace();
		}
	}
	
	private static void createPositiveTrajectoryToPositiveTrajectory2ndPointLessThanTheDistanceCoveredWhileAcceleratingFirstPointWithCustomMaxVelocityCase() {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(10),1.0);
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(10.5));
			m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition | InvalidTrajectoryLogic e) {
			e.printStackTrace();
		}
	}

	private static void createPositiveTrajectoryToPositiveTrajectory1stPointLessThanTwiceTheDistanceCoveredWhileAcceleratingFirstPointWithCustomMaxVelocityCase() {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(1.5),1.0);
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(20));
			m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition | InvalidTrajectoryLogic e) {
			e.printStackTrace();
		}
	}
	
	private static void createPositiveTrajectoryToPositiveTrajectory1stPointLessThanTheDistanceCoveredWhileAcceleratingFirstPointWithCustomMaxVelocityCase() {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(0.5),1.0);
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(20));
			m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition | InvalidTrajectoryLogic e) {
			e.printStackTrace();
		}
	}

	private static void createPositiveTrajectoryToPositiveTrajectoryLessThanTwiceTheDistanceCoveredWhileAcceleratingFirstPointWithCustomMaxVelocityCase() {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(1.25),1.0);
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(1.5));
			m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition | InvalidTrajectoryLogic e) {
			e.printStackTrace();
		}
	}
	
	private static void createPositiveTrajectoryToPositiveTrajectoryLessThanTheDistanceCoveredWhileAcceleratingFirstPointWithCustomMaxVelocityCase() {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(0.25),1.0);
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(0.5));
			m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition | InvalidTrajectoryLogic e) {
			e.printStackTrace();
		}
	}
	
	private static void createPositiveTrajectoryToPositiveTrajectoryLessThanAndGreaterThanTheDistanceCoveredWhileAcceleratingFirstPointWithCustomMaxVelocityCase() {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(0.5),1.0);
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(1.5));
			m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition | InvalidTrajectoryLogic e) {
			e.printStackTrace();
		}
	}
	
	private static void createPositiveTrajectoryToPositiveTrajectoryGreaterThanTwiceTheDistanceCoveredWhileAcceleratingSecondPointWithCustomMaxVelocityCase() {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(10));
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(20),1.0);
			m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition | InvalidTrajectoryLogic e) {
			e.printStackTrace();
		}
	}

	private static void createPositiveTrajectoryToPositiveTrajectory2ndPointLessThanTwiceTheDistanceCoveredWhileAcceleratingSecondPointWithCustomMaxVelocityCase() {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(10));
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(16),1.0);
			m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition | InvalidTrajectoryLogic e) {
			e.printStackTrace();
		}
	}
	
	private static void createPositiveTrajectoryToPositiveTrajectory2ndPointLessThanTheDistanceCoveredWhileAcceleratingSecondPointWithCustomMaxVelocityCase() {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(10));
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(12),1.0);
			m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition | InvalidTrajectoryLogic e) {
			e.printStackTrace();
		}
	}

	private static void createPositiveTrajectoryToPositiveTrajectory1stPointLessThanTwiceTheDistanceCoveredWhileAcceleratingSecondPointWithCustomMaxVelocityCase() {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(6));
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(20),1.0);
			m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition | InvalidTrajectoryLogic e) {
			e.printStackTrace();
		}
	}
	
	private static void createPositiveTrajectoryToPositiveTrajectory1stPointLessThanTheDistanceCoveredWhileAcceleratingSecondPointWithCustomMaxVelocityCase() {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(2));
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(20),1.0);
			m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition | InvalidTrajectoryLogic e) {
			e.printStackTrace();
		}
	}

	private static void createPositiveTrajectoryToPositiveTrajectoryLessThanTwiceTheDistanceCoveredWhileAcceleratingSecondPointWithCustomMaxVelocityCase() {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(5));
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(7),1.0);
			m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition | InvalidTrajectoryLogic e) {
			e.printStackTrace();
		}
	}
	
	private static void createPositiveTrajectoryToPositiveTrajectoryLessThanTheDistanceCoveredWhileAcceleratingSecondPointWithCustomMaxVelocityCase() {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(1));
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(3),1.0);
			m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition | InvalidTrajectoryLogic e) {
			e.printStackTrace();
		}
	}
	
	private static void createPositiveTrajectoryToPositiveTrajectoryLessThanAndGreaterThanTheDistanceCoveredWhileAcceleratingSecondPointWithCustomMaxVelocityCase() {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();
		try {
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(2));
			m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(6),1.0);
			m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		} catch (InvalidDimentionException e) {
			e.printStackTrace();
		}
		
		try {
			checkTrajectoryPath(myPath, kinematicsTester1);
		} catch (InvalidVelocityException | InvalidNextVelocityFromLastAcceleration | InvalidAccelerationException
				| InvalidFinalPosition | InvalidTrajectoryLogic e) {
			e.printStackTrace();
		}
	}
	
	private static void checkTrajectoryPath(Path Key, KinematicsTester kinematicsTester)
			throws InvalidVelocityException, InvalidNextVelocityFromLastAcceleration, InvalidAccelerationException,
			InvalidFinalPosition, InvalidTrajectoryLogic {
		
		checkAcceleration(Key, kinematicsTester);
		
		checkVelocity(Key, kinematicsTester);
		
		checkVelocityTakingCustomMaxVelocityIntoAccount(Key, kinematicsTester);
		
		checkFinalPosition(Key, kinematicsTester);
		
		checkTrajectoryLogic(Key, kinematicsTester);
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
		try {
		if (Key.getTrajectoryVector().get(Key.getTrajectoryVector().size() - 1).m_position
				- Key.getSetpointVector().get(Key.getSetpointVector().size() - 1).getm_X() > 0.1
				|| Key.getTrajectoryVector().get(Key.getTrajectoryVector().size() - 1).m_position
						- Key.getSetpointVector().get(Key.getSetpointVector().size() - 1).getm_X() < -0.1) {
			errMesage = "The final position of the trajectory path does not match the final position of the setpoint path!";
			invalidFinalPosition = kinematicsTester.new InvalidFinalPosition(errMesage);
			throw invalidFinalPosition;
		}
		}catch(ArrayIndexOutOfBoundsException q) {
			errMesage = "There are no points in this path!";
			invalidFinalPosition = kinematicsTester.new InvalidFinalPosition(errMesage);
			throw invalidFinalPosition;
		}
	}

	private static void checkNextVelocityFromLastAcceleration(Path Key, KinematicsTester kinematicsTester)
			throws InvalidNextVelocityFromLastAcceleration {
		InvalidNextVelocityFromLastAcceleration invalidNextVelocityFromLastAcceleration;
		String errMessage;
		for (int i = 0; i < Key.getTrajectoryVector().size(); i++) {
			TrajectoryPoint currentPoint = Key.getTrajectoryVector().get(i);
			TrajectoryPoint lastPoint;
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
	
	private static void checkVelocityTakingCustomMaxVelocityIntoAccount(Path Key, KinematicsTester kinematicsTester) throws InvalidVelocityException {
		InvalidVelocityException invalidVelocityException;
		String errMessage;
		int currentTrajectoryIndex = 0;
		for(int i=0; i < Key.getSetpointVector().size(); i++) {
			Point setpoint = Key.getSetpointVector().get(i);
			for(int i1 = currentTrajectoryIndex; i1 < Key.getTrajectoryVector().size(); i1++) {
				TrajectoryPoint trajectoryPoint = Key.getTrajectoryVector().get(i1);
				
				if(Math.abs(setpoint.getMaxVelocity()) < Math.abs(trajectoryPoint.m_currentVelocity)) {
					errMessage = "The velocity at time: " + trajectoryPoint.m_timestamp + " is above the maximum velocity specified by the user which is: " + setpoint.getMaxVelocity();
					invalidVelocityException = kinematicsTester.new InvalidVelocityException(errMessage);
					throw invalidVelocityException;
				}
				if(trajectoryPoint.m_position - setpoint.getm_X() < 0.001 && trajectoryPoint.m_position - setpoint.getm_X() > -0.001) {
					break;
				}
				currentTrajectoryIndex++;
			}
		}
	}
	
	private static void checkTrajectoryLogic(Path Key, KinematicsTester kinematicsTester) throws InvalidTrajectoryLogic {
		InvalidTrajectoryLogic invalidTrajectoryLogic;
		String errMessage;
		int currentTrajectoryPointIndex = 0;
		for (int i = 0; i < Key.getSetpointVector().size(); i++) {
			Point setpoint = Key.getSetpointVector().get(i);
			Point nextSetpoint;
			Point lastSetpoint = m_kinematicsSimpler.new Point(0,0);
			boolean traveledInAPositiveDirection;
			boolean willTravelInAPositiveDirection;
			TrajectoryPoint trajectoryPoint = Key.getTrajectoryVector().get(currentTrajectoryPointIndex);
			int initialCurrentTrajectoryPointIndex = currentTrajectoryPointIndex;
			for(int a = currentTrajectoryPointIndex; a < Key.getTrajectoryVector().size(); a++) {
				currentTrajectoryPointIndex++;
				trajectoryPoint =  Key.getTrajectoryVector().get(a);
				if(trajectoryPoint.m_position - setpoint.getm_X() < 0.01 && trajectoryPoint.m_position - setpoint.getm_X() > -0.01) {
					
					break;
				}
			}
			
			if(currentTrajectoryPointIndex == (Key.getTrajectoryVector().size())) {
				currentTrajectoryPointIndex = initialCurrentTrajectoryPointIndex;
				continue;
			}
	
			try{
				nextSetpoint = Key.getSetpointVector().get(i+1);
			}catch(ArrayIndexOutOfBoundsException a) {
				continue;
			}
			try{
				lastSetpoint = Key.getSetpointVector().get(i-1);
			}catch(ArrayIndexOutOfBoundsException a) {
				
			}
			
			if(lastSetpoint.getm_X() < setpoint.getm_X()) {
				traveledInAPositiveDirection = true;
			}else {
				traveledInAPositiveDirection = false;
			}
			
			if(setpoint.getm_X() < nextSetpoint.getm_X()) {
				willTravelInAPositiveDirection = true;
			}else {
				willTravelInAPositiveDirection = false;
			}
			if(trajectoryPoint.m_timestamp == 0.0) {
				continue;
			}
			
			if((traveledInAPositiveDirection && willTravelInAPositiveDirection) || (!traveledInAPositiveDirection && !willTravelInAPositiveDirection)) {
				if(trajectoryPoint.m_currentVelocity < 0.1 && trajectoryPoint.m_currentVelocity > -0.1) {
					errMessage = "The point at time: " + trajectoryPoint.m_timestamp + " is a point in which the direction is not changing however the velocity is 0!";
					invalidTrajectoryLogic = kinematicsTester.new InvalidTrajectoryLogic(errMessage);
					throw invalidTrajectoryLogic;
				}
			}else {
				if(trajectoryPoint.m_currentVelocity > 0.1 || trajectoryPoint.m_currentVelocity < -0.1) {
					errMessage = "The point at time: " + trajectoryPoint.m_timestamp + " is a point in which the direction is changing however the velocity is not 0!";
					invalidTrajectoryLogic = kinematicsTester.new InvalidTrajectoryLogic(errMessage);
					throw invalidTrajectoryLogic;
				}
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
	
	public class InvalidTrajectoryLogic extends Exception {
		public InvalidTrajectoryLogic(String errMessage) {
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
		System.out.println("");
	}
	
}
