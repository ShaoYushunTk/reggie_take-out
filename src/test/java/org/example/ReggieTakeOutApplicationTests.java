package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ReggieTakeOutApplicationTests {

    @Test
    public void testUploadFile(){
        String fileName = "erere.jpg";
        String substring = fileName.substring(fileName.lastIndexOf('.'));
        System.out.println(substring);
    }

}
