package sin.glouds.test.thread.base;

public abstract class BaseThread extends Thread {

	@Override
	public synchronized void start() {
		System.out.println(getName() + " is start");
		super.start();
	}

	@Override
	public void interrupt() {
		System.out.println(getName() + " is interrupt");
		super.interrupt();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void destroy() {
		System.out.println(getName() + " is destroy");
		super.destroy();
	}

	
}
