class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];
        
        // We will have to iterate over all rows once.
        for(int i = 0; i < bookings.length; i++) {
            int flightLabel = bookings[i][0];
            // Start from start value and go till end value of flight label.
            while(flightLabel <= bookings[i][1]) {
                // Actual index in result array will be 1 less than the flight label, hence flightLabel - 1.
                result[flightLabel - 1] = result[flightLabel - 1] + bookings[i][2];
                flightLabel++;
            }
        }
        return result;
    }
}
