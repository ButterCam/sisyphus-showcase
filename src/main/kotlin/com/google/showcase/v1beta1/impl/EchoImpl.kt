package com.google.showcase.v1beta1.impl

import com.bybutter.sisyphus.longrunning.Operation
import com.bybutter.sisyphus.middleware.grpc.RpcServiceImpl
import com.bybutter.sisyphus.rpc.Code
import com.bybutter.sisyphus.rpc.StatusException
import com.google.showcase.v1beta1.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

@RpcServiceImpl
class EchoImpl : Echo() {
    override suspend fun echo(input: EchoRequest): EchoResponse {
        input.error?.let {
            throw StatusException(Code(it.code), it.message)
                .withDetails(it.details)
        }
        return EchoResponse {
            this.content = input.content
            this.severity = input.severity
        }
    }

    override fun expand(input: ExpandRequest): Flow<EchoResponse> = flow {
        input.error?.let {
            throw StatusException(Code(it.code), it.message)
                .withDetails(it.details)
        }
        input.content.split(' ').forEach {
            emit(EchoResponse {
                content = it
            })
        }
    }

    override suspend fun collect(input: Flow<EchoRequest>): EchoResponse {
        val message = mutableListOf<String>()
        input.collect {
            it.error?.let {
                throw StatusException(Code(it.code), it.message)
                    .withDetails(it.details)
            }
            message += it.content
        }

        return EchoResponse {
            content = message.joinToString(" ")
        }
    }

    override fun chat(input: Flow<EchoRequest>): Flow<EchoResponse> = flow {
        input.collect {
            it.error?.let {
                throw StatusException(Code(it.code), it.message)
                    .withDetails(it.details)
            }

            emit(EchoResponse {
                this.content = it.content
                this.severity = it.severity
            })
        }
    }

    override suspend fun pagedExpand(input: PagedExpandRequest): PagedExpandResponse {
        TODO("Not yet implemented")
    }

    override suspend fun pagedExpandLegacy(input: PagedExpandLegacyRequest): PagedExpandResponse {
        TODO("Not yet implemented")
    }

    override suspend fun pagedExpandLegacyMapped(input: PagedExpandRequest): PagedExpandLegacyMappedResponse {
        TODO("Not yet implemented")
    }

    override suspend fun wait(input: WaitRequest): Operation {
        TODO("Not yet implemented")
    }

    override suspend fun block(input: BlockRequest): BlockResponse {
        TODO("Not yet implemented")
    }
}