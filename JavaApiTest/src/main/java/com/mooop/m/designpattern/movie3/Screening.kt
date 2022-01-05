package com.mooop.m.designpattern.movie3

import com.mooop.m.designpattern.movie.Money
import com.mooop.m.designpattern.movie.Movie
import com.mooop.m.designpattern.movie.Reservation
import com.mooop.m.designpattern.movie2.Customer
import java.time.LocalDateTime

class Screening {
    var movie: Movie? = null
    val sequence:Int = 0
    var wheenScreened: LocalDateTime? = null

    fun reserve(customer:Customer , audienceCount:Int): Reservation =
        Reservation(customer , this , calculateFee(audienceCount) , audienceCount)


    private fun calculateFee(audienceCount:Int): Money =
        movie.calculateMovieFee(this).times(audienceCount)
}