package frc.robot;

import edu.wpi.first.networktables.DoublePublisher;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.subsystems.Subsystem;

public class Telemetry 
{
    private static NetworkTableInstance instance = NetworkTableInstance.getDefault();
    private static NetworkTable table = instance.getTable("Telemetry Data");

    private static DoublePublisher test = table.getDoubleTopic("Test").publish();

    public static NetworkTable getTable ()
    {
        return table;
    }

    /**
     * Set the value of all of the publishers. This method is called periodically.
     */
    public static void update ()
    {
        // TODO: Set the value of the "test" publisher to Subsystem's "testValue" field.

    }
    
}
