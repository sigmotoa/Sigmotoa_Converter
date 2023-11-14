package com.sigmotoa.sigmotoaconverter.data

/**
 *
 * Created by sigmotoa on 12/11/23.
 * @author sigmotoa
 *
 * www.sigmotoa.com
 */
class ResultRepository(private val apiService: ApiService) {
    suspend fun getResult(from: String, to: String, number: String): Result {
        return apiService.getResult(from, to, number)
    }
}