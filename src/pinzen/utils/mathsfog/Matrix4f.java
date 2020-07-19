package pinzen.utils.mathsfog;

/**
 * Represents a Matrix 4x4 of float
 * 
 * Conventions : columns vectors and mathematical notation (1 for first element)
 * Storage : column major
 * 
 * m11 m12 m13 m14
 * m21 m22 m23 m24
 * m31 m32 m33 m34
 * m41 m42 m43 m44
 * 
 * stored as float array [m11 m21 m31 m41 m12 m22 m32 ... m34 m44]
 */
public class Matrix4f {

	private float[] mat;
	
	/**
	 * Identity Matrix4f
	 */
	public Matrix4f() {
		mat = new float[16];
		
		for(int i = 0; i<16; i++) {
			if(i%5 == 0)
				mat[i] = 1;
			else
				mat[i] = 0;
		}
	}
	
	/**
	 * Output :
	 * "Matrix4f :
	 * [m11,m12,m12,m14,
	 *  m21,m22,m23,m24,
	 *  m31,m32,m33,m34,
	 *  m41,m42,m43,m44]
	 */
	public String toString() {
		String ret = "Matrix4f :\n[";
		for(int line = 1; line<=4; line++) {
			for(int col = 1; col<=4; col++) {
				ret += get(line,col);
				
				if(line != 4 || col != 4)
					ret += ",";
				
				if(col == 4 && line !=4)
					ret += "\n ";
			}
		}
		return ret + "]";
	}
	
	/**
	 * Get element at given coordinates<br>
	 * IMPORTANT : Coordinates follow mathematics convention (1 for first line, not 0)
	 * @param line : line number of the element
	 * @param col  : column number of the element
	 * @return float value of element M[line][column]
	 */
	public float get(int line, int col) {
		int index = (col-1)*4 + (line-1);
		
		if(index < 0 || index > 15)
			throw new ArrayIndexOutOfBoundsException("Can't reach Matrix4f[" + line + "][" + col + "]");
		
		return mat[index];
	}
	
	/**
	 * Get line at a given index<br>
	 * IMPORTANT : Coordinates follow mathematics convention (1 for first line, not 0)
	 * @param index : line index
	 * @return a Vertex4f with value of the line at given index
	 */
	public Vertex4f getLine(int index) {
		if(index<1 || index>4)
			throw new ArrayIndexOutOfBoundsException("Can't reach line " + index + " of a Mat4f");
	
		int i = index-1;
		return new Vertex4f(mat[0+i], mat[4+i], mat[8+i], mat[12+i]);
	}
	
	/**
	 * Get column at a given index<br>
	 * IMPORTANT : Coordinates follow mathematics convention (1 for first line, not 0)
	 * @param index : column index
	 * @return a Vertex4f with value of the column at given index
	 */
	public Vertex4f getColumn(int index) {
		if(index<1 || index>4)
			throw new ArrayIndexOutOfBoundsException("Can't reach column " + index + " of a Mat4f");
	
		int i = (index - 1)*4;
		return new Vertex4f(mat[0+i], mat[1+i], mat[2+i], mat[3+i]);
	}
	
	/**
	 * Get a copy of the array containing matrix elements
	 * @return new float[16]{m11 m21 m31 m41 m12 m22 m32 ... m34 m44}
	 */
	public float[] toArray() {
		float[] array = new float[16];
		
		for(int i = 0; i<16; i++) {
			array[i] = mat[i];
		}
		
		return array;
	}
	
	/**
	 * set element at given coordinates<br>
	 * Coordinates follow mathematical convention (1 for first line, not 0)
	 * @param line : line number of the element
	 * @param col  : column number of the element
	 * @param val  : value of the element
	 */
	public void set(int line, int col, float val) {
		int index = (col-1)*4 + (line-1);
		
		if(index < 0 || index > 15)
			throw new ArrayIndexOutOfBoundsException("Can't reach Matrix4f[" + line + "][" + col + "]");
		
		mat[index] = val;
	}
	
	
			/** ----- ----- Static Functions ----- ----- **/
	
