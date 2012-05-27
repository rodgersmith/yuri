package com.hmstn.orca.Utility;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.joda.time.DateTime;

import java.io.IOException;

public class CustomDateSerializer extends JsonSerializer<DateTime> {

    @Override
    public void serialize(DateTime value, JsonGenerator gen,
                          SerializerProvider arg2)
            throws IOException {
        gen.writeString(Utility.toDateTimeString(value));
    }
}
