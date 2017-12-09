package com.akos.ui;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Описание аргумента комманды
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface CommandArgument {
    String value();
}
