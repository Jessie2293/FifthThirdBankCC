package com.fifththirdbankcc.utils

import com.fifththirdbankcc.model.Joke

sealed class JokeResult {
    object LOADING : JokeResult()
    class SUCCESS(val data: Joke) : JokeResult()
    class ERROR(val error: Throwable) : JokeResult()
}
