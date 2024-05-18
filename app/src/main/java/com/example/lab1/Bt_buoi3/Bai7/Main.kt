package com.example.lab1.Bt_buoi3.Bai7

fun main() {
    val quanLy = QuanLyCBGV()
    val gv1 = CBGV("Nguyen Van A", 35, "Ha Noi", "GV001", 500f, 10000f, 5000f)
    val gv2 = CBGV("Tran Thi B", 40, "Hai Phong", "GV002", 60000f, 1500f, 0f)
    quanLy.themCBGV(gv1)
    quanLy.themCBGV(gv2)
    println("------------------------")
    println("Menu quan ly GV")
    println("1. Them giao vien")
    println("2. Hien thi danh sach GV")
    println("3. Xoa GV")
    println("4. Thoat chuong trinh")

    var tiepTuc: Boolean
    do {
        try {
            print("Nhap lua chon cua ban: ")
            val options: Int = readLine()!!.toInt()
            when (options) {
                1 -> {
                    println(" Them danh sach giao vien")
                    println("--------------------------")
                    var ten: String=""
                    var tuoi: Int = 0
                    var queQuan: String = ""
                    var ma: String = ""
                    var luongCung: Float = 0.0f
                    var luongThuong: Float = 0.0f
                    var tienPhat: Float = 0.0f

                    println("Nhập tên:")
                    var s = readLine()
                    if (s != null) ten = s.toString()

                    println("Nhập tuoi:")
                    s = readLine()
                    if (s != null) tuoi = s.toInt()

                    println("Nhập quê:")
                    s = readLine()
                    if (s != null) queQuan = s.toString()

                    println("Nhập mã:")
                    s = readLine()
                    if (s != null) ma = s.toString()

                    println("Nhập lương cứng:")
                    s = readLine()
                    if (s != null) luongCung = s.toFloat()

                    println("Nhập lương thưởng:")
                    s = readLine()
                    if (s != null) luongThuong = s.toFloat()

                    println("Nhập lương phạt:")
                    s = readLine()
                    if (s != null) tienPhat = s.toFloat()

                    quanLy.themCBGV(ten, tuoi, queQuan, ma, luongCung, luongThuong, tienPhat)
                    gv1.tinhLuongThucLinh()
                    gv2.tinhLuongThucLinh()

                    quanLy.layDanhSachCBGV().forEach { gv ->
                        gv.tinhLuongThucLinh()
                    }
                    println("Thông tin lương thực lĩnh của các giáo viên:")
                    quanLy.layDanhSachCBGV().forEachIndexed { index, gv ->
                        println("Giảng viên số:$index, ${gv.hoTen} - Mã số: ${gv.maSoGV} - Lương thực lĩnh: ${gv.luongThucLinh}")
                    }
                }
/////////////////////////
                2 -> {
                    println("Danh sach giao vien")
                    println("--------------------------")
                    quanLy.layDanhSachCBGV().forEachIndexed { index, gv ->
                        println("Giảng viên số:${index+1}, ${gv.hoTen} - Mã số: ${gv.maSoGV} - Lương thực lĩnh: ${gv.luongThucLinh}")
                    }
                }

                3 -> {
                    println("Xoa giao vien")
                    println("--------------------------")
                    println("Nhap msgv can xoa: ")
                    // Xóa CBGV có mã số "GV001"
                    val s= readLine()
                    var msgv:String?=""
                    if (s!=null)msgv=s.toString()
                    quanLy.xoaCBGV(msgv!!)
                    println("Danh sách sau khi xoá:")
                    quanLy.layDanhSachCBGV().forEach { gv ->
                        println("${gv.hoTen} - Mã số: ${gv.maSoGV}")
                    }
                }
                4 -> {
                    println("Ket thuc chuong trinh")
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

