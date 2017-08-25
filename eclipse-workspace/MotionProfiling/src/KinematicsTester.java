import kinematics.Kinematics;
import kinematics.Kinematics.InvalidDimentionException;

public class KinematicsTester {
	public static Kinematics kinematics;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		kinematics = new Kinematics();

		kinematics.Kinematics.Path myFirstPath = kinematics.new Path();

		try {
			kinematics.addPointToPath(myFirstPath, kinematics.new Point(50));
		
			//kinematics.addPointToPath(myFirstPath, kinematics.new Point(12));
			//kinematics.addPointToPath(myFirstPath, kinematics.new Point(13));
			//kinematics.addPointToPath(myFirstPath, kinematics.new Point(14));
		} catch (InvalidDimentionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//kinematics.addPointToPath(myFirstPath, kinematics.new Point(-10));
		//kinematics.addPointToPath(myFirstPath, kinematics.new Point(-15));
		//kinematics.addPointToPath(myFirstPath, kinematics.new Point(-20));
		//kinematics.addPointToPath(myFirstPath, kinematics.new Point(-25));
		
		//kinematics.addPointToPath(myFirstPath, kinematics.new Point(20));
		kinematics.createTrajectory(myFirstPath, 2.0, 0.5, 0.0);

		System.out.println("Trajectory Point: [vel, acc, pos, time]");
		for (int i = 0; i < myFirstPath.getTrajectoryVector().size(); i++) {
			System.out.println("Trajectory Point: [" + myFirstPath.getTrajectoryVector().get(i).m_currentVelocity + ", "
					+ +myFirstPath.getTrajectoryVector().get(i).m_acceleration + ", "
					+ +myFirstPath.getTrajectoryVector().get(i).m_position + ", "
					+ +myFirstPath.getTrajectoryVector().get(i).m_timestamp + "]");
		}

	}

}
