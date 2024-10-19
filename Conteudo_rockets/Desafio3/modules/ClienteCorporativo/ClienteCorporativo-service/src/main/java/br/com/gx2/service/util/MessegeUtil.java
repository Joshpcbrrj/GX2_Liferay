package br.com.gx2.service.util;

import com.liferay.alloy.util.MessageUtil;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;

import java.util.Locale;
import java.util.ResourceBundle;

public class MessegeUtil {
    public static final String UNAUTHORIZED = "error.unauthorized.user";
    public static final String UNAUTHENTICATED = "error.unauthenticated.user";
    public static final String SOLICITATION_NOT_FOUND = "error.solicitation.not.found";

    public static String getMessageErrorWithKey(Locale locale, String keyMessageError) throws ClassNotFoundException {
        return getMessage(locale, keyMessageError);
    }

    public static String getMessageErrorWithKey(String keyMessageError) throws ClassNotFoundException {
        return getMessage(Locale.US, keyMessageError);
    }

    private static String getMessage(Locale locale, String keyMessageError) throws ClassNotFoundException{
        Class<?> classRef = Class.forName(MessageUtil.class.getName());
        ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(locale, classRef);
        String message = LanguageUtil.get(resourceBundle, keyMessageError);

        return message;
    }
}
