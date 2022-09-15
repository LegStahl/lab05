public class RGB implements IColor{
	private int R;

	private int G;

	private int B;

	public int getR(){
		return R;
	}

	public int getG(){
		return G;
	}

	public int getB(){
		return B;
	}
	
	public RGB(int r, int g, int b){
		R = r;
		G = g;
		B = b;
	}

	public void setR(int a){
		R = a;
	}

	public void setG(int a){
		G = a;
	}

	public void setB(int a){
		B = a;
	}

	public IColor sum(IColor a){
		
		int r = (this.getR() + a.getR()) % 256;
		int g = (this.getG() + a.getG()) % 256;
		int b = (this.getB() + a.getB()) % 256;
		IColor time = new RGB(r, g, b);
		return time;
	
	}


}