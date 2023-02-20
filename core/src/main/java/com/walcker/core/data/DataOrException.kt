package com.walcker.core.data

class DataOrException<T, B, E : Exception>(
    var data: T? = null,
    var loading: Boolean? = null,
    var e: E? = null
)