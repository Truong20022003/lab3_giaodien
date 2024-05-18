package com.example.lab1.Bt_buoi3.Bai7

class QuanLyCBGV {
    private val danhSachCBGV = mutableListOf<CBGV>()

    fun themCBGV(gv: CBGV) {
        danhSachCBGV.add(gv)
    }

    // Overload phương thức themCBGV để thêm CBGV từ thông tin đầu vào
    fun themCBGV(
        hoTen: String,
        tuoi: Int,
        queQuan: String,
        maSoGV: String,
        luongCung: Float,
        luongThuong: Float,
        tienPhat: Float
    ) {
        val gv = CBGV(hoTen, tuoi, queQuan, maSoGV, luongCung, luongThuong, tienPhat)
        themCBGV(gv)
    }

    fun xoaCBGV(maSoGV: String) {
        val iterator = danhSachCBGV.iterator()
        while (iterator.hasNext()) {
            val gv = iterator.next()
            if (gv.maSoGV == maSoGV) {
                iterator.remove()
                break
            }
        }
    }

    // Phương thức lấy danh sách CBGV
    fun layDanhSachCBGV(): List<CBGV> {
        return danhSachCBGV
    }
}
