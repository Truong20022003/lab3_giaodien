package com.example.lab1.Bt_buoi3.Bai8

import com.example.lab1.Bt_buoi3.Bai7.CBGV
import java.time.LocalDate

class TheMuon(
    val maPhieuMuon: String,
    val ngayMuon: LocalDate,
    val hanTra: LocalDate,
    val soHieuSach: String,
    val sinhVien: SinhVien
) {
//    fun themCBGV(
//        hoTen: String,
//        tuoi: Int,
//        queQuan: String,
//        maSoGV: String,
//        luongCung: Float,
//        luongThuong: Float,
//        tienPhat: Float
//    ) {
//        val gv = CBGV(hoTen, tuoi, queQuan, maSoGV, luongCung, luongThuong, tienPhat)
//        themCBGV(gv)
//    }

    companion object {
        // Danh sách các thẻ mượn
        private val danhSachTheMuon = mutableListOf<TheMuon>()

        // Phương thức thêm thẻ mượn
        fun themTheMuon(theMuon: TheMuon) {
            danhSachTheMuon.add(theMuon)
        }
        fun themTheMuon(  maPhieuMuon: String,
                          ngayMuon: LocalDate,
                          hanTra: LocalDate,
                          soHieuSach: String,
                          sinhVien: SinhVien){
            val pm=TheMuon(maPhieuMuon, ngayMuon,hanTra,soHieuSach,sinhVien)
           themTheMuon(pm)
        }
        // Phương thức xóa thẻ mượn theo mã phiếu mượn
        fun xoaTheMuon(maPhieuMuon: String) {
            val iterator = danhSachTheMuon.iterator()
            while (iterator.hasNext()) {
                val theMuon = iterator.next()
                if (theMuon.maPhieuMuon == maPhieuMuon) {
                    iterator.remove()
                    break
                }
            }
        }

        // Phương thức hiển thị thông tin các thẻ mượn
        fun hienThiDanhSachTheMuon() {
            danhSachTheMuon.forEachIndexed { index, theMuon ->
                println("Phiếu mượn số ${index+1}")
                println("Mã phiếu mượn: ${theMuon.maPhieuMuon}")
                println("Ngày mượn: ${theMuon.ngayMuon}")
                println("Hạn trả: ${theMuon.hanTra}")
                println("Số hiệu sách: ${theMuon.soHieuSach}")
                println("Thông tin sinh viên mượn sách:")
                println("- Họ tên: ${theMuon.sinhVien.hoTen}")
                println("- Tuổi: ${theMuon.sinhVien.tuoi}")
                println("- Lớp: ${theMuon.sinhVien.lop}")
                println()
            }
        }
    }
}