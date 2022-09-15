public class Main{
	public static void main(String [] args){
		try{
			int f = -2;
			byte c = 4;
			int a = f & 0b011111111111111111111111111111111;
			//System.out.println(a);
			IntRGB tr = new IntRGB(255, 255, 255);
			//System.out.println(tr.getR());
			//System.out.println(tr.getG());
			RGB d = new RGB(1, 1, 1);
			 tr  = (IntRGB) tr.sum(d);
			//System.out.println(tr.getB());
			System.out.println(tr.getR());
			System.out.println(tr.getG());
			System.out.println(tr.getB());
			RGB ti = new RGB(255, 128, 100);
			IntRGB i = new IntRGB(255, 100, 100);
			ti = (RGB)ti.sum(i);
			System.out.println(ti.getR());
			System.out.println(ti.getG());
			System.out.println(ti.getB());
		}catch(RuntimeException e){
			System.out.println(e.getMessage());
		}
	}
}