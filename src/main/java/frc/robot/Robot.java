package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * The methods in this class are called automatically corresponding to each mode, as described in
 * the TimedRobot documentation. If you change the name of this class or the package after creating
 * this project, you must also update the Main.java file in the project.
 * 
 * // TODO: Update TelemetryPublishers continually when in any mode.
 */
public class Robot extends TimedRobot 
{
	private Command m_autonomousCommand;
	private static int telemetryTestValue;
	private static Robot instance;
	private final RobotContainer m_robotContainer;
	private int newValue=0;
	private double startTime = System.currentTimeMillis();

	/**
	 * This function is run when the robot is first started up and should be used for any
	 * initialization code.
	 */
	public Robot() 
	{
		// Instantiate our RobotContainer.  This will perform all our button bindings, and put our
		// autonomous chooser on the dashboard.
		m_robotContainer = new RobotContainer();
	}

	public static Robot getInstance() {
		if (instance == null) instance = new Robot();
		return instance;
	}

	public static int getTelemetryTestValue() {
		return telemetryTestValue;
	}

	double t;

	/**
	 * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
	 * that you want ran during disabled, autonomous, teleoperated and test.
	 *
	 * <p>This runs after the mode specific periodic functions, but before LiveWindow and
	 * SmartDashboard integrated updating.
	 */
	@Override
	public void robotPeriodic() 
	{
		CommandScheduler.getInstance().run();
		Telemetry.update();
	}

	/** This function is called once each time the robot enters Disabled mode. */
	@Override
	public void disabledInit() {
		telemetryTestValue = 0;
	}

	@Override
	public void disabledPeriodic() {}

	/** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
	@Override
	public void autonomousInit() 
	{
		
		telemetryTestValue = 1;
		m_autonomousCommand = m_robotContainer.getAutonomousCommand();

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) 
		{
			m_autonomousCommand.schedule();
		}
	}

	private long testValue;
	public static double publishValue;

	/** This function is called periodically during autonomous. */
	@Override
	public void autonomousPeriodic() {
		
		t=System.currentTimeMillis()-startTime;
		t/=1000;
		if (t>15) {
			publishValue = 0.0;
		}
		else
		{
			publishValue = ((16 * t)/9)*(15-t);
		}
	}

	public static double getPublishValue () {
		// System.out.println("gave publishvalue: " + publishValue);
		return publishValue;
	}

	@Override
	public void teleopInit() 
	{

		telemetryTestValue = 2;
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) 
		{
			m_autonomousCommand.cancel();
		}
	}

	/** This function is called periodically during operator control. */
	@Override
	public void teleopPeriodic() {
		publishValue = 0.0;
	}

	@Override
	public void testInit() 
	{
		telemetryTestValue = 3;
		// Cancels all running commands at the start of test mode.
		CommandScheduler.getInstance().cancelAll();
	}

	/** This function is called periodically during test mode. */
	@Override
	public void testPeriodic() {}

	/** This function is called once when the robot is first started up. */
	@Override
	public void simulationInit() {
		telemetryTestValue = 0;
	}

	/** This function is called periodically whilst in simulation. */
	@Override
	public void simulationPeriodic() {}
}
