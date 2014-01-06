package cmn;

public class LogUtils {
	/**
	 * 1:debug 2:info 3:never
	 */
	private static int logLevel = 1;

	public static void debug(String msg) {
		if (logLevel <= 1)
			System.out.println(msg);
	}

	public static void info(String msg) {
		if (logLevel <= 2)
			System.out.println(msg);
	}

	public static void setLogLevel(int level) {
		logLevel = level;
	}
}
