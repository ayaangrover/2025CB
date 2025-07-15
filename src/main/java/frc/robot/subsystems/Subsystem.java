// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * TODO: Create a field (instance) variable and call it something like "testValue".
 * Also write an accessor method. Increment testValue by 0.1 continually each cycle
 */
public class Subsystem extends SubsystemBase 
{
	private static Subsystem instance;
	/** Creates a new ExampleSubsystem. */


	private Subsystem() {}



	// This method will be called once per scheduler run
	@Override
	public void periodic() 
	{
	}

	// This method will be called once per scheduler run during simulation
	@Override
	public void simulationPeriodic() 
	{

	}

	/**
	 * Manages access to the Subsystem subsystem by returning instance, 
	 * a static variable, if it has already been initialized, and if not,
	 * ie. the first call to getInstance(), it initializes instance.
	 * 
	 * Try this out by telemetrizing instance and seeing what happens after
	 * repeated calls to getInstance().
	 */
	public static Subsystem getInstance ()
	{
		if (instance == null) instance = new Subsystem();
		return instance;
	}
}
