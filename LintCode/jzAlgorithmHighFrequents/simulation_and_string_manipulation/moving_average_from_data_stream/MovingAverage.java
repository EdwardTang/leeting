public class MovingAverage {
    int id;
    int size;
    double[] sum;
    
    /*
    * @param size: An integer
    */public MovingAverage(int size) {
        id = 0;
        this.size = size;
        sum = new double[1000000];
    }

    /*
     * @param val: An integer
     * @return:  
     */
    public double next(int val) {
        id++;
        sum[id] = sum[id - 1] + val;
        if((id - size) >= 0)
        {
            return (sum[id] - sum[id - size]) / size;
        }
        else
        {
            return sum[id] / id;
        }
    }
}