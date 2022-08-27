package parking

// Creating multidimensional List
class ParkingLot(
    var parkingNumber: Int,
    var isEmpty: Boolean = true,
    var carNumber: String = "",
    var carColor: String = ""
) {
    fun clear(){
        this.isEmpty = true
        this.carNumber = ""
        this.carColor = ""
    }
}
class ParkHouse(
    var parkingLots: MutableList<ParkingLot>,
    var emptyLotsList: MutableList<Boolean>
)
fun generateListParkingLots(amount: Int): ParkHouse {
    var parkingLots: MutableList<ParkingLot> = emptyList<ParkingLot>() as MutableList<ParkingLot>
    var emptyLotsList: MutableList<Boolean> = emptyList<Boolean>() as MutableList<Boolean>


    return ParkHouse(parkingLots,emptyLotsList)
}

fun parking(parkingLotOne: ParkingLot, parkingLotTwo: ParkingLot){
        var userInput = readln().filter { it != '.' }.split(" ") as MutableList<String>
        when(userInput[0]) {
            "park" -> {
                if (parkingLotOne.isEmpty){
                    parkingLotOne.carNumber = userInput[1]
                    parkingLotOne.carColor = userInput[2]
                    parkingLotOne.isEmpty = false
                    println("${parkingLotOne.carColor} car parked in spot ${parkingLotOne.parkingNumber}.")
                } else if (parkingLotTwo.isEmpty){
                    parkingLotTwo.carNumber = userInput[1]
                    parkingLotTwo.carColor = userInput[2]
                    parkingLotTwo.isEmpty = false
                    println("${parkingLotTwo.carColor} car parked in spot ${parkingLotTwo.parkingNumber}.")
                } 
            }
            "leave" -> {
                if (userInput[1].toInt() == parkingLotOne.parkingNumber) {
                    if (parkingLotOne.isEmpty) println("There is no car in spot ${parkingLotOne.parkingNumber}.")
                    else {
                        parkingLotOne.clear()
                        println("Spot ${parkingLotOne.parkingNumber} is free.")
                    }
                } else if (userInput[1].toInt() == parkingLotTwo.parkingNumber) {
                    if (parkingLotTwo.isEmpty) println("There is no car in spot ${parkingLotTwo.parkingNumber}.")
                    else {
                        parkingLotTwo.clear()
                        println("Spot ${parkingLotTwo.parkingNumber} is free.")
                    }
                }
            }
        }
}

fun main() {

}
