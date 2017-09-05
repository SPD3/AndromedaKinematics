import kinematics.KinematicsSimpler;
import kinematics.KinematicsSimpler.InvalidDimentionException;
import kinematics.KinematicsSimpler.Path;
import kinematics.KinematicsSimpler.Point;
import kinematics.KinematicsSimpler.TrajectoryPoint;

public class KinematicsTester {

	static KinematicsSimpler m_kinematicsSimpler = new KinematicsSimpler();

	public static void main(String[] args) {

		try {
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

			createPositiveTrajectoryWithACustomMaxVelocityGreaterThanTwiceTheDistanceCoveredWhileAcceleratingCase();

			createNegativeTrajectoryWithACustomMaxVelocityGreaterThanTwiceTheDistanceCoveredWhileAcceleratingCase();

			createPositiveTrajectoryLessThanTwiceTheDistanceCoveredWhileAcceleratingWithACustomMaxVelocityCase();

			createPositiveTrajectoryToPositiveTrajectoryGreaterThanTwiceTheDistanceCoveredWhileAcceleratingFirstPointWithCustomMaxVelocityCase();

			createPositiveTrajectoryToPositiveTrajectoryGreaterThanTwiceTheDistanceCoveredWhileAcceleratingSecondPointWithCustomMaxVelocityCase();

			createPositiveTrajectoryToPositiveTrajectory2ndPointLessThanTwiceTheDistanceCoveredWhileAcceleratingFirstPointWithCustomMaxVelocityCase();

			createPositiveTrajectoryToPositiveTrajectory2ndPointLessThanTheDistanceCoveredWhileAcceleratingFirstPointWithCustomMaxVelocityCase();
			
			createPositiveTrajectoryToPositiveTrajectory1stPointLessThanTwiceTheDistanceCoveredWhileAcceleratingFirstPointWithCustomMaxVelocityCase();
			
			createPositiveTrajectoryToPositiveTrajectory1stPointLessThanTheDistanceCoveredWhileAcceleratingFirstPointWithCustomMaxVelocityCase();
			
			createPositiveTrajectoryToPositiveTrajectoryLessThanTwiceTheDistanceCoveredWhileAcceleratingFirstPointWithCustomMaxVelocityCase();
			
			createPositiveTrajectoryToPositiveTrajectoryLessThanTheDistanceCoveredWhileAcceleratingFirstPointWithCustomMaxVelocityCase();
			
			createPositiveTrajectoryToPositiveTrajectoryLessThanAndGreaterThanTheDistanceCoveredWhileAcceleratingFirstPointWithCustomMaxVelocityCase();
			
			createPositiveTrajectoryToPositiveTrajectory2ndPointLessThanTwiceTheDistanceCoveredWhileAcceleratingSecondPointWithCustomMaxVelocityCase();
		} catch (InvalidDimentionException | InvalidVelocityException | InvalidNextVelocityFromLastAcceleration
				| InvalidAccelerationException | InvalidFinalPosition | InvalidTrajectoryLogic e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void createPositiveTrajectoryGreaterThanTheDistanceCoveredWhileAcceleratingCase()
			throws InvalidDimentionException, InvalidVelocityException, InvalidNextVelocityFromLastAcceleration,
			InvalidAccelerationException, InvalidFinalPosition, InvalidTrajectoryLogic {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester = new KinematicsTester();

		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(10));
		m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);

		checkTrajectoryPath(myPath, kinematicsTester);

	}

