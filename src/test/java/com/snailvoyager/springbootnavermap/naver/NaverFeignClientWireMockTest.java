package com.snailvoyager.springbootnavermap.naver;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.snailvoyager.springbootnavermap.naver.dto.SearchLocalReq;
import feign.RetryableException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import wiremock.org.eclipse.jetty.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@AutoConfigureWireMock(port = 0)
@TestPropertySource(properties = {
        "naver.openapi-url=http://localhost:${wiremock.server.port}"
})
@ExtendWith(SpringExtension.class)
class NaverFeignClientWireMockTest {
    @Autowired
    NaverFeignClient naverFeignClient;

    @Test
    void searchLocalWireMockTest_whenTimeout_thenThrownException() {
        WireMock.stubFor(WireMock.get(WireMock.urlPathEqualTo("/v1/search/local.json"))
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.OK_200)
                        .withFixedDelay(6000)));

        var search = new SearchLocalReq();
        search.setQuery("갈비집");

        //assertThatThrownBy(() -> naverFeignClient.searchLocal(search)).isInstanceOf(RetryableException.class).hasMessageContaining("Read timed out");
        var result = naverFeignClient.searchLocal(search);
        assertThat(result).isNotNull();
        assertThat(result.getTotal()).isEqualTo(0);
    }

    @Test
    void searchLocalWireMockTest_whenSuccess() {
        WireMock.stubFor(WireMock.get(WireMock.urlPathEqualTo("/v1/search/local.json"))
                .willReturn(WireMock.aResponse().withStatus(HttpStatus.OK_200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\n" +
                                "\t\"lastBuildDate\":\"Sun, 01 Oct 2023 23:31:58 +0900\",\n" +
                                "\t\"total\":1,\n" +
                                "\t\"start\":1,\n" +
                                "\t\"display\":1,\n" +
                                "\t\"items\":[\n" +
                                "\t\t{\n" +
                                "\t\t\t\"title\":\"몽탄2\",\n" +
                                "\t\t\t\"link\":\"http:\\/\\/www.mongtan.co.kr\",\n" +
                                "\t\t\t\"category\":\"한식>육류,고기요리\",\n" +
                                "\t\t\t\"description\":\"\",\n" +
                                "\t\t\t\"telephone\":\"\",\n" +
                                "\t\t\t\"address\":\"서울특별시 용산구 한강로1가 251-1\",\n" +
                                "\t\t\t\"roadAddress\":\"서울특별시 용산구 백범로99길 50\",\n" +
                                "\t\t\t\"mapx\":\"1269722500\",\n" +
                                "\t\t\t\"mapy\":\"375360103\"\n" +
                                "\t\t}\n" +
                                "\t]\n" +
                                "}")));
        var search = new SearchLocalReq();
        search.setQuery("갈비집");

        var result = naverFeignClient.searchLocal(search);
        assertThat(result.getItems().size()).isEqualTo(1);
        assertThat(result.getItems().get(0).getTitle()).isEqualTo("몽탄2");
    }
}