//abstract sınıflar bir sınıfın yapı taşları iken interfaceler(arayüz) farklı davranış şekilleridir.
//interfaceler constructer alamazlar. bir sınıf birden çok interface i miras alabilir. Interface nesneleri oluşturulamaz
//interfacelerin bodysiz bir fonksiyon bulundurması beklenir ama nadiren fonksiyon barındırmayabilir.
//interface içersindeki bodysi olmayan fonksiyonları biz miras aldığımız classlarda override etmek zorundayız
//fonksiyonların body genellikle olmaz. fakat eğer konulan fonksiyonun bodysi {} olursa override etmek zorunda olmayız
//ama istersek de override tabiki edebiliriz. interfaceler diğer interfaceleri miras alabilir.
//nasıl abstract sınıflar diğer abstract sınıfları miras alırsa overrirde etme zorunluluğu kalkıyorsa ->
//interfaceler de diğer bir interface i miras alırsa override etme zorunluluğu kalkar.
//abstract classlarda değişken ve fonksiyon başlarına override edilmesini engelleyen final keyword u konulabilirken
//interfacelerde bu keyword kullanılamaz. abstract sınıflarda değer ataması yapılabilir(stake tutabilir)
// interfacelerde bir değişkene değer ataması yapılamaz(stake tutamaz) yani abstractların backingfieldları olabilir
//interfacelerin olamaz. companion object yapısı ile bu kural delinebiliyor ama yapılmaması gerekir.



interface Communicable {
    fun communicate(): String
}

interface Workable {
    fun work(): String
}

interface Tradable {
    fun trade(): String
}

// Human sınıfı, temel özellikler içerir.
open class Human(val name: String, val age: Int) {
    fun makeSound() {
        println("Human is making a sound.")
    }
}

// Turk sınıfı, Communicable ve Workable arayüzlerini uygular.
open class Turk(name: String, age: Int) : Human(name, age), Communicable, Workable {
    override fun communicate(): String {
        return "Türkçe konuşuyor."
    }

    override fun work(): String {
        return "Türk çalışıyor."
    }
}

// WesternTurk sınıfı, Turk sınıfını miras alır ve ek olarak Tradable arayüzünü uygular.
class WesternTurk(name: String, age: Int) : Turk(name, age), Tradable {
    override fun trade(): String {
        return "Batı'da ticaret yapıyor."
    }
}

// Kullanım
fun main() {
    val human = Human("John", 30)
    human.makeSound()

    val turk = Turk("Ahmet", 25)
    println("${turk.name} ${turk.communicate()} ve ${turk.work()}.")

    val westernTurk = WesternTurk("Mehmet", 28)
    println("${westernTurk.name} ${westernTurk.communicate()}, ${westernTurk.work()} ve ${westernTurk.trade()}.")
}
