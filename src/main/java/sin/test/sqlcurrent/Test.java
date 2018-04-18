package sin.test.sqlcurrent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import sin.glouds.jdao.connector.JConnector;
import sin.glouds.jdao.connector.JSession;
import sin.glouds.jdao.context.JContext;

public class Test {

	public static void main(String[] args) throws SQLException {
		test4();
	}

	public static void test1() throws SQLException {
		ExecutorService service = Executors.newFixedThreadPool(20);
		for (int i = 0; i < 10; i++) {
			service.submit(new Runnable() {

				Connection connection = DriverManager.getConnection(JContext.getProperty("url"),
						JContext.getProperty("userName"), JContext.getProperty("password"));

				@Override
				public void run() {
					try {
						PreparedStatement ps = null;
						ResultSet rs = null;
						for (int i = 0; i < 20; i++) {
							ps = connection.prepareStatement("select * from test_inc");
							rs = ps.executeQuery();
							if (rs.next()) {
								int value = rs.getInt("value");
								System.out.println(Thread.currentThread().getName() + " : " + value);
								ps = connection.prepareStatement("update test_inc set value = ?");
								ps.setInt(1, value + 1);
								ps.execute();
							}
							try {
								TimeUnit.SECONDS.sleep(1);
							} catch (InterruptedException e) {
								System.out.println(Thread.currentThread().getName() + " : 发生异常");
							}
						}
						if (rs != null)
							rs.close();
						if (ps != null)
							ps.close();
						connection.close();
					} catch (SQLException e) {
						System.out.println(Thread.currentThread().getName() + " : 发生异常");
					}
					service.shutdown();
				}
			});
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void test2() throws SQLException {

		ExecutorService service = Executors.newFixedThreadPool(20);
		for (int i = 0; i < 10; i++) {
			service.submit(new Runnable() {

				@Override
				public void run() {
					try {
						for (int i = 0; i < 20; i++) {
							ResultSet rs = JConnector.preparedStatement("select * from test_inc").executeQuery();
							if (rs.next()) {
								int value = rs.getInt("value");
								System.out.println(Thread.currentThread().getName() + " : " + value);
								try {
									JSession.excute("update test_inc set value = ?", value + 1);
								} catch (Exception e) {
									System.out.println(Thread.currentThread().getName() + " : 发生异常");
								}
							}
							try {
								TimeUnit.SECONDS.sleep(1);
							} catch (InterruptedException e) {
								System.out.println(Thread.currentThread().getName() + " : 发生异常");
							}
						}
					} catch (SQLException e) {
						System.out.println(Thread.currentThread().getName() + " : 发生异常");
					}
					service.shutdown();
				}
			});
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public static void test3() throws SQLException {

		ExecutorService service = Executors.newFixedThreadPool(20);
		for (int i = 0; i < 10; i++) {
			service.submit(new Runnable() {

				@Override
				public void run() {
					for (int i = 0; i < 20; i++) {
						try {
							System.out.println(Thread.currentThread().getName() + " : " + getAndUpdate());
						} catch (Exception e1) {
							System.out.println(Thread.currentThread().getName() + " : 发生异常");
						}
						try {
							TimeUnit.SECONDS.sleep(1);
						} catch (InterruptedException e) {
							System.out.println(Thread.currentThread().getName() + " : 发生异常");
						}
					}
					service.shutdown();
				}
			});
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	
	public static void test4() throws SQLException {

		ExecutorService service = Executors.newFixedThreadPool(20);
		for (int i = 0; i < 10; i++) {
			service.submit(new Runnable() {

				@Override
				public void run() {
					for (int i = 0; i < 20; i++) {
						try {
							System.out.println(Thread.currentThread().getName() + " : " + getAndUpdateSafe());
						} catch (Exception e1) {
							System.out.println(Thread.currentThread().getName() + " : 发生异常");
						}
						try {
							TimeUnit.SECONDS.sleep(1);
						} catch (InterruptedException e) {
							System.out.println(Thread.currentThread().getName() + " : 发生异常");
						}
					}
					service.shutdown();
				}
			});
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public static int getAndUpdate() throws Exception {
		ResultSet rs = JConnector.preparedStatement("select * from test_inc").executeQuery();
		if (rs.next()) {
			int value = rs.getInt("value");
			JSession.excute("update test_inc set value = ?", value + 1);
			return value;
		}
		return 0;
	}
	
	public synchronized static int getAndUpdateSafe() throws Exception {
		ResultSet rs = JConnector.preparedStatement("select * from test_inc").executeQuery();
		if (rs.next()) {
			int value = rs.getInt("value");
			JSession.excute("update test_inc set value = ?", value + 1);
			return value;
		}
		return 0;
	}
}