	/**
	 * Create a translation Matrix4f using a translation Vertex3f (stored in m14,m24,m34)
	 * @param transVector : the translation vector
	 * @return new translation Matrix4f
	 */
	public static Matrix4f getTranslationMatrix(Vertex3f transVector) {
		Matrix4f m = new Matrix4f();
		m.set(1, 4, transVector.x);
		m.set(2, 4, transVector.y);
		m.set(3, 4, transVector.z);
		
		return m;
	}
	
	/**
	 * Create a translation Matrix4f using a translation Vertex2f for 2D<br>
	 * (stored in m14,m24,m34)
	 * @param transVector : the translation vector
	 * @return new translation Matrix4f
	 */
	public static Matrix4f getTranslationMatrix(Vertex2f transVector) {
		return Matrix4f.getTranslationMatrix(new Vertex3f(transVector));
	}
	
	/**
	 * Create a scaling Matrix4f using a scaling Vertex3f (stored in m11,m22,m33)
	 * @param scaleVector : the scaling vector
	 * @return new scaling Matrix4f
	 */
	public static Matrix4f getScalingMatrix(Vertex3f scaleVector) {
		Matrix4f m = new Matrix4f();
		m.set(1, 1, scaleVector.x);
		m.set(2, 2, scaleVector.y);
		m.set(3, 3, scaleVector.z);
		
		return m;
	}
	
	/**
	 * Create a scaling Matrix4f using a scaling Vertex2f for 2D<br>
	 * (stored in m11,m22,m33)
	 * @param scaleVector : the scaling vector
	 * @return new scaling Matrix4f
	 */
	public static Matrix4f getScalingMatrix(Vertex2f scaleVector) {
		return Matrix4f.getScalingMatrix(new Vertex3f(scaleVector));
	}
	
	/**
	 * Create a scaling Matrix4f using a Vertex3f(s,s,s)
	 * @param s : scaling factor
	 * @return new scaling Matrix4f
	 */
	public static Matrix4f getScalingMatrix(float s) {
		return getScalingMatrix(new Vertex3f(s));
	}
	
	/**
	 * Get the rotation matrix around a given axe with an angle in degrees
	 * @param axe : axe of the rotation (SHOULD BE A UNIT VERTEX)
	 * @param angle : angle of rotation in degrees
	 * @return a rotation Matrix4f
	 */
	public static Matrix4f getRotationMatrix(Vertex3f axe, float angle) {
		return Matrix4f.getRotationRadMatrix(axe, (float)(angle*Math.PI/180));
	}
	
	/**
	 * Get the rotation matrix around a given axe with an angle in rads
	 * @param axe : axe of the rotation (SHOULD BE A UNIT VERTEX)
	 * @param angle : angle of rotation in rads
	 * @return a rotation Matrix4f
	 */
	public static Matrix4f getRotationRadMatrix(Vertex3f axe, float angle) {
		Matrix4f m = new Matrix4f();
		
		float x = axe.x;
		float y = axe.y;
		float z = axe.z;
		float c = (float)Math.cos(angle);
		float s = (float)Math.sin(angle);
		
		m.set(1, 1, c + x*x*(1-c));
		m.set(1, 2, x*y*(1-c) - z*s);
		m.set(1, 3, x*z*(1-c) + y*s);
		
		m.set(2, 1, y*x*(1-c) + z*s);
		m.set(2, 2, c + y*y*(1-c));
		m.set(2, 3, y*z*(1-c) - x*s);

		m.set(3, 1, z*x*(1-c) - y*s);
		m.set(3, 2, z*y*(1-c) + x*s);
		m.set(3, 3, c + z*z*(1-c));
				
		return m;
	}
	
	/**
	 * Get an orthographic projection (for 2D representation)
	 * @param left : left limit of the ortho
	 * @param bottom : bottom limit of the ortho
	 * @param right : right limit of the ortho
	 * @param top : top limit of the ortho
	 * @param near : near limit of the ortho
	 * @param far : far limit of the ortho
	 * @return a Matrix4f representing the orthographic projection
	 */
	public static Matrix4f getOrtho(float left, float bottom, float right, float top, float near, float far) {
		Matrix4f m = new Matrix4f();
		
		m.set(1, 1, 2f/(right-left));
		m.set(2, 2, 2f/(top-bottom));
		m.set(3, 3, -2f/(far-near));
		
		m.set(1, 4, -(right+left)/(right-left));
		m.set(2, 4, -(top+bottom)/(top-bottom));
		m.set(3, 4, -(far+near)/(far-near));
		
		return m;
	}
	