	private static void createPositiveTrajectoryLessThanTwiceTheDistanceCoveredWhileAcceleratingCase()
			throws InvalidDimentionException, InvalidVelocityException, InvalidNextVelocityFromLastAcceleration,
			InvalidAccelerationException, InvalidFinalPosition, InvalidTrajectoryLogic {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();

		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(6));
		m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);

		checkTrajectoryPath(myPath, kinematicsTester1);
	}

	private static void createNegativeTrajectoryGreaterThanDistanceCoveredWhileAcceleratingCase()
			throws InvalidDimentionException, InvalidVelocityException, InvalidNextVelocityFromLastAcceleration,
			InvalidAccelerationException, InvalidFinalPosition, InvalidTrajectoryLogic {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester = new KinematicsTester();

		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-10));
		m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);

		checkTrajectoryPath(myPath, kinematicsTester);

	}

	private static void createNegativeTrajectoryLessThanTwiceTheDistanceCoveredWhileAcceleratingCase()
			throws InvalidDimentionException, InvalidVelocityException, InvalidNextVelocityFromLastAcceleration,
			InvalidAccelerationException, InvalidFinalPosition, InvalidTrajectoryLogic {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();

		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-6));
		m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);

		checkTrajectoryPath(myPath, kinematicsTester1);

	}

	private static void createPositiveTrajectoryToNegativeTrajectoryGreaterThanTwiceTheDistanceCoveredWhileAcceleratingCase()
			throws InvalidDimentionException, InvalidVelocityException, InvalidNextVelocityFromLastAcceleration,
			InvalidAccelerationException, InvalidFinalPosition, InvalidTrajectoryLogic {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester = new KinematicsTester();

		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(10));
		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-2));
		m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);

		checkTrajectoryPath(myPath, kinematicsTester);

	}

	private static void createPositiveTrajectoryToNegativeTrajectory2ndPointLessThanTwiceTheDistanceCoveredWhileAcceleratingCase()
			throws InvalidDimentionException, InvalidVelocityException, InvalidNextVelocityFromLastAcceleration,
			InvalidAccelerationException, InvalidFinalPosition, InvalidTrajectoryLogic {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();

		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(10));
		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(8));
		m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);

		checkTrajectoryPath(myPath, kinematicsTester1);

	}

	private static void createNegativeTrajectoryToPositiveTrajectoryGreaterThanTwiceTheDistanceCoveredWhileAcceleratingCase()
			throws InvalidDimentionException, InvalidVelocityException, InvalidNextVelocityFromLastAcceleration,
			InvalidAccelerationException, InvalidFinalPosition, InvalidTrajectoryLogic {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester = new KinematicsTester();

		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-10));
		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(2));
		m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);

		checkTrajectoryPath(myPath, kinematicsTester);

	}

	private static void createNegativeTrajectoryToPositiveTrajectory2ndPointLessThanTwiceTheDistanceCoveredWhileAcceleratingCase()
			throws InvalidDimentionException, InvalidVelocityException, InvalidNextVelocityFromLastAcceleration,
			InvalidAccelerationException, InvalidFinalPosition, InvalidTrajectoryLogic {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();

		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-10));
		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-8));
		m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);

		checkTrajectoryPath(myPath, kinematicsTester1);

	}

	private static void createNegativeTrajectoryToPositiveTrajectoryLessThanTwiceTheDistanceCoveredWhileAcceleratingCase()
			throws InvalidDimentionException, InvalidVelocityException, InvalidNextVelocityFromLastAcceleration,
			InvalidAccelerationException, InvalidFinalPosition, InvalidTrajectoryLogic {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();

		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-6));
		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-2));
		m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);

		checkTrajectoryPath(myPath, kinematicsTester1);

	}

	private static void createPositiveTrajectoryToNegativeTrajectoryLessThanTwiceTheDistanceCoveredWhileAcceleratingCase()
			throws InvalidDimentionException, InvalidVelocityException, InvalidNextVelocityFromLastAcceleration,
			InvalidAccelerationException, InvalidFinalPosition, InvalidTrajectoryLogic {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();

		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(6));
		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(2));
		m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);

		checkTrajectoryPath(myPath, kinematicsTester1);

	}

	private static void createNegativeTrajectoryToNegativeTrajectoryGreaterThanTwiceTheDistanceCoveredWhileAcceleratingCase()
			throws InvalidDimentionException, InvalidVelocityException, InvalidNextVelocityFromLastAcceleration,
			InvalidAccelerationException, InvalidFinalPosition, InvalidTrajectoryLogic {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();

		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-10));
		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-20));
		m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);

		checkTrajectoryPath(myPath, kinematicsTester1);

	}

	private static void createNegativeTrajectoryToNegativeTrajectory2ndPointLessThanTwiceTheDistanceCoveredWhileAcceleratingCase()
			throws InvalidDimentionException, InvalidVelocityException, InvalidNextVelocityFromLastAcceleration,
			InvalidAccelerationException, InvalidFinalPosition, InvalidTrajectoryLogic {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();

		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-10));
		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-16));
		m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);

		checkTrajectoryPath(myPath, kinematicsTester1);

	}

	private static void createNegativeTrajectoryToNegativeTrajectory2ndPointLessThanTheDistanceCoveredWhileAcceleratingCase()
			throws InvalidDimentionException, InvalidVelocityException, InvalidNextVelocityFromLastAcceleration,
			InvalidAccelerationException, InvalidFinalPosition, InvalidTrajectoryLogic {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();

		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-10));
		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-12));
		m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);

		checkTrajectoryPath(myPath, kinematicsTester1);

	}

	private static void createNegativeTrajectoryToNegativeTrajectory1stPointLessThanTwiceTheDistanceCoveredWhileAcceleratingCase()
			throws InvalidDimentionException, InvalidVelocityException, InvalidNextVelocityFromLastAcceleration,
			InvalidAccelerationException, InvalidFinalPosition, InvalidTrajectoryLogic {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();

		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-6));
		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-20));
		m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);

		checkTrajectoryPath(myPath, kinematicsTester1);

	}

	private static void createNegativeTrajectoryToNegativeTrajectory1stPointLessThanTheDistanceCoveredWhileAcceleratingCase()
			throws InvalidDimentionException, InvalidVelocityException, InvalidNextVelocityFromLastAcceleration,
			InvalidAccelerationException, InvalidFinalPosition, InvalidTrajectoryLogic {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();

		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-2));
		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-20));
		m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);

		checkTrajectoryPath(myPath, kinematicsTester1);

	}

	private static void createNegativeTrajectoryToNegativeTrajectoryLessThanTwiceTheDistanceCoveredWhileAcceleratingCase()
			throws InvalidDimentionException, InvalidVelocityException, InvalidNextVelocityFromLastAcceleration,
			InvalidAccelerationException, InvalidFinalPosition, InvalidTrajectoryLogic {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();

		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-5));
		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-7));
		m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);

		checkTrajectoryPath(myPath, kinematicsTester1);

	}

	private static void createNegativeTrajectoryToNegativeTrajectoryLessThanTheDistanceCoveredWhileAcceleratingCase()
			throws InvalidDimentionException, InvalidVelocityException, InvalidNextVelocityFromLastAcceleration,
			InvalidAccelerationException, InvalidFinalPosition, InvalidTrajectoryLogic {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();

		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-1));
		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-3));
		m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);

		checkTrajectoryPath(myPath, kinematicsTester1);

	}

	private static void createNegativeTrajectoryToNegativeTrajectoryLessThanAndGreaterThanTheDistanceCoveredWhileAcceleratingCase()
			throws InvalidDimentionException, InvalidVelocityException, InvalidNextVelocityFromLastAcceleration,
			InvalidAccelerationException, InvalidFinalPosition, InvalidTrajectoryLogic {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();

		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-2));
		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-6));
		m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);

		checkTrajectoryPath(myPath, kinematicsTester1);

	}

	private static void createPositiveTrajectoryToPositiveTrajectoryGreaterThanTwiceTheDistanceCoveredWhileAcceleratingCase()
			throws InvalidDimentionException, InvalidVelocityException, InvalidNextVelocityFromLastAcceleration,
			InvalidAccelerationException, InvalidFinalPosition, InvalidTrajectoryLogic {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();

		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(10));
		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(20));
		m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);

		checkTrajectoryPath(myPath, kinematicsTester1);

	}

	private static void createPositiveTrajectoryToPositiveTrajectory2ndPointLessThanTwiceTheDistanceCoveredWhileAcceleratingCase()
			throws InvalidDimentionException, InvalidVelocityException, InvalidNextVelocityFromLastAcceleration,
			InvalidAccelerationException, InvalidFinalPosition, InvalidTrajectoryLogic {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();

		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(10));
		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(16));
		m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);

		checkTrajectoryPath(myPath, kinematicsTester1);

	}

	private static void createPositiveTrajectoryToPositiveTrajectory2ndPointLessThanTheDistanceCoveredWhileAcceleratingCase()
			throws InvalidDimentionException, InvalidVelocityException, InvalidNextVelocityFromLastAcceleration,
			InvalidAccelerationException, InvalidFinalPosition, InvalidTrajectoryLogic {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();

		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(10));
		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(12));
		m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);

		checkTrajectoryPath(myPath, kinematicsTester1);

	}

	private static void createPositiveTrajectoryToPositiveTrajectory1stPointLessThanTwiceTheDistanceCoveredWhileAcceleratingCase()
			throws InvalidDimentionException, InvalidVelocityException, InvalidNextVelocityFromLastAcceleration,
			InvalidAccelerationException, InvalidFinalPosition, InvalidTrajectoryLogic {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();

		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(6));
		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(20));
		m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);

		checkTrajectoryPath(myPath, kinematicsTester1);

	}

	private static void createPositiveTrajectoryToPositiveTrajectory1stPointLessThanTheDistanceCoveredWhileAcceleratingCase()
			throws InvalidDimentionException, InvalidVelocityException, InvalidNextVelocityFromLastAcceleration,
			InvalidAccelerationException, InvalidFinalPosition, InvalidTrajectoryLogic {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();

		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(2));
		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(20));
		m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);

		checkTrajectoryPath(myPath, kinematicsTester1);

	}

	private static void createPositiveTrajectoryToPositiveTrajectoryLessThanTwiceTheDistanceCoveredWhileAcceleratingCase()
			throws InvalidDimentionException, InvalidVelocityException, InvalidNextVelocityFromLastAcceleration,
			InvalidAccelerationException, InvalidFinalPosition, InvalidTrajectoryLogic {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();

		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(5));
		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(7));
		m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);

		checkTrajectoryPath(myPath, kinematicsTester1);

	}

	private static void createPositiveTrajectoryToPositiveTrajectoryLessThanTheDistanceCoveredWhileAcceleratingCase()
			throws InvalidDimentionException, InvalidVelocityException, InvalidNextVelocityFromLastAcceleration,
			InvalidAccelerationException, InvalidFinalPosition, InvalidTrajectoryLogic {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();

		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(1));
		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(3));
		m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);

		checkTrajectoryPath(myPath, kinematicsTester1);

	}

	private static void createPositiveTrajectoryToPositiveTrajectoryLessThanAndGreaterThanTheDistanceCoveredWhileAcceleratingCase()
			throws InvalidDimentionException, InvalidVelocityException, InvalidNextVelocityFromLastAcceleration,
			InvalidAccelerationException, InvalidFinalPosition, InvalidTrajectoryLogic {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();

		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(2));
		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(6));
		m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);

		checkTrajectoryPath(myPath, kinematicsTester1);

	}

	private static void createPositiveTrajectoryWithACustomMaxVelocityGreaterThanTwiceTheDistanceCoveredWhileAcceleratingCase()
			throws InvalidDimentionException, InvalidVelocityException, InvalidNextVelocityFromLastAcceleration,
			InvalidAccelerationException, InvalidFinalPosition, InvalidTrajectoryLogic {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();

		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(10), 1.0);

		m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);

		checkTrajectoryPath(myPath, kinematicsTester1);

	}

	private static void createNegativeTrajectoryWithACustomMaxVelocityGreaterThanTwiceTheDistanceCoveredWhileAcceleratingCase()
			throws InvalidDimentionException, InvalidVelocityException, InvalidNextVelocityFromLastAcceleration,
			InvalidAccelerationException, InvalidFinalPosition, InvalidTrajectoryLogic {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();

		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(-10), 1.0);

		m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);

		checkTrajectoryPath(myPath, kinematicsTester1);

	}

	private static void createPositiveTrajectoryLessThanTwiceTheDistanceCoveredWhileAcceleratingWithACustomMaxVelocityCase()
			throws InvalidDimentionException, InvalidVelocityException, InvalidNextVelocityFromLastAcceleration,
			InvalidAccelerationException, InvalidFinalPosition, InvalidTrajectoryLogic {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();

		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(1.5), 1.0);
		m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);

		checkTrajectoryPath(myPath, kinematicsTester1);

	}

	private static void createPositiveTrajectoryToPositiveTrajectoryGreaterThanTwiceTheDistanceCoveredWhileAcceleratingFirstPointWithCustomMaxVelocityCase()
			throws InvalidDimentionException, InvalidVelocityException, InvalidNextVelocityFromLastAcceleration,
			InvalidAccelerationException, InvalidFinalPosition, InvalidTrajectoryLogic {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();

		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(10), 1.0);
		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(20));
		m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		checkTrajectoryPath(myPath, kinematicsTester1);

	}

	private static void createPositiveTrajectoryToPositiveTrajectory2ndPointLessThanTwiceTheDistanceCoveredWhileAcceleratingFirstPointWithCustomMaxVelocityCase()
			throws InvalidDimentionException, InvalidVelocityException, InvalidNextVelocityFromLastAcceleration,
			InvalidAccelerationException, InvalidFinalPosition, InvalidTrajectoryLogic {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();

		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(10), 1.0);
		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(11.5));
		m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);

		checkTrajectoryPath(myPath, kinematicsTester1);

	}

	private static void createPositiveTrajectoryToPositiveTrajectory2ndPointLessThanTheDistanceCoveredWhileAcceleratingFirstPointWithCustomMaxVelocityCase()
			throws InvalidDimentionException, InvalidVelocityException, InvalidNextVelocityFromLastAcceleration,
			InvalidAccelerationException, InvalidFinalPosition, InvalidTrajectoryLogic {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();

		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(10), 1.0);
		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(10.5));
		m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		
		checkTrajectoryPath(myPath, kinematicsTester1);

	}

	private static void createPositiveTrajectoryToPositiveTrajectory1stPointLessThanTwiceTheDistanceCoveredWhileAcceleratingFirstPointWithCustomMaxVelocityCase()
			throws InvalidDimentionException, InvalidVelocityException, InvalidNextVelocityFromLastAcceleration,
			InvalidAccelerationException, InvalidFinalPosition, InvalidTrajectoryLogic {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();

		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(1.5), 1.0);
		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(20));
		m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		
		checkTrajectoryPath(myPath, kinematicsTester1);

	}

	private static void createPositiveTrajectoryToPositiveTrajectory1stPointLessThanTheDistanceCoveredWhileAcceleratingFirstPointWithCustomMaxVelocityCase()
			throws InvalidDimentionException, InvalidVelocityException, InvalidNextVelocityFromLastAcceleration,
			InvalidAccelerationException, InvalidFinalPosition, InvalidTrajectoryLogic {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();

		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(0.25), 1.0);
		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(20));
		m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		
		checkTrajectoryPath(myPath, kinematicsTester1);

	}

	private static void createPositiveTrajectoryToPositiveTrajectoryLessThanTwiceTheDistanceCoveredWhileAcceleratingFirstPointWithCustomMaxVelocityCase()
			throws InvalidDimentionException, InvalidVelocityException, InvalidNextVelocityFromLastAcceleration,
			InvalidAccelerationException, InvalidFinalPosition, InvalidTrajectoryLogic {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();

		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(1.25), 1.0);
		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(1.5));
		m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		
		checkTrajectoryPath(myPath, kinematicsTester1);

	}

	private static void createPositiveTrajectoryToPositiveTrajectoryLessThanTheDistanceCoveredWhileAcceleratingFirstPointWithCustomMaxVelocityCase()
			throws InvalidDimentionException, InvalidVelocityException, InvalidNextVelocityFromLastAcceleration,
			InvalidAccelerationException, InvalidFinalPosition, InvalidTrajectoryLogic {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();

		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(0.25), 1.0);
		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(0.5));
		m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		
		checkTrajectoryPath(myPath, kinematicsTester1);

	}

	private static void createPositiveTrajectoryToPositiveTrajectoryLessThanAndGreaterThanTheDistanceCoveredWhileAcceleratingFirstPointWithCustomMaxVelocityCase()
			throws InvalidDimentionException, InvalidVelocityException, InvalidNextVelocityFromLastAcceleration,
			InvalidAccelerationException, InvalidFinalPosition, InvalidTrajectoryLogic {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();

		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(0.5), 1.0);
		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(1.5));
		m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		
		checkTrajectoryPath(myPath, kinematicsTester1);

	}

	private static void createPositiveTrajectoryToPositiveTrajectoryGreaterThanTwiceTheDistanceCoveredWhileAcceleratingSecondPointWithCustomMaxVelocityCase()
			throws InvalidDimentionException, InvalidVelocityException, InvalidNextVelocityFromLastAcceleration,
			InvalidAccelerationException, InvalidFinalPosition, InvalidTrajectoryLogic {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();

		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(10));
		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(20), 1.0);
		m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);

		checkTrajectoryPath(myPath, kinematicsTester1);

	}

	private static void createPositiveTrajectoryToPositiveTrajectory2ndPointLessThanTwiceTheDistanceCoveredWhileAcceleratingSecondPointWithCustomMaxVelocityCase()
			throws InvalidDimentionException, InvalidVelocityException, InvalidNextVelocityFromLastAcceleration,
			InvalidAccelerationException, InvalidFinalPosition, InvalidTrajectoryLogic {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();

		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(10));
		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(16), 1.0);
		m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);
		
		printTrajectory(myPath);
		checkTrajectoryPath(myPath, kinematicsTester1);

	}

	private static void createPositiveTrajectoryToPositiveTrajectory2ndPointLessThanTheDistanceCoveredWhileAcceleratingSecondPointWithCustomMaxVelocityCase()
			throws InvalidDimentionException, InvalidVelocityException, InvalidNextVelocityFromLastAcceleration,
			InvalidAccelerationException, InvalidFinalPosition, InvalidTrajectoryLogic {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();

		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(10));
		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(12), 1.0);
		m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);

		checkTrajectoryPath(myPath, kinematicsTester1);

	}

	private static void createPositiveTrajectoryToPositiveTrajectory1stPointLessThanTwiceTheDistanceCoveredWhileAcceleratingSecondPointWithCustomMaxVelocityCase()
			throws InvalidDimentionException, InvalidVelocityException, InvalidNextVelocityFromLastAcceleration,
			InvalidAccelerationException, InvalidFinalPosition, InvalidTrajectoryLogic {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();

		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(6));
		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(20), 1.0);
		m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);

		checkTrajectoryPath(myPath, kinematicsTester1);

	}

	private static void createPositiveTrajectoryToPositiveTrajectory1stPointLessThanTheDistanceCoveredWhileAcceleratingSecondPointWithCustomMaxVelocityCase()
			throws InvalidDimentionException, InvalidVelocityException, InvalidNextVelocityFromLastAcceleration,
			InvalidAccelerationException, InvalidFinalPosition, InvalidTrajectoryLogic {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();

		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(2));
		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(20), 1.0);
		m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);

		checkTrajectoryPath(myPath, kinematicsTester1);

	}

	private static void createPositiveTrajectoryToPositiveTrajectoryLessThanTwiceTheDistanceCoveredWhileAcceleratingSecondPointWithCustomMaxVelocityCase()
			throws InvalidDimentionException, InvalidVelocityException, InvalidNextVelocityFromLastAcceleration,
			InvalidAccelerationException, InvalidFinalPosition, InvalidTrajectoryLogic {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();

		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(5));
		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(7), 1.0);
		m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);

		checkTrajectoryPath(myPath, kinematicsTester1);

	}

	private static void createPositiveTrajectoryToPositiveTrajectoryLessThanTheDistanceCoveredWhileAcceleratingSecondPointWithCustomMaxVelocityCase()
			throws InvalidDimentionException, InvalidVelocityException, InvalidNextVelocityFromLastAcceleration,
			InvalidAccelerationException, InvalidFinalPosition, InvalidTrajectoryLogic {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();

		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(1));
		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(3), 1.0);
		m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);

		checkTrajectoryPath(myPath, kinematicsTester1);

	}

	private static void createPositiveTrajectoryToPositiveTrajectoryLessThanAndGreaterThanTheDistanceCoveredWhileAcceleratingSecondPointWithCustomMaxVelocityCase()
			throws InvalidDimentionException, InvalidVelocityException, InvalidNextVelocityFromLastAcceleration,
			InvalidAccelerationException, InvalidFinalPosition, InvalidTrajectoryLogic {
		Path myPath = m_kinematicsSimpler.new Path();
		KinematicsTester kinematicsTester1 = new KinematicsTester();

		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(2));
		m_kinematicsSimpler.addPointToPath(myPath, m_kinematicsSimpler.new Point(6), 1.0);
		m_kinematicsSimpler.createTrajectory(myPath, 2.0, 0.5);

		checkTrajectoryPath(myPath, kinematicsTester1);

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
			if (currentPoint.m_acceleration > (Key.getmaxAcceleration() * KinematicsSimpler.getTrajectoryPointInterval()
					+ 0.1)
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
		} catch (ArrayIndexOutOfBoundsException q) {
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

	private static void checkVelocityTakingCustomMaxVelocityIntoAccount(Path Key, KinematicsTester kinematicsTester)
			throws InvalidVelocityException {
		InvalidVelocityException invalidVelocityException;
		String errMessage;
		int currentTrajectoryIndex = 0;
		for (int i = 0; i < Key.getSetpointVector().size(); i++) {
			Point setpoint = Key.getSetpointVector().get(i);
			for (int i1 = currentTrajectoryIndex; i1 < Key.getTrajectoryVector().size(); i1++) {
				TrajectoryPoint trajectoryPoint = Key.getTrajectoryVector().get(i1);

				if (Math.abs(setpoint.getMaxVelocity()) + 0.2 < Math.abs(trajectoryPoint.m_currentVelocity)) {
					errMessage = "The velocity at time: " + trajectoryPoint.m_timestamp
							+ " is above the maximum velocity specified by the user which is: "
							+ setpoint.getMaxVelocity();
					invalidVelocityException = kinematicsTester.new InvalidVelocityException(errMessage);
					throw invalidVelocityException;
				}
				if (trajectoryPoint.m_position - setpoint.getm_X() < 0.001
						&& trajectoryPoint.m_position - setpoint.getm_X() > -0.001) {
					break;
				}
				currentTrajectoryIndex++;
			}
		}
	}

	private static void checkTrajectoryLogic(Path Key, KinematicsTester kinematicsTester)
			throws InvalidTrajectoryLogic {
		InvalidTrajectoryLogic invalidTrajectoryLogic;
		String errMessage;
		int currentTrajectoryPointIndex = 0;
		for (int i = 0; i < Key.getSetpointVector().size(); i++) {
			Point setpoint = Key.getSetpointVector().get(i);
			Point nextSetpoint;
			Point lastSetpoint = m_kinematicsSimpler.new Point(0, 0);
			boolean traveledInAPositiveDirection;
			boolean willTravelInAPositiveDirection;
			TrajectoryPoint trajectoryPoint = Key.getTrajectoryVector().get(currentTrajectoryPointIndex);
			int initialCurrentTrajectoryPointIndex = currentTrajectoryPointIndex;
			for (int a = currentTrajectoryPointIndex; a < Key.getTrajectoryVector().size(); a++) {
				currentTrajectoryPointIndex++;
				trajectoryPoint = Key.getTrajectoryVector().get(a);
				if (trajectoryPoint.m_position - setpoint.getm_X() < 0.01
						&& trajectoryPoint.m_position - setpoint.getm_X() > -0.01) {

					break;
				}
			}

			if (currentTrajectoryPointIndex == (Key.getTrajectoryVector().size())) {
				currentTrajectoryPointIndex = initialCurrentTrajectoryPointIndex;
				continue;
			}

			try {
				nextSetpoint = Key.getSetpointVector().get(i + 1);
			} catch (ArrayIndexOutOfBoundsException a) {
				continue;
			}
			try {
				lastSetpoint = Key.getSetpointVector().get(i - 1);
			} catch (ArrayIndexOutOfBoundsException a) {

			}

			if (lastSetpoint.getm_X() < setpoint.getm_X()) {
				traveledInAPositiveDirection = true;
			} else {
				traveledInAPositiveDirection = false;
			}

			if (setpoint.getm_X() < nextSetpoint.getm_X()) {
				willTravelInAPositiveDirection = true;
			} else {
				willTravelInAPositiveDirection = false;
			}
			if (trajectoryPoint.m_timestamp == 0.0) {
				continue;
			}

			if ((traveledInAPositiveDirection && willTravelInAPositiveDirection)
					|| (!traveledInAPositiveDirection && !willTravelInAPositiveDirection)) {
				if (trajectoryPoint.m_currentVelocity < 0.1 && trajectoryPoint.m_currentVelocity > -0.1) {
					errMessage = "The point at time: " + trajectoryPoint.m_timestamp
							+ " is a point in which the direction is not changing however the velocity is 0!";
					invalidTrajectoryLogic = kinematicsTester.new InvalidTrajectoryLogic(errMessage);
					throw invalidTrajectoryLogic;
				}
			} else {
				if (trajectoryPoint.m_currentVelocity > 0.1 || trajectoryPoint.m_currentVelocity < -0.1) {
					errMessage = "The point at time: " + trajectoryPoint.m_timestamp
							+ " is a point in which the direction is changing however the velocity is not 0!";
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
			if (i == 0) {
				System.out.print(Key.getSetpointVector().get(i).getm_X());
			} else {
				System.out.print(", " + Key.getSetpointVector().get(i).getm_X());
			}
		}
		System.out.println("");
		System.out.println("");
	}

}
