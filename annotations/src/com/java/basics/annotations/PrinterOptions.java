package com.java.basics.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface PrinterOptions {
    String numberToPrint();
    int numberOfTimes();
}
