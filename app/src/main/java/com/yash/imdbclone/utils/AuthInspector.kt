package com.yash.imdbclone.utils

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInspector @Inject constructor():Interceptor {
    @Inject
    lateinit var tokenmanager:Tokenmanager
    override fun intercept(chain: Interceptor.Chain): Response {
        val request=chain.request().newBuilder()
        val token=tokenmanager.getToken()
        request.addHeader("Authorization","Bearer ${token}")
        return chain.proceed(request.build())
    }
}