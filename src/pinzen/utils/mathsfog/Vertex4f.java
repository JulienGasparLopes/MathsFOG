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
	public static Vertex4f Scale(Vertex4f v, float s) {
		return new Vertex4f(v.x*s, v.y*s, v.z*s, v.w*s);
	}
	
	/**
	 * Translate a Vertex4f using an other Vertex4f (add them)
	 * @param origin : origin of the translation
	 * @param trans : translation vector
	 * @return new translated Vertex4f
	 */
	public static Vertex4f Translate(Vertex4f origin, Vertex4f trans) {
		return new Vertex4f(origin.x+trans.x, origin.y+trans.y, origin.z+trans.z, origin.w+trans.w);
	}
	
	/**
	 * Normalize a Vertex4f
	 * @param v : Vertex4f to normalize
	 * @return new normalized Vertex4f
	 */
	public static Vertex4f Normalize(Vertex4f v) {
		return Scale(v, 1/v.norm());
	}
}
