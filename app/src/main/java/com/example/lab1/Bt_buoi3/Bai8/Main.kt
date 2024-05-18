package com.example.lab1.Bt_buoi3.Bai8

import java.time.LocalDate

fun main() {
    // Sinh viên mượn sách
    val sinhVien = SinhVien("Nguyen Van A", 20, "12A")
    // Thêm một thẻ mượn sách
    val theMuon1 = TheMuon("PM001", LocalDate.now(), LocalDate.now().plusDays(7), "SH001", sinhVien)
    TheMuon.themTheMuon(theMuon1)
    // Thêm một thẻ mượn sách khác
    val theMuon2 =
        TheMuon("PM002", LocalDate.now(), LocalDate.now().plusDays(14), "SH002", sinhVien)
    TheMuon.themTheMuon(theMuon2)
    println("------------------------")
    println("Menu quan phieu muon")
    println("1. Them sinh phieu muon")
    println("2. Hien thi danh sach phieu muon")
    println("3. Xoa phieu muon")
    println("4. Thoat chuong trinh")
    var tiepTuc: Boolean
    do {
        try {
            print("Nhap lua chon cua ban: ")
            val options: Int = readLine()!!.toInt()
            when (options) {
                1 -> {
                    println("\nThem danh sach phieu muon")
                    println("--------------------------")
                    println("Thêm phiếu mượn:")
                    var mspm: String? = readLine()
                    println("thêm số hiệu sách:")
                    var sohieusach: String? = readLine()
                TheMuon.themTheMuon(mspm!!,LocalDate.now(),LocalDate.now(),sohieusach!!,sinhVien)
                    TheMuon.hienThiDanhSachTheMuon()
                }
                2 -> {
                    println("\nDanh sach phieu muon")
                    println("--------------------------")
                    TheMuon.hienThiDanhSachTheMuon()
                }
                3 -> {
                    println("\nXoa phieu muon")
                    println("--------------------------")
                    println("nhap ma phieu muon muon xoa")
                    var s = readLine()
                    var mpm: String? = ""
                    if (s != null) mpm = s.toString()

                    // Xóa một thẻ mượn
                    TheMuon.xoaTheMuon(mpm!!)
                    println("Danh sách sau khi xóa:")
                    TheMuon.hienThiDanhSachTheMuon()
                }

                4 -> {
                    println("\nKet thuc chuong trinh")
                    tiepTuc = false
                }

                else -> {
                    println("Nhap sai, vui long nhap lai")
                }
            }
            println("Ban co muon chon tiep lua chon tren menu? (c/k) ")
            val s = readLine()
            tiepTuc = s == "c"
        } catch (e: Exception) {
            println("Nhap sai, vui long nhap lai")
            tiepTuc = true
        }

    } while (tiepTuc)

}