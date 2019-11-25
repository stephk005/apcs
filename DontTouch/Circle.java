public class Circle
{
	private double x, y;
	private double radius;

    public Circle(double x, double y, double radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

	public double getArea ( )
	{
		return Math.pow(radius, 2) * Math.PI;
	}

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public double getRadius(){
        return radius;
    }
}
