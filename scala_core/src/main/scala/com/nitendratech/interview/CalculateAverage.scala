object CalculateAverage {
   
    def main(args: Array[String]) {
        
        val cusArray = Array(0,1,0,2,1,1,4,0,0,0,3,2,1,3,0,2,2,4)
        
        //print elements
        for (x<- cusArray) {println(x)}
        
        var sum = 0.0;
        
    for (i <- 0 to (cusArray.length -1)){
        sum += cusArray(i);
    }
    
    val average = sum/cusArray.length
    
    println("Average value is: "+average)
            
        }
        
        
    }