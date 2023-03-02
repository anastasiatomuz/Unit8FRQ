public class ItemGrid
{
    private Item[][] grid;

    /** Constructor */
    public ItemGrid(Item[][] grid)
    {
        this.grid = grid;
    }

    /** Returns true if row is a valid row index and column is a valid
     *  column index and returns false otherwise.
     *  THIS CODE WAS NOT PROVIDED IN FRQ, but here is what you would have seen if it had been
     */
    public boolean isValid(int row, int column)
    {
        if (row < 0 || row >= grid.length)
        {
            return false;
        }
        if (column < 0 || column >= grid[0].length)
        {
            return false;
        }

        return true;
    }

    /** Compares the item in row r and column c to the items to its
     *  left and to its right. Returns the name of the item with
     *  the greatest value, as described in part (a).
     *
     *  Precondition: r and c are valid indices
     */
    public String mostValuableNeighbor(int r, int c)
    {
        int numItems = 1;
        if (isValid(r, c - 1)){
            numItems ++;
        }
        if (isValid(r, c + 1)){
            numItems ++;
        }
        Item[] neighbors = new Item[numItems];
        if (isValid(r, c - 1)){
            neighbors[numItems - 1] = grid[r][c - 1];
            numItems --;
        }
        neighbors[numItems - 1] = grid[r][c];
        numItems --;
        if (isValid(r, c + 1)){
            neighbors[numItems - 1] = grid[r][c + 1];
            numItems --;
        }
        int greatestValue = neighbors[0].getValue();
        String greatestName = neighbors[0].getName();
        for (Item thing : neighbors){
            if (thing.getValue() > greatestValue){
                greatestValue = thing.getValue();;
                greatestName = thing.getName();
            }
        }
        return greatestName;
    }

    /** Returns the average value of all the items in grid,
     *  as described in part (b).
     */
    public double findAverage()
    {
       double sum = 0;
       int count = 0;
       for (Item[] row : grid){
           for (Item thing : row){
               sum += thing.getValue();
               count ++;
           }
       }
       return sum / count;
    }
}