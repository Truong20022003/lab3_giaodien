package com.example.lab1.Lab2

class sinhvienmodel(var tensv: String, var mssv: String, var diemTb: Float) {
    var daTotNghiep: Boolean? = null
    var tuoi: Int? = null
    constructor( tenSV: String,  mssv: String,  diemTB: Float, daTotNghiep: Boolean?, tuoi: Int?) : this(tenSV, mssv, diemTB) {
        this.daTotNghiep = daTotNghiep
        this.tuoi = tuoi
    }
    fun getThongTin(): String {
        val sDaTotNghiep:String
        if (daTotNghiep==null){
            sDaTotNghiep="chua co du lieu"
        }else{
            if (daTotNghiep!!){
                sDaTotNghiep="da tot nghiep"
            }else{
                sDaTotNghiep="chua tot nghiep"
            }
        }
        var sTuoi:String
        if (tuoi==null){
            sTuoi="chua co du lieu"
        }else{
            sTuoi=tuoi.toString()
        }
        return "Ten:$tensv, mssv:$mssv,diemTb:$diemTb, datotnghiem: $sDaTotNghiep,tuoi:$sTuoi "
    }
}