package com.snailvoyager.springbootnavermap.naver;

import com.snailvoyager.springbootnavermap.naver.dto.SearchImageReq;
import com.snailvoyager.springbootnavermap.naver.dto.SearchLocalReq;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class NaverFeignClientTest {
    @Autowired
    NaverFeignClient naverFeignClient;

    @Test
    public void searchLocalTest() {
        var search = new SearchLocalReq();
        search.setQuery("갈비집");

        var result = naverFeignClient.searchLocal(search);
        System.out.println(result);
        assertThat(result.getItems().stream().findFirst().get().getCategory()).isNotNull();
    }

    @Test
    public void searchImageTest() {
        var search = new SearchImageReq();
        search.setQuery("갈비집");
        search.setDisplay(3);

        var result = naverFeignClient.searchImage(search);
        assertThat(result.getItems()).isNotNull();
        assertThat(result.getItems().size()).isEqualTo(3);
    }

}