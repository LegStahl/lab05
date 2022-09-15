public class IntRGB implements IColor{
	
	private int RGB;

	public IntRGB(int r, int g, int b){
		if(r > 255 || r < 0 || g > 255 || g < 0 || b > 255 || b < 0)
			throw new RuntimeException("Error INT");
		RGB = RGB | r;
		g = g << 8;
		RGB = RGB | g;
		b = b << 16;
		RGB = RGB | b;
	}
	
	public int getR(){
		byte time = (byte)RGB;
		int a = time;
		
		if(a < 0)
			a = a + 256;
		
		return a;
	}

	public int getG(){
		int time = RGB;
		time = time >> 8;
		byte time2 = (byte)time;
		//System.out.println(time2);
		int re = 0;
		re =(int) time2;
		//System.out.println(re);
		if (re < 0) 
			re = re + 256;
		
		
		return re;
	}

	public int getB(){
		int time = RGB;
		time = time >> 16;
		byte time2 = (byte)time;
		time = (int)time2;
		if( time < 0)
			time = time + 256;
		
		return time;
	}

	public void setR(int a){
		byte time = (byte)a;
		RGB = RGB | a;
	}

	public void setG(int a){
		a = a << 8;
		RGB = RGB | a;
	}

	public void setB(int a){
		a = a << 16;
		RGB = RGB | a;
	}

	public IColor sum(IColor a){
		int r = (this.getR() + a.getR()) % 256;
		//System.out.println(r);
		int g = (this.getG() + a.getG()) % 256;
		int b = (this.getB() + a.getB()) % 256;
		IColor time = new IntRGB(r, g, b);
		return time;
	}
}