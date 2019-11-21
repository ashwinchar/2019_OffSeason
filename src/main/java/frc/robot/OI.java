package frc.robot;


import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Joystick;

public class OI {
	public XboxController controller0;
	public Joystick controller1;

	public OI() {
		controller0 = new XboxController(0);
    	controller1 = new Joystick(1);
	}
}