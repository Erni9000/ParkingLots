package parking


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
     size: Int,
     var parkingLots: MutableList<ParkingLot> = mutableListOf()
) {
    init {
        for (i in 1..  size) parkingLots.add(ParkingLot(i))
        //println(parkingLots.size)
    }
    fun getEmptySpace(): Int {
      //  println(parkingLots.size)
        for (i in 0 until parkingLots.size) {
           // println(i)
            if (parkingLots[i].isEmpty()) {
                return i
            }
        }
        return -1
    }
    fun printStatus(): String {
        var status: String = ""
        for (i in 0 until parkingLots.size) {
            if (!parkingLots[i].isEmpty()) status += "${i+1} ${parkingLots[i].car?.carNumber} ${parkingLots[i].car?.carColor}\n"
        }
        return status
    }
    fun park(car: Car): Boolean {
        var lotID = getEmptySpace()
        if (lotID == -1) return false
        return parkingLots[lotID].parkCar(car)
    }
    fun clearCar(lotID: Int) {
        parkingLots[lotID-1].clearCar()
    }

}

fun main() {
    var ParkHouse: ParkHouse = ParkHouse(1)
    var parkhouseCreated: Boolean = false
    Loop@while (true){
        val userInput = readln().filter { it != '.' }.split(" ") as MutableList<String>
        when(userInput[0]) {
            "create" -> {
                if (userInput[1].toInt() > 0){
                     ParkHouse = ParkHouse(userInput[1].toInt())
                    parkhouseCreated = true
                    println("Created a parking lot with ${ParkHouse.parkingLots.size} spots.")
                    continue@Loop
                }
            }
            "park" -> {
                if (parkhouseCreated){
                    val parkingNumber: Int = ParkHouse.getEmptySpace()
                    val Car: Car = Car(userInput[1], userInput[2])
                    if(ParkHouse.park(Car)) println("${Car.carColor} car parked in spot ${parkingNumber+1}.")
                    else println("Sorry, the parking lot is full.")
                } else println("Sorry, a parking lot has not been created.")

                continue@Loop
            }
            "leave" -> {
                if (parkhouseCreated){
                    ParkHouse.clearCar(userInput[1].toInt())
                    println("Spot ${userInput[1].toInt()} is free.")
                    continue@Loop
                } else println("Sorry, a parking lot has not been created.")

            }
            "exit" -> {
                break@Loop
            }
            "status" -> {
                if (parkhouseCreated){
                    if (ParkHouse.printStatus() == "") println("Parking lot is empty.")
                    else print(ParkHouse.printStatus())
                } else println("Sorry, a parking lot has not been created.")

            }

        }
    }

}
