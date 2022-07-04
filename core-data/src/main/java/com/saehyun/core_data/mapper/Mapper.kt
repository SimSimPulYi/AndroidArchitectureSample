package com.saehyun.core_data.mapper

interface Mapper<in I, out O> {
    fun map(input: I): O
}