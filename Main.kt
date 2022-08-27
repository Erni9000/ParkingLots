package parking

// Creating multidimensional List
class ParkingLot(
    var parkingNumber: Int,
    var car: Car? = null
) {
    var isEmpty: () -> Boolean = {car == null}
    fun parkCar (car: Car): Boolean {
        return if (this.isEmpty()) {
            this.car = car
            true
        } else false

    }
    fun clearCar(){
        this.car = null
    }
}
class Car(
    var carNumber: String = "",
    var carColor: String = ""
)
class ParkHouse(
    private val size: Int,
    private var parkingLots: MutableList<ParkingLot> = emptyList<ParkingLot>() as MutableList<ParkingLot>
) {
    init {
        for (i in 1 until  size) this.addLot(ParkingLot(i))
    }
    fun addLot(parkingLot: ParkingLot){
        parkingLots.plus(parkingLot)
    }

    fun getEmptySpace(): Int {
        for (i in 0 until parkingLots.size) {
            if (parkingLots[i].isEmpty()) {
                return i
            }
        }
        return -1
    }

    fun parkCar(car: Car): Boolean {
        var lotID = getEmptySpace()
        if (lotID == -1) return false
        return parkingLots[lotID].parkCar(car)
    }
    fun clearCar(lotID: Int) {
        parkingLots[lotID].clearCar()
    }

}


fun parking(parkingLotOne: ParkingLot, parkingLotTwo: ParkingLot){
       Loop@while (true){
           val userInput = readln().filter { it != '.' }.split(" ") as MutableList<String>
            when(userInput[0]) {
                "park" -> {
                   continue@Loop
                }
                "leave" -> {
                  continue@Loop
                }
                "exit" -> {
                    break@Loop
                }
            }
       }
}
fun main() {
    val ParkingHouse: ParkHouse = ParkHouse(20)

}
