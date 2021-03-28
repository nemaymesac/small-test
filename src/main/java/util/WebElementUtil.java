package util;

import com.codeborne.selenide.SelenideElement;
import lombok.experimental.UtilityClass;

import static org.apache.commons.lang3.StringUtils.EMPTY;

@UtilityClass
public final class WebElementUtil {

    public static String getText(SelenideElement element) {
        if (element.exists()) {
            return element.text();
        }
        return EMPTY;
    }

    public static String getValue(SelenideElement element) {
        if (element.exists()) {
            return element.getValue();
        }
        return EMPTY;
    }

    public static void setValue(SelenideElement element, String value) {
        if (element.exists()) {
            element.setValue(value);
        }
    }

    public static String getCssValue(SelenideElement element, String cssValue) {
        if (element.exists()) {
            return element.getCssValue(cssValue);
        }
        return EMPTY;
    }
}
