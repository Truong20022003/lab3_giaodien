package com.example.lab1.lythuyet

fun main()
{
    val soA: Int? = 1
    val soB: Int? = 2
    val tong = tinhTong(soA!!, soB!!)
    val hieu = tinhHieu(soA!!,soB!!)

    println("Tong 2 so $soA + $soB: $tong")
    println("Hieu 2 so $soA - $soB: $hieu")
    println("binh phuong ${binhphuong(soA)}")

}
val tinhTong : (Int,Int) -> Int = {soA: Int, soB: Int -> (soA + soB)}
val tinhHieu = {soA: Int, soB: Int -> (soA - soB)}
var binhphuong:(Int)->Int={it*it}