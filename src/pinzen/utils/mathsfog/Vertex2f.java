package pinzen.utils.mathsfog;

/**
 * Represents a Vector/Vertex with 2 float components (x and y)
 */
public class Vertex2f {

	public float x, y;
	
	/**
	 * Create a Vertex2f
	 * @param x : component in the X axis
	 * @param y : component in the Y axis
	 */
	public Vertex2f(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Create a Vertex2f with x and y both equal to given value
	 * @param a : value of X and Y components
	 */
	public Vertex2f(float a) {
		this(a,a);
	}
	
	/**
	 * Create Default Vertex2f(0,0)
	 */
	public Vertex2f() {
		this(0);
	}
	
	/**
	 * Create a Vertex2f using a norm value and an angle 
	 * @param norm : norm of the Vertes2f to create
	 * @param ang : angle beetween this Vertex2f and X axis
	 * @param inDegrees : true if angle in degrees, false if angle in radians
	 */
	public Vertex2f(float norm, float ang, boolean inDegrees) {
		float angle = inDegrees ? (float)(ang*2f*Math.PI/180f) : ang;
		
		this.x = (float)(norm*Math.cos(angle));
		this.y = (float)(norm*Math.sin(angle));
	}
		
	/**
	 * Clone this Vertex2f (return a new Vertex2f with the same components)
	 */
	public Vertex2f clone() {
		return new Vertex2f(x,y);
	}
	
	/**
	 * Output "Vertex2f(x,y)"
	 */
	public String toString() {
		return "Vertex2f(" + x + "," + y + ")";
	}
	
	/**
	 * Get one element of the vector<br>
	 * Useful when iterating over a Vertex2f <br>
	 * NB : follows maths convention (x=1, y=2) 
	 * @param index : index of the element
	 * @return value of x or y element
	 */
	public float get(int index) {
		if(index<1 || index>2)
			throw new ArrayIndexOutOfBoundsException("Can't reach Vertex2f[" + index + "]");
		
		return index == 1 ? x : y;
	}
	
	/**
	 * Set one element of the vector<br>
	 * Useful when iterating over a Vertex2f <br>
	 * NB : follows maths convention (x=1, y=2) 
	 * @param index : index of the element
	 * @param value : new value of x or y element
	 */
	public void set(int index, float value) {
		if(index<1 || index>2)
			throw new ArrayIndexOutOfBoundsException("Can't reach Vertex2f[" + index + "]");
		
		if(index == 1)
			this.x = value;
		else if(index == 2)
			this.y = value;
	}
	
	/**
	 * Get norm (or magnitude) of the Vector
	 * @return norm's value
	 */
	public float getNorm() {
		return (float)Math.sqrt(x*x + y*y);
	}
	
	/**
	 * Get angle between this Vertex2f and unit vector of X axis
	 * @return angle in degrees
	 */
	public float getAngle() {
		return (float)(Math.tan(y/x)*180/(2*Math.PI));
	}
	
	/**
	 * Get angle between this Vertex2f and unit vector of X axis
	 * @return angle in rads
	 */
	public float getAngleRads() {
		return (float)(Math.tan(y/x));
	}
	
			/** ----- ----- Static Functions ----- ----- **/
	
	/**
	 * Scale every components of a Vertex2f by value s
	 * @param v : Vertex2f to scale
	 * @param s : scale value
	 * @return new scaled Vertex2f
	 */
	public static Vertex2f scale(Vertex2f v, float s) {
		return new Vertex2f(v.x*s, v.y*s);
	}
	
	/**
	 * Translate a Vertex2f using an other Vertex2f (add them)
	 * @param origin : origin of the translation
	 * @param trans : translation vector
	 * @return new translated Vertex2f
	 */
	public static Vertex2f translate(Vertex2f origin, Vertex2f trans) {
		return new Vertex2f(origin.x+trans.x, origin.y+trans.y);
	}
	
	/**
	 * Normalize a Vertex2f
	 * @param v : Vertex2f to normalize
	 * @return new normalized Vertex2f
	 */
	public static Vertex2f normalize(Vertex2f v) {
		return scale(v, 1/v.getNorm());
	}
	
	/**
	 * Rotate a Vertex2f (add angle value to its actual angle)
	 * @param v : Vertex2f to rotate
	 * @param angle : angle in degrees
	 * @return new rotated Vertex2f
	 */
	public static Vertex2f rotate(Vertex2f v, float angle) {		
		return new Vertex2f(v.getNorm(), v.getAngle() + angle, true);
	}
	
	/**
	 * Rotate a Vertex2f (add angle value to its actual angle)
	 * @param v : Vertex2f to rotate
	 * @param angle : angle in radians
	 * @return new rotated Vertex2f
	 */
	public static Vertex2f rotateRads(Vertex2f v, float angleRads) {
		return new Vertex2f(v.getNorm(), v.getAngleRads() + angleRads, false);
	}
	
	/**
	 * Difference between 2 Vertex2f
	 * @param v1 : Vertex2f
	 * @param v2 : Vertex2f
	 * @return new Vertex2f representing v2 - v1
	 */
	public static Vertex2f difference(Vertex2f v1, Vertex2f v2) {
		return new Vertex2f(v2.x - v1.x, v2.y - v1.y);
	}
	
	/**
	 * Invert a Vertex2f (negate its components)
	 * @param v : Vertex2f to invert
	 * @return a new Vertex2f(-x, -y)
	 */
	public static Vertex2f invert(Vertex2f v) {
		return new Vertex2f(-v.x, -v.y);
	}
}
