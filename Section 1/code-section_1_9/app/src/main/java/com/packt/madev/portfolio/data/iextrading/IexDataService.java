package com.packt.madev.portfolio.data.iextrading;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IexDataService {
    @GET("stock/{symbol}/quote")
    Single<IexQuote> getQuote(
            @Path("symbol") String symbol
    );
}
