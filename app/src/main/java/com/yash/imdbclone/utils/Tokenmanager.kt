package com.yash.imdbclone.utils

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class Tokenmanager @Inject constructor(@ApplicationContext context: Context) {
    private val sharedPreferences=context.getSharedPreferences("TMDB_TOKEN",Context.MODE_PRIVATE)
    fun saveToken(token:String){
        val editor=sharedPreferences.edit()
        editor.putString("TOKEN",token)
        editor.apply()

    }
    fun getToken():String?{
        return sharedPreferences.getString("TOKEN",null)
    }
}