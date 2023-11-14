package com.sigmotoa.sigmotoaconverter.data

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 *
 * Created by sigmotoa on 12/11/23.
 * @author sigmotoa
 *
 * www.sigmotoa.com
 */
interface ApiService {

    @GET()
    suspend fun getResult(@Query("from") from: String, @Query("to") to: String, @Path("number") number: String): Result
}