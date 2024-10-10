package com.unicauca.smart_consumption.infrastructure.messages;

import java.text.MessageFormat;
import java.util.Objects;
import java.util.ResourceBundle;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * Provides message handling functionality through a ResourceBundle.
 */
public class MessageLoader {

  private static final String MESSAGE_PROPERTIES = "messages";
  private final ResourceBundle bundle = ResourceBundle.getBundle(MESSAGE_PROPERTIES, LocaleContextHolder.getLocale());

  private static MessageLoader instance;

  private MessageLoader() {
  }

  /**
   * Singleton instance method.
   *
   * @return instance
   */
  public static MessageLoader getInstance() {
    if (Objects.isNull(instance)) {
      instance = new MessageLoader();
    }
    return instance;
  }

  /**
   * Retrieves the message associated with the provided code.
   *
   * @param code   The code of the message to retrieve.
   * @param params Optional parameters to format the retrieved message.
   * @return The formatted message string.
   */
  public String getMessage(String code, Object... params) {
    return MessageFormat.format(bundle.getString(code), params);
  }
}
