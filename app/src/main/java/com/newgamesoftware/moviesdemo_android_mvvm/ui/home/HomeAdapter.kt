package com.newgamesoftware.moviesdemo_android_mvvm.ui.home



import com.newgamesoftware.moviesdemo_android_mvvm.R
import com.newgamesoftware.moviesdemo_android_mvvm.base.BaseRecyclerViewAdapter
import com.newgamesoftware.moviesdemo_android_mvvm.databinding.CellHomeBinding
import com.newgamesoftware.moviesdemo_android_mvvm.model.Movie


class HomeAdapter: BaseRecyclerViewAdapter<CellHomeBinding>(R.layout.cell_home) {

    private val movies = ArrayList<Movie>()


    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.binding().movie = movies[position]

        if (position == itemCount - 1) {    //last element
            val page = itemCount / 20 + 1
            request?.invoke(page)
        }
    }


    override fun getItemCount(): Int {
        return movies.size
    }


    fun addMovies(newList: ArrayList<Movie>) {
        val oldSize = movies.size

        movies.addAll(newList)
        notifyItemRangeChanged(oldSize, movies.size)
    }
}