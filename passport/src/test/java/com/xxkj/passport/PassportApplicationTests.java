package com.xxkj.passport;

import com.xxkj.passport.entity.User;
import com.xxkj.passport.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.Is.is;

/**
 * @Before：初始化方法
 * @After：释放资源
 * @Test：测试方法（包括：期望异常和超时时间）
 *
 * @Test(timeout = 1000)，超时会失败。
 *
 * @Test(expected = NullPointerException.class) 希望抛出空指针异常
 *
 *
 * @Ignore：忽略的测试方法
 * @BeforeClass：针对所有测试，只执行一次，且必须为static void
 * @AfterClass：针对所有测试，只执行一次，且必须为static void
 * @RunWith：可以更改测试运行器
 * 执行顺序：
 *
 * @BeforeClass ==> @Before ==> @Test ==> @After ==> @AfterClass 
 *
 *  
 *
 * @SpringBootTest会加载spring的上下文，这样可以使用@Autowired注入Bean
 * ---------------------
 * 作者：jy02268879
 * 来源：CSDN
 * 原文：https://blog.csdn.net/jy02268879/article/details/83346701
 * 版权声明：本文为博主原创文章，转载请附上博文链接！
 */
public class PassportApplicationTests extends BaseTest {
    @Autowired
    private UserRepository userRepository;

    // 超过指定时间 执行失败
    @Test(timeout = 1000)
    public void contextLoads() {
        User user = userRepository.findByUsername("admin");
        System.out.println("sss:"+user.getPassword());
        /*try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("123456789");
        c*/
    }

    /*assertThat的字符相关匹配符
*//**equalTo匹配符断言被测的testedValue等于expectedValue，
 * equalTo可以断言数值之间，字符串之间和对象之间是否相等，相当于Object的equals方法
 *//*
    assertThat(testedValue, equalTo(expectedValue));
    *//**equalToIgnoringCase匹配符断言被测的字符串testedString
     *在忽略大小写的情况下等于expectedString
     *//*
    assertThat(testedString, equalToIgnoringCase(expectedString));
    *//**equalToIgnoringWhiteSpace匹配符断言被测的字符串testedString
     *在忽略头尾的任意个空格的情况下等于expectedString，
     *注意：字符串中的空格不能被忽略
     *//*
    assertThat(testedString, equalToIgnoringWhiteSpace(expectedString);
    *//**containsString匹配符断言被测的字符串testedString包含子字符串subString**//*
    assertThat(testedString, containsString(subString) );
    *//**endsWith匹配符断言被测的字符串testedString以子字符串suffix结尾*//*
    assertThat(testedString, endsWith(suffix));
    *//**startsWith匹配符断言被测的字符串testedString以子字符串prefix开始*//*
    assertThat(testedString, startsWith(prefix));
    一般匹配符
*//**nullValue()匹配符断言被测object的值为null*//*
    assertThat(object,nullValue());
    *//**notNullValue()匹配符断言被测object的值不为null*//*
    assertThat(object,notNullValue());
    *//**is匹配符断言被测的object等于后面给出匹配表达式*//*
    assertThat(testedString, is(equalTo(expectedValue)));
    *//**is匹配符简写应用之一，is(equalTo(x))的简写，断言testedValue等于expectedValue*//*
    assertThat(testedValue, is(expectedValue));
    *//**is匹配符简写应用之二，is(instanceOf(SomeClass.class))的简写，
     *断言testedObject为Cheddar的实例
     *//*
    assertThat(testedObject, is(Cheddar.class));
    *//**not匹配符和is匹配符正好相反，断言被测的object不等于后面给出的object*//*
    assertThat(testedString, not(expectedString));
    *//**allOf匹配符断言符合所有条件，相当于“与”（&&）*//*
    assertThat(testedNumber, allOf( greaterThan(8), lessThan(16) ) );
    *//**anyOf匹配符断言符合条件之一，相当于“或”（||）*//*
    assertThat(testedNumber, anyOf( greaterThan(16), lessThan(8) ) );
    数值相关匹配符
*//**closeTo匹配符断言被测的浮点型数testedDouble在20.0¡À0.5范围之内*//*
    assertThat(testedDouble, closeTo( 20.0, 0.5 ));
    *//**greaterThan匹配符断言被测的数值testedNumber大于16.0*//*
    assertThat(testedNumber, greaterThan(16.0));
    *//** lessThan匹配符断言被测的数值testedNumber小于16.0*//*
    assertThat(testedNumber, lessThan (16.0));
    *//** greaterThanOrEqualTo匹配符断言被测的数值testedNumber大于等于16.0*//*
    assertThat(testedNumber, greaterThanOrEqualTo (16.0));
    *//** lessThanOrEqualTo匹配符断言被测的testedNumber小于等于16.0*//*
    assertThat(testedNumber, lessThanOrEqualTo (16.0));
    集合相关匹配符
*//**hasEntry匹配符断言被测的Map对象mapObject含有一个键值为"key"对应元素值为"value"的Entry项*//*
    assertThat(mapObject, hasEntry("key", "value" ) );
    *//**hasItem匹配符表明被测的迭代对象iterableObject含有元素element项则测试通过*//*
    assertThat(iterableObject, hasItem (element));
    *//** hasKey匹配符断言被测的Map对象mapObject含有键值“key”*//*
    assertThat(mapObject, hasKey ("key"));
    *//** hasValue匹配符断言被测的Map对象mapObject含有元素值value*//*
    assertThat(mapObject, hasValue(value));*/
}
