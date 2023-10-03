package com.snailvoyager.springbootnavermap.naver;

import com.snailvoyager.springbootnavermap.config.NaverFeignConfig;
import com.snailvoyager.springbootnavermap.naver.dto.SearchImageReq;
import com.snailvoyager.springbootnavermap.naver.dto.SearchImageRes;
import com.snailvoyager.springbootnavermap.naver.dto.SearchLocalReq;
import com.snailvoyager.springbootnavermap.naver.dto.SearchLocalRes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "naver", url = "${naver.openapi-url}", configuration = NaverFeignConfig.class, fallbackFactory = NaverFeignClientFallback.class)
public interface NaverFeignClient {
    @GetMapping(value = "/v1/search/local.json")
    SearchLocalRes searchLocal(@SpringQueryMap SearchLocalReq searchLocalReq);

    @GetMapping(value = "/v1/search/image")
    SearchImageRes searchImage(@SpringQueryMap SearchImageReq searchImageReq);
}
