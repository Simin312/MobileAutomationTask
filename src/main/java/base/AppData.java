package base;

public class AppData {
	public static String platform = System.getProperty("platform", "android");
	public static String useGesturePlugin = System.getProperty("useGesturePlugin", "false");
    public static String chromeAutoDownloadDriver = System.getProperty("chromeAutoDownloadDriver", "false");
}

// mvn clean test -Dplatform=ios 
// if not define then it will use the platform value we set