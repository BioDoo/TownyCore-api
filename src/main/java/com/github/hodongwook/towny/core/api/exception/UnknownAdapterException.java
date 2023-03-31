package com.github.hodongwook.towny.core.api.exception;

import com.github.hodongwook.towny.core.api.region.adapter.RegionAdapter;

public class UnknownAdapterException extends RuntimeException {

    public UnknownAdapterException(Class<? extends RegionAdapter> adapterClass) {
        super(adapterClass.getName() + " 어댑터를 찾을 수 없습니다.");
    }

}
