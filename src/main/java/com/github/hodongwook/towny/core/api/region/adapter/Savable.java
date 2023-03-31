package com.github.hodongwook.towny.core.api.region.adapter;

import com.google.gson.Gson;

/**
 * 어댑터가 자동으로 저장/로드 되어야 할 때 구현하는 인터페이스
 */
public interface Savable {

    /**
     * 데이터를 Json 으로 반환합니다.
     * @return Json
     */
    default String toJson() {
        return new Gson().toJson(this);
    }

}
