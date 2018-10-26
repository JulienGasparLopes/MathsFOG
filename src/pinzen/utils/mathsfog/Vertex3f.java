package pinzen.utils.mathsfog;

/**
 * Represents a Vector/Vertex with 3 float components (x, y and z)
 */
public class Vertex3f {

	public float x, y, z;
	
	/**
	 * Create a Vertex3f
	 * @param x : component in the X axis
	 * @param y : component in the Y axis
	 * @param y : component in the Z axis
	 */
	public Vertex3f(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * Create a Vertex3f with x, y and z equal to given value
	 * @param a : value of X, Y and Z components
	 */
	public Vertex3f(float a) {
		this(a,a,a);
	}
	
	/**
	 * Create Default Vertex3f(0,0,0)
	 */
	public Vertex3f() {
		this(0);
	}
	
	/**
	 * Output "Vertex3f(x,y,z)"
	 */
	public String toString() {
		return "[Vertex3f(" + x + "," + y + "," + z + ")]";
	}
	
	/**
	 * Get one element of the vector (x=1, y=2, z=3)
	 * Useful when iterating over a Vertex3f
	 * @param index : index of the element
	 * @return x, y or z (1, 2 or 3)
	 */
	public float get(int index) {
		if(index<1 || index>3)
			throw new ArrayIndexOutOfBoundsException("Can't reach Vertex3f[" + index + "]");
		
		return index == 1 ? x : index == 2 ? y : z;
	}
	
	/**
	 * Get norm (or magnitude) of the Vector
	 * @return norm's value
	 */
	public float norm() {
		return (float)Math.sqrt(x*x + y*y + z*z);
	}
	
			/** ----- ----- Static Functions ----- ----- **/
	
	/**
	 * Scale every components of a Vertex3f by value s
	 * @param v : Vertex3f to scale
	 * @param s : scale value
	 * @return new scaled Vertex3f
	 */
	public static Vertex3f Scale(Vertex3f v, float s) {
		return new Vertex3f(v.x*s, v.y*s, v.z*s);
	}
	
	/**
	 * Translate a Vertex3f using an other Vertex3f (add them)
	 * @param origin : origin of the translation
	 * @param trans : translation vector
	 * @return new translated Vertex3f
	 */
	public static Vertex3f Translate(Vertex3f origin, Vertex3f trans) {
		return new Vertex3f(origin.x+trans.x, origin.y+trans.y, origin.z+trans.z);
	}
	
	/**
	 * Normalize a Vertex3f
	 * @param v : Vertex3f to normalize
	 * @return new normalized Vertex3f
	 */
	public static Vertex3f Normalize(Vertex3f v) {
		return Scale(v, 1/v.norm());
	}
}
