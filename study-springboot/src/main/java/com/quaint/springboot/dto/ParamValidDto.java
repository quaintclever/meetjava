package com.quaint.springboot.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.quaint.springboot.config.LocalDateTimeSerializingConfig;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import static com.quaint.springboot.util.DateUtils.TIME_ZONE_DEFAULT;

/**
 * @author quaint
 * @since 2023/6/14 22:53
 */
public class ParamValidDto {

    @Data
    public static class Time {
        @JsonFormat(pattern = LocalDateTimeSerializingConfig.localDateFormat, timezone = TIME_ZONE_DEFAULT)
        @DateTimeFormat(pattern = LocalDateTimeSerializingConfig.localDateFormat, iso = DateTimeFormat.ISO.DATE)
        private Date date;

        @JsonFormat(pattern = LocalDateTimeSerializingConfig.localDateTimeFormat, timezone = TIME_ZONE_DEFAULT)
        @DateTimeFormat(pattern = LocalDateTimeSerializingConfig.localDateTimeFormat, iso = DateTimeFormat.ISO.DATE_TIME)
        private Date date2;

        @JsonFormat(pattern = LocalDateTimeSerializingConfig.localDateFormat, timezone = TIME_ZONE_DEFAULT)
        @DateTimeFormat(pattern = LocalDateTimeSerializingConfig.localDateFormat, iso = DateTimeFormat.ISO.DATE)
        private LocalDate localDate;

        @JsonFormat(pattern = LocalDateTimeSerializingConfig.localDateTimeFormat, timezone = TIME_ZONE_DEFAULT)
        @DateTimeFormat(pattern = LocalDateTimeSerializingConfig.localDateTimeFormat, iso = DateTimeFormat.ISO.DATE_TIME)
        private LocalDateTime localDateTime;

        @JsonFormat(pattern = LocalDateTimeSerializingConfig.localTimeFormat, timezone = TIME_ZONE_DEFAULT)
        @DateTimeFormat(pattern = LocalDateTimeSerializingConfig.localTimeFormat, iso = DateTimeFormat.ISO.TIME)
        private LocalTime localTime;
    }

}
