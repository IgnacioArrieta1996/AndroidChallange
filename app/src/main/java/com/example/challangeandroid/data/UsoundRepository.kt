package com.example.challangeandroid.data

import com.example.challangeandroid.data.network.api.UsoundApi
import com.example.challangeandroid.domain.model.Sound
import com.example.challangeandroid.domain.model.toDomain
import com.example.challangeandroid.domain.repository.IGetSoundListRepository
import com.highquality.base.data.Response
import com.highquality.base.exception.GenericException
import com.highquality.base.exception.NoInternetException
import com.highquality.base.exception.ServiceErrorException
import com.highquality.base.exception.UnAuthorizeException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import java.net.UnknownHostException
import javax.inject.Inject

class UsoundRepository @Inject constructor(
    private val usoundApi: UsoundApi,
) : IGetSoundListRepository {

    override suspend fun getSoundListFromApi(): Flow<Response<List<Sound>>> = flow {

        val response = usoundApi.getSounds()

        when (response.code()) {
            200 -> {

                val mapped = response.body()?.map { it.toDomain() }
                emit(Response.Success(mapped!!))
            }

            401 -> {
                emit(
                    Response.Failure(
                        UnAuthorizeException(
                            statusCode = 401,
                            statusMessage = "Credentials Error"
                        )
                    )
                )
            }

            404 -> {
                emit(
                    Response.Failure(
                        ServiceErrorException(
                            statusCode = 401,
                            statusMessage = "Unknow endpoint"
                        )
                    )
                )
            }

            else -> {
                emit(
                    Response.Failure(
                        GenericException(
                            statusCode = 999,
                            statusMessage = "Something unexpected happened"
                        )
                    )
                )
            }
        }
    }.catch {
        it.printStackTrace()
        if (it is UnknownHostException) {
            emit(
                Response.Failure(
                    NoInternetException(
                        statusCode = 999,
                        statusMessage = "Something unexpected happened"
                    )
                )
            )
        } else {
            emit(
                Response.Failure(
                    GenericException(
                        statusCode = 999,
                        statusMessage = "Something unexpected happened"
                    )
                )
            )
        }
    }

}
