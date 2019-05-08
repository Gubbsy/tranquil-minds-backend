package uk.gov.landregistry.kinderkat.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.StringUtils;

public class TimestampToDB2StringSerializer extends JsonSerializer<Timestamp> {

    @Override
    public void serialize(Timestamp value, JsonGenerator gen, SerializerProvider serializers) throws IOException {

        // Date pattern, time in 24 hour format
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");
        String string = sdf.format(value);

        // Retrieve nanoseconds value
        // However, a nanoseconds value of 000004 would be stored in an int variable as 4000 (as
        // nanoseconds is a 9 digit max value)
        // Thus it must be padded to 9 characters
        String nanoseconds = String.valueOf(value.getNanos());
        nanoseconds = StringUtils.leftPad(nanoseconds, 9, '0');
        string += "." + nanoseconds;

        // Since the string will be 29 characters (due to the 9 digit nano) this must be trimmed
        string = string.substring(0, 26);
        gen.writeString(string);
    }
}