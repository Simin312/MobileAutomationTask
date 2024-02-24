package base;

public class AppData {
	public static String platform = System.getProperty("platform", "android");
}

// mvn clean test -Dplatform=ios 
// if not define then it will use the platform value we set