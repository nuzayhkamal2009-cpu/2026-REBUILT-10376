package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.WaitCommand;

/** RobotContainer: provides robot wiring and autonomous command mapping. */
public class RobotContainer {
  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {}

  /**
   * Return an autonomous Command based on the selection string from the SendableChooser.
   * This mirrors the chooser in Robot and lets Robot call getAutonomousCommand(m_autoSelected).
   */
  public Command getAutonomousCommand(String autoSelected) {
    if (autoSelected == null) {
      return Commands.none();
    }

    switch (autoSelected) {
      case "My Auto":
        // Placeholder: wait 2 seconds (replace with a real autonomous command/group)
        return new WaitCommand(2.0);
      case "Default":
      default:
        return Commands.none();
    }
  }
}