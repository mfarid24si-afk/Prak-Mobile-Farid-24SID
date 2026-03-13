package com.example.random.pertemuan2

fun main(){
    println("Hai rekan-rekan...")
    println("Selamat datang di bahasa pemrograman kotlin")

    println("=============")

    var angka = 15
    println("Hasil dasri 15 + 10 = ${angka + 10}")

    val nilaiInt = 10000
    val nilaiDouble = 100.003
    val nilaiFloat = 1000.0f

    println("Nilai Integer = $nilaiInt")
    println("Niali Double = $nilaiDouble")
    println("Nilai Float + $nilaiFloat")

    println("============ String ==============")
    val huruf = 'a'
    println("Ini penggunaan karakter '$huruf")

    val nilaiString = "Mawar"
    println("Halo $nilaiString!\nApa Kabar?")


    println("========== Kondisi ===========")

    val nilai = 10
    if (nilai<0)
    println("Bilangan negatif")
    else{
        if(nilai%2===0)
            println("Bilangan Genap")
        else
            println("Bilangan Ganjil")
    }
    println("======== Perulangan ========")
    val kampusKu: Array<String>
 = arrayOf("kampus", "Politeknik", "Caltex", "Riau")
    for(kampus: String in kampusKu){
        println(kampus)
    }
}