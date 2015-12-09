package regina;



/**
 * @author Adrien Agez
 * @author Sarah Wissocq
 */
public class Slice {

    private int row1;
    private int row2;
    private int col1;
    private int col2;


    public Slice(int row1, int row2, int col1, int col2) {
        this.row1 = Math.min(row1, row2);
        this.row2 = Math.max(row1, row2);
        this.col1 = Math.min(col1, col2);
        this.col2 = Math.max(col1, col2);
    }
    
    public int getRow1() {
		return row1;
	}
	public int getRow2() {
		return row2;
	}
	public int getCol1() {
		return col1;
	}
	public int getCol2() {
		return col2;
	}
	public int getSize() {
		return ((row2 - row1) + 1) * ((col2 - col1) +1);
	}

	



	@Override
	public int hashCode() {
		StringBuilder build = new StringBuilder();
		build.append(row1);
		build.append(" ");
		build.append(row2);
		build.append(" ");
		build.append(col1);
		build.append(" ");
		build.append(col2);
		return build.toString().hashCode();
	}

	@Override
	public String toString() {
		StringBuilder build = new StringBuilder();
		build.append(row1);
		build.append(" ");
		build.append(col1);
		build.append(" ");
		build.append(row2);
		build.append(" ");
		build.append(col2);
		return build.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Slice) {
			Slice that = (Slice) obj;
			return (this.row1 == that.row1) && (this.row2 == that.row2) 
					&& (this.col1 == that.col2) && (this.col2 == that.col2);    
		}
		return false;
	}
}
