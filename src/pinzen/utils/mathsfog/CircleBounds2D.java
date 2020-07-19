package pinzen.utils.mathsfog;

public class CircleBounds2D {

	private Vertex2f center;
	private float radius;
	
	public CircleBounds2D(Vertex2f pos, float rad) {
		this.center = pos.clone();
		this.radius = rad;
	}
	
	public boolean contains(Vertex2f point) {
		Vertex2f distance = Vertex2f.difference(center, point);
		return distance.getNorm() <= this.radius;	
	}
	
	public boolean collide(CircleBounds2D bounds) {
		Vertex2f distance = Vertex2f.difference(center, bounds.getCenter());
		return distance.getNorm() <= (this.radius + bounds.getRadius());	
	}
	
	public CircleBounds2D clone() {
		return new CircleBounds2D(this.getCenter(), radius);
	}
	
	public Vertex2f getCenter() {
		return this.center.clone();
	}
	
	public void setCenter(Vertex2f c) {
		this.center = c.clone();
	}
	
	public float getRadius() {
		return radius;
	}
}
