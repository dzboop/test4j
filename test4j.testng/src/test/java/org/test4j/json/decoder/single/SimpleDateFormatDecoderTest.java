package org.test4j.json.decoder.single;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.test4j.json.JSON;
import org.test4j.testng.Test4J;
import org.testng.annotations.Test;

@Test(groups = { "test4j", "json" })
public class SimpleDateFormatDecoderTest extends Test4J {

    public void testDecode() throws Exception {

        SimpleDateFormat df = JSON.toObject("'yyyy-MM-dd'", SimpleDateFormat.class);

        Date actual = df.parse("2011-09-18");
        want.date(actual).isYear(2011).isMonth(9).isDay(18);
    }
}
