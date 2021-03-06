package org.test4j.testng.spring.strategy.register;

import org.test4j.fortest.service.UserAnotherDaoImpl;
import org.test4j.fortest.service.UserService;
import org.test4j.module.database.IDatabase;
import org.test4j.module.spring.ISpring;
import org.test4j.module.spring.annotations.AutoBeanInject;
import org.test4j.module.spring.annotations.AutoBeanInject.BeanMap;
import org.test4j.module.spring.annotations.Property;
import org.test4j.module.spring.annotations.SpringBeanByName;
import org.test4j.module.spring.annotations.SpringContext;
import org.test4j.testng.Test4J;
import org.testng.annotations.Test;

@Test(groups = { "test4j", "spring" })
@SpringContext({ "org/test4j/module/spring/testedbeans/xml/data-source.xml" })
@AutoBeanInject(maps = { @BeanMap(intf = "**.*Service", impl = "**.*ServiceImpl"),
        @BeanMap(intf = "**.*Dao", impl = "**.*DaoImpl") })
public class SpringBeanRegisterTest extends Test4J implements IDatabase, ISpring {
    @SpringBeanByName(properties = {
            @Property(name = "userAnotherDao", ref = "userRefDao", clazz = UserAnotherDaoImpl.class),
            @Property(name = "myName", value = "I am test") })
    private UserService userService;

    @Test
    public void testRegister() {
        Object bean = spring.getBean("userRefDao");
        want.object(bean).notNull();

        Object ref = reflector.getField(userService, "userAnotherDao");
        want.object(ref).notNull().same(bean);
    }

    public void testRegister2() {
        String value = reflector.getField(userService, "myName");
        want.string(value).isEqualTo("I am test");
    }
}
