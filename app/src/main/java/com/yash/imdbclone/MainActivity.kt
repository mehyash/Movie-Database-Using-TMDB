package com.yash.imdbclone

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.yash.imdbclone.adapter.MovieAdapter
import com.yash.imdbclone.databinding.ActivityMainBinding
import com.yash.imdbclone.utils.Tokenmanager
import com.yash.imdbclone.utils.constant.Companion.token
import com.yash.imdbclone.viewModel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<MovieViewModel>()
    @Inject
    lateinit var tokenManager:Tokenmanager
    lateinit var movieAdapter: MovieAdapter
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        tokenManager.saveToken(token)
        viewModel.getMovielist()
        viewModel.movieListLiveData.observe(this){
            val list=it.data?.results
            movieAdapter=MovieAdapter(list!!)
            binding.rv.adapter=movieAdapter
        }
        binding.rv.layoutManager=LinearLayoutManager(this)

    }
}