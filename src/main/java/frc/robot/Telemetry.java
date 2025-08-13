package frc.robot;

import edu.wpi.first.networktables.DoublePublisher;
import edu.wpi.first.networktables.IntegerPublisher;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.subsystems.Subsystem;

public class Telemetry 
{
    private static NetworkTableInstance instance = NetworkTableInstance.getDefault();
    private static NetworkTable table = instance.getTable("Telemetry Data");

    private static DoublePublisher test = table.getDoubleTopic("Test").publish();
    private static IntegerPublisher telemetryTest = table.getIntegerTopic("telemetryTest").publish();
    private static DoublePublisher buttonValue = table.getDoubleTopic("ButtonValue").publish();
    private static DoublePublisher buttonValue3 = table.getDoubleTopic("ButtonValue3").publish();
    private static DoublePublisher autonomousValue = table.getDoubleTopic("autonomousValue").publish();


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
        test.set(Subsystem.getInstance().getTestValue());
        telemetryTest.set(Robot.getTelemetryTestValue());
        buttonValue.set(Subsystem.getInstance().getButtonValue());
        buttonValue3.set(Subsystem.getInstance().getButtonValue3());
        autonomousValue.set(Robot.getPublishValue());
        // System.out.println("updated autval" + Robot.getInstance().getPublishValue());
    }
    
}
