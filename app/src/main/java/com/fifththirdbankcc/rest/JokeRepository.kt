package com.fifththirdbankcc.rest

import com.fifththirdbankcc.model.JokeCategory
import com.fifththirdbankcc.utils.JokeResult
import kotlinx.coroutines.flow.StateFlow

interface JokeRepository {
    val dailyJoke: StateFlow<JokeResult>
    suspend fun getDailyJoke(category: JokeCategory)
}

class JokeRepositoryImpl(
    val jokesService: JokeService
) : JokeRepository {

    override val dailyJoke: StateFlow<JokeResult>
        get() = TODO("Not yet implemented")

    override suspend fun getDailyJoke(category: JokeCategory) {
        TODO("Not yet implemented")
    }

}