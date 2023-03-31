package com.github.hodongwook.towny.core.api;

public final class TownyCore {

    private static TownyApi api = null;

    /**
     * API 를 얻어옵니다.
     * @return TownyApi
     */
    public static TownyApi getApi() { return api; }

    private static void setApi(TownyApi api) { TownyCore.api = api; }
    private static void unsetApi() { TownyCore.api = null; }

}
