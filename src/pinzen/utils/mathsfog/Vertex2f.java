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
		if(index<1 || index>3)
			throw new ArrayIndexOutOfBoundsException("Can't reach Vertex2f[" + index + "]");
		
		return index == 1 ? x : y;
	}
	
	/**
	 * Get norm (or magnitude) of the Vector
	 * @return norm's value
	 */
	public float norm() {
		return (float)Math.sqrt(x*x + y*y);
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
		return scale(v, 1/v.norm());
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
}
