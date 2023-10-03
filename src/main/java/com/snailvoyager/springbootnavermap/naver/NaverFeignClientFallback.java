package com.snailvoyager.springbootnavermap.naver;

import com.snailvoyager.springbootnavermap.naver.dto.SearchImageReq;
import com.snailvoyager.springbootnavermap.naver.dto.SearchImageRes;
import com.snailvoyager.springbootnavermap.naver.dto.SearchLocalReq;
import com.snailvoyager.springbootnavermap.naver.dto.SearchLocalRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NaverFeignClientFallback implements FallbackFactory<NaverFeignClient> {
    @Override
    public NaverFeignClient create(Throwable cause) {
        return new NaverFeignClient() {
            @Override
            public SearchLocalRes searchLocal(SearchLocalReq searchLocalReq) {
                log.error("NaverFeignClient SearchLocalRes Error.", cause);
                return new SearchLocalRes();
            }

            @Override
            public SearchImageRes searchImage(SearchImageReq searchImageReq) {
                log.error("NaverFeignClient SearchImageRes Error.", cause);
                return new SearchImageRes();
            }
        };
    }
}
