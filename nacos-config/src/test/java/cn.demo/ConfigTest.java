package cn.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * com.ncars.rescuemaster.TestDemo
 *
 * @author chenandong
 * @date 2020/6/16
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConfigApplication.class)
public class ConfigTest {

    @Value("${acc.bcc}")
    private String active;



    @Test
    public void test(){
        System.out.println();
    }
}
