package sin.glouds.test.jpcap;

import net.sourceforge.jpcap.capture.CaptureDeviceNotFoundException;
import net.sourceforge.jpcap.capture.PacketCapture;

public class JpcapTest {

	public static void main(String[] args) throws CaptureDeviceNotFoundException {
		PacketCapture capture = new PacketCapture();
		System.out.println(capture.findDevice());
	}
}
