package com.fifththirdbankcc.rest

import com.fifththirdbankcc.model.DailyJoke
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface JokeService {

    /**
     * Categories: ANIMAL, JOD, BLONDE, KNOCK-KNOCK
     */
    @GET(DAILY_JOKE)
    suspend fun getDailyJoke(
        @Query("category") category: String
    ): Response<DailyJoke>

    companion object {
        const val BASE_URL = "https://api.jokes.one/"
        private const val DAILY_JOKE = "jod"
    }
}