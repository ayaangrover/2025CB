// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandGenericHID;
import edu.wpi.first.wpilibj2.command.RunCommand;


/**
 * TODO: Create a field (instance) variable and call it something like "testValue".
 * Also write an accessor method. Increment testValue by 0.1 continually each cycle
 */
public class Subsystem extends SubsystemBase 
{
	private static Subsystem instance;
	/** Creates a new ExampleSubsystem. */
	private static CommandGenericHID controller = new CommandGenericHID(0);
	public double buttonValue;
	public double buttonValue3;
	public double testValue;
	public int telemetryTestValue;
	private boolean on = true;

	public double getButtonValue() {
		return buttonValue;
	}

	public double getButtonValue3() {
		return buttonValue3;
	}
	
	private Subsystem() {
		testValue = 0.0;
		buttonValue = 0.0;
		telemetryTestValue = 0;
	}

	public double getTestValue() {
		return testValue;
	}

	public int getTelemetryTestValue() {
		return telemetryTestValue;
	}


	// This method will be called once per scheduler run
	@Override
	public void periodic() 
	{
		testValue+=0.1;
	}

	public void decrease() {
		buttonValue -=0.2;
		on = false;
	}

	public void increase() {
		buttonValue +=0.1;
		on = true;
	}

	public void continued()
    {
        if (on == true)
        
        {
            buttonValue3 -= 0.1;
        }
        if (on == false)
        {
            buttonValue3 += 0.2;
        }
    }

	// This method will be called once per scheduler run during simulation
	@Override
	public void simulationPeriodic() 
	{
		testValue+=0.1;
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
