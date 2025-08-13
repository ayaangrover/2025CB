package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.util.HSXboxController;
import frc.robot.subsystems.Subsystem;
import edu.wpi.first.wpilibj2.command.RunCommand;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer 
{

	// Replace with CommandPS4Controller or CommandJoystick if needed
	private HSXboxController controller = new HSXboxController(0);

	/** The container for the robot. Contains subsystems, OI devices, and commands. */
	public RobotContainer() 
	{
		// Configure the trigger bindings
		configureBindings();
	}

	private final Subsystem m_subsystem = Subsystem.getInstance();

	/**
	 */
	private void configureBindings() 
	{
		controller.button(1).whileTrue(m_subsystem.run(() -> m_subsystem.decrease()));
		controller.button(2).whileTrue(m_subsystem.run(() -> m_subsystem.increase()));
		controller.button(3).whileTrue(Subsystem.getInstance().run(() -> Subsystem.getInstance().continued()));
	}

	/**
	 * @return the command to run in autonomous
	 */
	public Command getAutonomousCommand() 
	{
		return null;
	}
}
