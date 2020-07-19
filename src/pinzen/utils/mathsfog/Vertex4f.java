package pinzen.utils.mathsfog;

/**
 * Represents a Vector/Vertex with 4 float components (x, y, z and w)
 */
public class Vertex4f {

	public float x, y, z, w;
	
	/**
	 * Create a Vertex4f
	 * @param x : component in the X axis
	 * @param y : component in the Y axis
	 * @param y : component in the Z axis
	 * @param y : component in the W axis (welcome to 4th dimension !)
	 */
	public Vertex4f(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	
	/**
	 * Create a Vertex4f with x, y, z and w equal to given value
	 * @param a : value of X, Y, Z and W components
	 */
	public Vertex4f(float a) {
		this(a,a,a,a);
	}
	
	/**
	 * Create Default Vertex4f(0,0,0,0)
	 */
	public Vertex4f() {
		this(0);
	}
	
	/**
	 * Create a Vertex4f using a Vertex3f<br>
	 * (copy x, y and z components, set w to 0)
	 * @param v : Vertex3f to use
	 */
	public Vertex4f(Vertex3f v) {
		this(v.x, v.y, v.z, 0);
	}
	
	/**
	 * Create a Vertex4f using a Vertex2f<br>
	 * (copy x, and y components, set z and w to 0)
	 * @param v : Vertex3f to use
	 */
	public Vertex4f(Vertex2f v) {
		this(v.x, v.y, 0, 0);
	}
	
	/**
	 * Clone this Vertex4f (return a new Vertex4f with the same components)
	 */
	public Vertex4f clone() {
		return new Vertex4f(x,y,z,w);
	}
	
	/**
	 * Output "Vertex4f(x,y,z,w)"
	 */
	public String toString() {
		return "[Vertex4f(" + x + "," + y + "," + z + "," + w + ")]";
	}
	
	/**
	 * Get one element of the vector (x=1, y=2, z=3, w=4)
	 * Useful when iterating over a Vertex4f
	 * @param index : index of the element
	 * @return x, y, z or w (1, 2, 3 or 4)
	 */
	public float get(int index) {
		if(index<1 || index>4)
			throw new ArrayIndexOutOfBoundsException("Can't reach Vertex4f[" + index + "]");
		
		return index == 1 ? x : index == 2 ? y : index == 3 ? z : w;
	}
	
	/**
	 * Set one element of the vector<br>
	 * Useful when iterating over a Vertex4f <br>
	 * NB : follows maths convention (x=1, y=2, z=3, w=4) 
	 * @param index : index of the element
	 * @param value : new value of x or y element
	 */
	public void set(int index, float value) {
		if(index<1 || index>4)
			throw new ArrayIndexOutOfBoundsException("Can't reach Vertex2f[" + index + "]");
		
		if(index == 1)
			this.x = value;
		else if(index == 2)
			this.y = value;
		else if(index == 3)
			this.z = value;
		else if(index == 4)
			this.w = value;
	}
	
	public float norm() {
		return (float)Math.sqrt(x*x + y*y + z*z + w*w);
	}
	
			/** ----- ----- Static Functions ----- ----- **/
	
	/**
	 * Scale every components of a Vertex4f by value s
	 * @param v : Vertex4f to scale
	 * @param s : scale value
	 * @return new scaled Vertex4f
	 */
	public static Vertex4f scale(Vertex4f v, float s) {
		return new Vertex4f(v.x*s, v.y*s, v.z*s, v.w*s);
	}
	
	/**
	 * Translate a Vertex4f using an other Vertex4f (add them)
	 * @param origin : origin of the translation
	 * @param trans : translation vector
	 * @return new translated Vertex4f
	 */
	public static Vertex4f translate(Vertex4f origin, Vertex4f trans) {
		return new Vertex4f(origin.x+trans.x, origin.y+trans.y, origin.z+trans.z, origin.w+trans.w);
	}
	
	/**
	 * Normalize a Vertex4f
	 * @param v : Vertex4f to normalize
	 * @return new normalized Vertex4f
	 */
	public static Vertex4f normalize(Vertex4f v) {
		return scale(v, 1/v.norm());
	}
	
	/**
	 * Difference between 2 Vertex4f
	 * @param v1 : Vertex4f
	 * @param v2 : Vertex4f
	 * @return new Vertex4f representing v2 - v1
	 */
	public static Vertex4f difference(Vertex4f v1, Vertex4f v2) {
		return new Vertex4f(v2.x - v1.x, v2.y - v1.y, v2.z - v1.z, v2.w - v1.w);
	}
	
	/**
	 * Invert a Vertex4f (negate its components)
	 * @param v : Vertex4f to invert
	 * @return a new Vertex4f(-x, -y, -z, -w)
	 */
	public static Vertex4f invert(Vertex4f v) {
		return new Vertex4f(-v.x, -v.y, -v.z, -v.w);
	}
}
