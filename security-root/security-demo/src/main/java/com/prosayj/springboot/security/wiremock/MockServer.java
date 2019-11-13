package com.prosayj.springboot.security.wiremock;

import com.github.tomakehurst.wiremock.client.WireMock;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;


/**
 * @author yangjian
 * @description 独立服务器客户端
 * @Date 下午 11:27 2019/11/3
 * @see {http://wiremock.org/docs/running-standalone/}
 * @since 1.0.0
 */
public class MockServer {

    public static void main(String[] args) throws IOException {
        WireMock.configureFor(8080);
        //清除原来的服务
        WireMock.removeAllMappings();

        mock("/order/1", "01");
        mock("/order/2", "02");
    }

    private static void mock(String url, String file) throws IOException {
        ClassPathResource resource = new ClassPathResource("mock/response/" + file + ".txt");
        String content = StringUtils.join(FileUtils.readLines(resource.getFile(), "UTF-8").toArray(), "\n");
        //伪造测试桩
        stubFor(WireMock.get(urlPathEqualTo(url))
                .willReturn(aResponse()
                        .withBody(content)
                        .withStatus(200))
        );
    }

}
