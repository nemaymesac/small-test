package util;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.ResourceBundle;

import static java.lang.Long.parseLong;
import static java.lang.System.getProperty;

public class ConfigHelper {
    private static final ResourceBundle bundle;

    static {
        bundle = ResourceBundle.getBundle("config");
    }

    private static String get(String property) {
        String systemProperty = getProperty(property);

        if (systemProperty == null || systemProperty.isEmpty()) {
            systemProperty = bundle.getString(property);
        }

        if (systemProperty.isEmpty()) {
            throw new AssertionError(property + " should be set either as environment property or in config.properties");
        }

        return systemProperty.trim();
    }

    public static String getBrowser() {
        return get("browser");
    }

    public static String getBaseUrl() {
        return get("base.url");
    }

    public static long getPageElementLoadTimeoutMills() {
        return 1000 * parseLong(get("wait.page.element.seconds"));
    }

    public static String getImplicitWait() {
        return get("implicit.wait");
    }

    public static Integer getBuildCount() {
        return NumberUtils.toInt(System.getProperty("build.count"), 0);
    }

}

