package pinzen.utils.mathsfog;

public class RectBounds2f {

	public Vertex2f position, dimension;
	
	public RectBounds2f(Vertex2f position, Vertex2f dimension) {
		this.position = position.clone();
		this.dimension = dimension.clone();
	}
	
	public RectBounds2f(float x, float y, float w, float h) {
		this(new Vertex2f(x, y), new Vertex2f(w, h));
	}
	
	public RectBounds2f clone() {
		return new RectBounds2f(position.clone(), dimension.clone());
	}
	
	
	public boolean contains(Vertex2f p) {
		if(p.x >= position.x && p.x <= (position.x + dimension.x))
			if(p.y >= position.y && p.y <= (position.y + dimension.y))
				return true;
				
		return false;
	}
	
	private Vertex2f[] getPoints() {
		return new Vertex2f[]{
			new Vertex2f(position.x              , position.y              ),
			new Vertex2f(position.x              , position.y + dimension.y),
			new Vertex2f(position.x + dimension.x, position.y + dimension.y),
			new Vertex2f(position.x + dimension.x, position.y              )
		};
	}
	
	public boolean collide(RectBounds2f b) {
		//One point of b is on this RectBounds2f
		for(Vertex2f p : b.getPoints()) {
			if(this.contains(p))
				return true;
		}
		
		//One point of this RectBounds2f is on b
		for(Vertex2f p : this.getPoints()) {
			if(b.contains(p))
				return true;
		}
		
		//This RectBounds2f and b intersects but no points are in each surface
		//TODO as it is borring
		
		//No collision detected
		return false;
	}
}
