package com.snailvoyager.springbootnavermap.naver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchImageReq {
    private String query = "";
    private int display = 1;
    private int start = 1;
    private String sort = "sim";

    private String filter = "all";

    public MultiValueMap<String, String> toMultiValueMap() {    //parameter를 map에 담아서 전송하기 위해 사용
        var map = new LinkedMultiValueMap<String, String>();
        map.add("query", query);
        map.add("display", String.valueOf(display));
        map.add("start", String.valueOf(start));
        map.add("sort", sort);
        map.add("filter", filter);

        return map;
    }
}
