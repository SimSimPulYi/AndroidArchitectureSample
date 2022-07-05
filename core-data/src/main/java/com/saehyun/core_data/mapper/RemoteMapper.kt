package com.saehyun.core_data.mapper

interface RemoteMapper<in I, out O> {
    fun map(input: I): O
}