package chu.dev.gson;

import chu.dev.vo.SampleVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class GsonTest {


    @Test
    public void gsonToJson() {

        log.info("toJson() - test ");
        SampleVO vo = new SampleVO();
        vo.setName("Test");

        Gson gson = new Gson();
        String jsonStr = gson.toJson(vo);
        log.info("to Json {}", jsonStr);
        Assert.assertTrue("ContainTestStr", jsonStr.contains("Test"));

    }

    @Test
    public void gsonToObj() {
        log.info("toObj() - test ");
        String jsonStr = "{\"name\":\"Test\"}";
        Gson gson = new Gson();
        SampleVO vo = gson.fromJson(jsonStr, SampleVO.class);
        Assert.assertNotNull(vo);
        Assert.assertFalse("gson not use setter ", vo.getHitSetter());
        log.info("vo : {}", vo);
    }

    @Test
    public void jackSonToJson() {
        try {
            SampleVO vo = new SampleVO();
            vo.setName("Test");
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonStr = objectMapper.writeValueAsString(vo);
            log.info("jacksonStr : {}", jsonStr);
            Assert.assertTrue("ContainTestStr", jsonStr.contains("Test"));
        } catch (Exception e) {
            e.printStackTrace();
            log.error("on Error : {}", e.getMessage(), e);

        }
    }


    @Test
    public void jacksonToObject() {
        try {
            String jsonStr = "{\"name\":\"Test\"}";
            log.info("jacksonStr : {}", jsonStr);
            ObjectMapper objectMapper = new ObjectMapper();
            SampleVO vo = objectMapper.readValue(jsonStr, SampleVO.class);
            log.info("vo : {}", vo);
            Assert.assertNotNull(vo);
            Assert.assertTrue("gson not use setter ", vo.getHitSetter());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("on Error : {}", e.getMessage(), e);

        }
    }

}
