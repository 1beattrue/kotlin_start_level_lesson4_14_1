fun main() {
    Database.getInstance().insertData(1)
    Database.getInstance().insertData(2)
    println(Database.getInstance().data)

    DatabaseObj.insertData(1)
    DatabaseObj.insertData(2)
    DatabaseObj.insertData(3)
    println(DatabaseObj.data)
}

class Database private constructor() { // ручная реализация SingleTon
    val data = mutableListOf<Int>()
    fun insertData(int: Int) {
        data.add(int)
    }

    companion object {
        private var db: Database? = null
        fun getInstance(): Database {
            db?.let {
                return it
            }
            val instance = Database()
            db = instance
            return instance
        }
    }
}

object DatabaseObj { // реализация SingleTon на kotlin
    val data = mutableListOf<Int>()
    fun insertData(int: Int) {
        data.add(int)
    }
}