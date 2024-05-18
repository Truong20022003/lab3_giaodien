package com.example.lab1.Lab2

fun main() {
    var bai = 0
    var s: String?
    val listSV = mutableListOf<sinhvienmodel>()
    var sv1 = sinhvienmodel("nguyen van long", "ph11", 8f,true,30)
    var sv2 = sinhvienmodel("nguyen van long", "ph11", 8f,false,20)
    listSV.add(sv1)
    listSV.add(sv2)
    println("chon bai tap 1-3")
    println("chon bai 1 slide")
    println("chon bai 2 slide")
    println("chon bai 3 slide")
    println("chon bai 4 giao them")
    do {
        println("nhập bài bạn muốn chọn :")
        s = readLine()
        while (s == null || s.toInt() < 0) {
            println("nhap sai ||hoac ko co su lua chon")
            s = readLine()
        }
        bai = s.toInt()
        if (bai == 1) {
            var a = 0.0
            var b = 0.0
            println("Nhập a:")
            var s = readLine()
            if (s != null) a = s.toDouble()
            println("Nhập b:")
            s = readLine()
            if (s != null) b = s.toDouble()
            if (a == 0.0 && b == 0.0) {
                println("Phương trình vô số nghiệm")
            } else if (a == 0.0 && b != 0.0) {
                println("Phương trình vô nghiệm")
            } else {
                val x = -b / a
                println("No x=" + x)
            }
        }
        if (bai == 2) {
            var month = 0
            println("Nhập tháng:")
            val s: String? = readLine()
            if (s != null) month = s.toInt()
            when (month) {
                1, 2, 3 -> println("Tháng " + month + " thuộc quý 1")
                4, 5, 6 -> println("Tháng " + month + " thuộc quý 2")
                7, 8, 9 -> println("Tháng " + month + " thuộc quý 3")
                10, 11, 12 -> println("Tháng " + month + " thuộc quý 4")
                else -> println("Tháng " + month + " không hợp lệ")
            }
        }
        if (bai == 3) {
            var year = 0
            var s: String?
            println("Chương trình kiểm tra năm nhuần:")
            do {
                println("Nhập 1 năm:")
                s = readLine()
                while (s == null || s.toInt() < 0) {
                    println("Nhập sai năm, nhập lại:")
                    s = readLine()
                }
                year = s.toInt()
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                    println("Năm $year là năm nhuần")
                } else {
                    println("Năm $year không phải là năm nhuần")
                }
                print("Tiếp không?(c/k):")
                s = readLine()
                if (s == "k")
                    break;
            } while (true)
            println("Kết thúc chương trình")
        }
        if (bai == 4) {
            var so = 0
            println("case1:Thêm,case2:Xóa")
            println("Chọn case:")
            var s = readLine()
            if (s != null) so = s.toInt()
            when (so) {
                1 -> {
                    println("Nhập thông tin sinh viên mới:")
                    println("Nhập mssv:")
                    var mssv: String? = readLine();
                    println("Nhập tên sv:")
                    var tensv: String? = readLine()
                    println("Nhập điểm tb:")
                    var diemTb = 0.0f
                    s = readLine();
                    if (s != null) diemTb = s.toFloat()
                    println("Nhập trạng thái tốt nghiệp:")
                    var daTotNghiep: Boolean? = null
                    s = readLine();
                    if (s != null) daTotNghiep = s.toBoolean()
                    println("Nhập tuổi:")
                    var tuoi = 0
                    s = readLine()
                    if (s != null) tuoi = s.toInt()
                    var newsv = sinhvienmodel(mssv!!, tensv!!, diemTb!!, daTotNghiep, tuoi)
                    listSV.add(newsv)
                    println("Danh sách sinh viên sau khi thêm:")
                    listSV.forEachIndexed { index, sinhVien ->
                        println("sinh viên thứ ${index + 1}: ${sinhVien.getThongTin()}")
                    }
                }
                2 -> {
                    if (listSV.isNotEmpty()) {
                        println("Danh sách sinh viên hiện tại:")
                        listSV.forEachIndexed { index, sinhVien ->
                            println("sinh viên thứ ${index + 1}: ${sinhVien.getThongTin()}")
                        }
                        println("Nhập số thứ tự của sinh viên cần xóa:")
                        var index = readLine()?.toIntOrNull()
                        if (index != null && index > 0 && index <= listSV.size) {
                            listSV.removeAt(index - 1)
                            println("Đã xóa sinh viên thành công!")
                        } else {
                            println("Số thứ tự không hợp lệ!")
                        }
                    } else {
                        println("Danh sách sinh viên hiện đang trống!")
                    }
                }
                else -> println("Lựa chọn không hợp lệ")
            }
        }
        println("ban co muon tiep tục chọn bài tập ko(c/k)")
        s = readLine()
        if (s == "k") break;
    } while (true)

}