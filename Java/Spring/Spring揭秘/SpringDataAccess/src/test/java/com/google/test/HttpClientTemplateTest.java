package com.google.test;

import com.google.template.HttpClientTemplate;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class HttpClientTemplateTest {
    @Test
    public void testTemplate() throws IOException {
        HttpClientTemplate template = new HttpClientTemplate();
        template.execute(() -> {
            HttpEntity entity = template.getResponse().getEntity();
            try {
                EntityUtils.consume(entity);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