	public static Matrix4f getPerspective(float fov, float aspect, float zNear, float zFar) {
		Matrix4f m = new Matrix4f();
		
		float tanFov = (float)Math.tan(fov / 2f * Math.PI / 180f);
		
		m.set(1, 1, 1f / (aspect * tanFov));
		m.set(2, 2, 1f / (tanFov));
		m.set(3, 3, (-zNear - zFar) / (zNear - zFar));
		m.set(4, 4, 0f);
		
		m.set(3, 4, (2f * zFar * zNear) / (zNear - zFar));
		
		m.set(4, 3, 1f);
		
		return m;
	}
	
	/**
	 * Multiply two Matrix4f
	 * @param left : left Matrix4f to multiply
	 * @param right : right Matrix4f to multiply
	 * @return new Matrix4f result of the multiplication
	 */
	public static Matrix4f mult(Matrix4f left, Matrix4f right) {
		Matrix4f r = new Matrix4f();
		
		for(int line = 1; line<=4; line++) {
			for(int col = 1; col<=4; col++) {
				float val = 0;
				Vertex4f vLeft = left.getLine(line);
				Vertex4f vRight = right.getColumn(col);
				for(int i = 1; i<=4; i++) {
					val += vLeft.get(i) * vRight.get(i);
				}
				r.set(line,  col, val);
			}
		}
		
		return r;
	}
	
	/**
	 * Translate a Matrix4f using a translation Vertex3f
	 * @param origin : the Matrix4f to translate
	 * @param trans : translation Vertex3f
	 * @return new translated Matrix4f
	 */
	public static Matrix4f translate(Matrix4f origin, Vertex3f trans) {
		Matrix4f transMat = getTranslationMatrix(trans);
		return mult(transMat, origin);
	}
	
	/**
	 * Translate a Matrix4f using a translation Vertex2f for 2D
	 * @param origin : the Matrix4f to translate
	 * @param trans : translation Vertex2f
	 * @return new translated Matrix4f
	 */
	public static Matrix4f translate(Matrix4f origin, Vertex2f trans) {
		return Matrix4f.translate(origin, new Vertex3f(trans));
	}
	
	/**
	 * Rotate a Matrix4f using a rotation Vertex3f and an angle in degrees
	 * @param origin : the Matrix4f to rotate
	 * @param rot : rotation Vertex3f
	 * @param angle : angle of rotation in degrees
	 * @return new rotated Matrix4f
	 */
	public static Matrix4f rotate(Matrix4f origin, Vertex3f rot, float angle) {
		Matrix4f rotMat = getRotationMatrix(rot, angle);
		return mult(rotMat, origin);
	}
	
	/**
	 * Scale a Matrix4f using a scaling Vertex3f
	 * @param origin : the Matrix4f to scale
	 * @param scales : scaling Vertex3f
	 * @return new scaled Matrix4f
	 */
	public static Matrix4f scale(Matrix4f origin, Vertex3f scales) {
		Matrix4f scaleMat = getScalingMatrix(scales);
		return mult(scaleMat, origin);
	}
	
	/**
	 * Scale a Matrix4f using a scaling Vertex2f for 2D
	 * @param origin : the Matrix4f to scale
	 * @param scales : scaling Vertex2f
	 * @return new scaled Matrix4f
	 */
	public static Matrix4f scale(Matrix4f origin, Vertex2f scales) {
		return Matrix4f.scale(origin, new Vertex3f(scales));
	}
	
	/**
	 * Scale a Matrix4f using a scaling factor
	 * @param origin : the Matrix4f to scale
	 * @param scale : scaling factor
	 * @return new scaled Matrix4f
	 */
	public static Matrix4f scale(Matrix4f origin, float scale) {
		Matrix4f scaleMat = getScalingMatrix(scale);
		return mult(scaleMat, origin);
	}
}
