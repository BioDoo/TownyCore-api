package com.github.hodongwook.towny.core.api.exception;

import com.github.hodongwook.towny.core.api.region.adapter.RegionAdapter;

public class AdapterNameOverlapException extends RuntimeException {

    public AdapterNameOverlapException(Class<? extends RegionAdapter> adapterClass) {
        super(adapterClass.getSimpleName() + " 어댑터의 이름이 다른 어댑터와 겹칩니다!");
    }

}
