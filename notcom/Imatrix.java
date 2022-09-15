public interface Imatrix{
	void set(int row, int column, int value);

	int get(int row, int column);

	Imatrix sum(Imatrix a);

	Imatrix product(Imatrix a);

	int getRow();
	
	int getColumn();
	

}