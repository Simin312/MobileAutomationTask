package base;

public class AppData {
	public static String platform = System.getProperty("platform", "android");
	public static String useGesturePlugin = System.getProperty("useGesturePlugin", "true");
    public static String chromeAutoDownloadDriver = System.getProperty("chromeAutoDownloadDriver", "true");
}

// mvn clean test -Dplatform=ios 
// if not define then it will use the platform value we set