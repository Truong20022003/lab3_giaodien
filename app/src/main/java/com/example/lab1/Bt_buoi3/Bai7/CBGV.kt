package com.example.lab1.Bt_buoi3.Bai7

// CBGV.kt
// CBGV.kt
class CBGV(
    hoTen: String,
    tuoi: Int,
    queQuan: String,
    maSoGV: String,
    val luongCung: Float,
    val luongThuong: Float,
    val tienPhat: Float
) : Nguoi(hoTen, tuoi, queQuan, maSoGV) {

    var luongThucLinh: Float = 0.0f

    fun tinhLuongThucLinh() {
        luongThucLinh = luongCung + luongThuong - tienPhat
    }
}
