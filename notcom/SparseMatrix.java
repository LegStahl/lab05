import java.util.*;

public class SparseMatrix implements Imatrix{
	
	private LinkedList<TripleClass> smatrix;
	
	private int row;
	
	private int column;
	
	public SparseMatrix(int row, int column){
		this.row = row;
		this.column = column;
		smatrix = new LinkedList<>();
	}
	
	public void set(int row, int column, int value){
		if(((this.row <= row) || (row < 0)) || ((this.column <= column) || (column < 0)))
			throw new RuntimeException("Invalid index: Sparse");
		ListIterator<TripleClass> iter = smatrix.listIterator();
		TripleClass a;
		while(iter.hasNext()){
			a = iter.next();
			if((a.rowT == row) && (a.columnT == column)){
				iter.previous();
				iter.remove();
				TripleClass element = new TripleClass(row, column, value);
				iter.add(element);
				return;
			}
		}
		TripleClass element = new TripleClass(row, column, value);
		iter.add(element);
	}
	
	public int get(int row, int column){
		if(((this.row <= row) || (row < 0)) || ((this.column <= column) || (column < 0)))
			throw new RuntimeException("Invalid index: Sparse");
		ListIterator<TripleClass> iter = smatrix.listIterator();
		TripleClass a;
		while(iter.hasNext()){
			a = iter.next();
			if((a.rowT == row) && (a.columnT == column)){
				return a.valueT;
			}
		}
		return 0;
	}
	
	public Imatrix sum(Imatrix a){
		if(row != a.getRow() || column != a.getColumn()){
			throw new RuntimeException("Cannot sum these matrixes, invalid index");
		}
		Imatrix msum = new UsualMatrix(row, column);
		for( int i = 0; i < row; i++){
			for( int j = 0; j < column; j++){
				msum.set(i, j, get(i, j) + a.get(i,j));
			}
		}
		return msum;
	}
	
	public Imatrix product(Imatrix a){
		if(column != a.getRow())
			throw new RuntimeException("Cannot product these matrixes, invalid size (UsualMatrix) ");
		SparseMatrix result = new SparseMatrix(getRow(), a.getColumn());
		int res = 0;
		for( int i = 0; i < result.getRow(); i ++){
			for( int j = 0; j < result.getColumn(); j++){
				for( int k = 0; k < this.getRow(); k++){
					res += get(i,k) * a.get(k,j);
				}
				result.set(i, j, res);
				res = 0;
			}
		}				
		return result;
	}

	public int getRow(){
		return this.row;
	}
	
	public int getColumn(){
		return this.column;
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		for( int i = 0; i < row; i++){
			for( int j = 0; j < column; j++){
				sb.append(this.get(i,j));
				sb.append(" ");
			} 
			sb.append("\n");
		}
		return sb.toString();
	}
		
	public boolean eguals(Object b){
    		if(b instanceof Imatrix){
		System.out.println("Flag5");
		Imatrix a = (Imatrix)b;
			if((this.getRow() == a.getRow()) && (this.getColumn() == a.getColumn())){
				System.out.println("Flag1");
				for(int i = 0; i < getRow(); i++){
					for(int j = 0; j < getColumn(); j++){
						if(this.get(i, j) != a.get(i,j))
							return false;
					}
				}
				System.out.println("Flag2");
				return true;
			}
			else
				return false;
		}
		else {
			System.out.println("Flag3");
			return false;
		}
		
	}

}