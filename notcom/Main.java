public class Main{
	public static void main(String [] args){
		try{
		//UsualMatrix b = new UsualMatrix(5, 3);
		//SparseMatrix a = new SparseMatrix(5, 5);
		//int f = 0;
		//for(int i = 0; i < a.getRow();i++){
		//	for(int j = 0; j < a.getColumn();j++){
		//		a.set(i, j, f);
		//		f++;
		//	}
		//}
		//f = 0;
		//for(int i = 0; i < b.getRow();i++){
		//	for(int j = 0; j < b.getColumn();j++){
		//		b.set(i, j, f);
		//		f++;
		//	}
		//}
		UsualMatrix a = new UsualMatrix(100,100);
		SparseMatrix g = new SparseMatrix(100, 100);
		UsualMatrix b = new UsualMatrix(100,100);
		SparseMatrix c = new SparseMatrix(100, 100);
		int f = 0;
		//int j = 0;
		int k = 0;
		for(int i = 0; i < a.getRow();i++){
			a.set(i, i, i);
			g.set(i, i, i);
			b.set(i, i, i);
			c.set(i, i, i);
		}
		
		
		a.eguals(g);
		//Imatrix r = a;
		//Imatrix t = c;
		//Imatrix u = g;
		//Imatrix j = b;
		a = (UsualMatrix)a.product(c);
		System.out.println("Flag10");
		g =(SparseMatrix) g.product(b);
		System.out.println("Flag11");
		//Imatrix w = b.product(g);
		//boolean lk = w.equals(e);
		//g = a.product(b);
		 //c = b.product(a);
		//System.out.println(a);
		//System.out.println(g);
		System.out.println(a.eguals(g));
		//System.out.println(lk);
		//System.out.println((b.product(c)).equals( a.product(g)));
		//System.out.println(b);
		//System.out.println(b.product(a));
		}catch(RuntimeException e){
			System.out.println(e.getMessage());
		}
	}
}