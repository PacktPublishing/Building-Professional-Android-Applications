package com.packt.madev.database;

import java.math.BigDecimal;

import io.objectbox.converter.PropertyConverter;

public class BigDecimalConverter implements PropertyConverter<BigDecimal, Long> {
    @Override
    public BigDecimal convertToEntityProperty(Long databaseValue) {
        if (databaseValue == null) {
            return null;
        }
        return new BigDecimal(databaseValue).scaleByPowerOfTen(-4);
    }

    @Override
    public Long convertToDatabaseValue(BigDecimal entityProperty) {
        if (entityProperty == null) {
            return null;
        }
        return entityProperty.scaleByPowerOfTen(4).longValue();
    }
}
