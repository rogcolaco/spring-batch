package com.springBatch.schedule.constants;

public class Constants {
    public static final String SQL_INSERT_CONTACT=
            "INSERT INTO schedule (name, phone_number) " +
            "VALUES (:name, :phoneNumber) " +
            "ON CONFLICT (name) " +
            "DO UPDATE SET name = :name, phone_number = :phoneNumber";
}
