package org.test4j.json.encoder.object;

import org.junit.Test;
import org.test4j.fortest.beans.Manager;
import org.test4j.json.JSON;
import org.test4j.json.encoder.beans.test.User;
import org.test4j.json.helper.JSONFeature;
import org.test4j.junit.Test4J;

public class PoJoEncoderTest extends Test4J {

    @Test
    public void testWrite_NormalPoJo() {
        User user = User.newInstance(3, "test user");

        String json = JSON.toJSON(user);

        want.string(json).contains(JSONFeature.ClazzFlag).contains(User.class.getName());
    }

    @Test
    public void testDecodeing() {
        String json = String.format("{\"%s\":\"%s\",\"name\":\"test user\",\"id\":3}", JSONFeature.ClazzFlag,
                User.class.getName());
        Object user = JSON.toObject(json);
        want.object(user).notNull().clazIs(User.class).propertyEq("name", "test user");
    }

    @Test
    public void testDecodeing_SpecClaz() {
        String json = "{\"#class\":\"" + User.class.getName() + "\",\"name\":\"test user\",\"id\":3}";
        Object user = JSON.toObject(json, User.class);
        want.object(user).notNull().clazIs(User.class).propertyEq("name", "test user");
    }

    @Test
    // "字段类型是接口时"
    public void testPoJoEncoder() {
        Manager manager = Manager.mock();
        String json = JSON.toJSON(manager, JSONFeature.UseSingleQuote, JSONFeature.UnMarkClassFlag);
        want.string(json).contains("phoneNumber:{");
    }
}
