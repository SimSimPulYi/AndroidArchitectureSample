package com.saehyun.core_data.mapper

interface ListMapper<in I, out O> : Mapper<List<I>, List<O>>

class ListMapperImpl<in I, out O>(
    private val mapper: Mapper<I, O>
) : ListMapper<I, O> {
    override fun map(input: List<I>): List<O> =
        input.map(mapper::map)
}
