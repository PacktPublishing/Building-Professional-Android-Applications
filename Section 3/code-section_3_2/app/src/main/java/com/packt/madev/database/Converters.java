package com.packt.madev.database;

import android.arch.persistence.room.TypeConverter;

import java.math.BigDecimal;
import java.util.Date;

public class Converters {
    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }

    @TypeConverter
    public static BigDecimal fromBigDecimal(String value) {
        return value == null ? null : new BigDecimal(value);
    }

    @TypeConverter
    public static String bigDecimal(BigDecimal decimal) {
        return decimal == null ? null : decimal.toPlainString();
    }
}
