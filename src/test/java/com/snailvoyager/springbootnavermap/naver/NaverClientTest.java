package com.snailvoyager.springbootnavermap.naver;

import com.snailvoyager.springbootnavermap.naver.dto.SearchImageReq;
import com.snailvoyager.springbootnavermap.naver.dto.SearchLocalReq;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NaverClientTest {
    @Autowired
    private NaverClient naverClient;

    @Test
    public void searchLocalTest() {
        var search = new SearchLocalReq();
        search.setQuery("갈비집");

        var result = naverClient.searchLocal(search);
        System.out.println(result);
        Assertions.assertThat(result.getItems().stream().findFirst().get().getCategory()).isNotNull();
    }

    @Test
    public void searchImageTest() {
        var search = new SearchImageReq();
        search.setQuery("갈비집");

        var result = naverClient.searchImage(search);
        System.out.println(result);
    }
}
