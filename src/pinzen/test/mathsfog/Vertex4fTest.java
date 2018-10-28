package pinzen.test.mathsfog;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import pinzen.utils.mathsfog.Vertex4f;

class Vertex4fTest {

	/**
	 * Test a Vertex4f's components are equals to x, y, z and w
	 * @param v : Vertex4f to test
	 * @param x : component on axe X
	 * @param y : component on axe Y
	 * @param z : component on axe Z
	 * @param w : component on axe W
	 */
	private void assertVertex4fEquals(Vertex4f v, float x, float y, float z, float w) {
		assertEquals(v.x, x);
		assertEquals(v.y, y);
		assertEquals(v.z, z);
		assertEquals(v.w, w);
	}
	
	
	@Test
	void testVertex4fCreation() {
		Vertex4f v1 = new Vertex4f(1,2,3,4);
		Vertex4f v2 = new Vertex4f(42);
		Vertex4f v3 = new Vertex4f();
		
		assertVertex4fEquals(v1, 1, 2, 3, 4);
		assertVertex4fEquals(v2, 42, 42, 42, 42);
		assertVertex4fEquals(v3, 0, 0, 0, 0);
	}

	@Test
	void testNorm() {
		Vertex4f v1 = new Vertex4f(1,2,3,4);
		
		assertEquals(v1.norm(), (float)Math.sqrt(30));
	}

	@Test
	void testTranslation() {
		Vertex4f v1 = new Vertex4f(1,2,3,4);
		Vertex4f v2 = new Vertex4f(2,3,4,5);
		
		Vertex4f v3 = Vertex4f.translate(v1, v2);
		
		assertVertex4fEquals(v3, 3, 5, 7, 9);
	}
	
	@Test
	void testNormalization() {
		Vertex4f v1 = Vertex4f.normalize(new Vertex4f(4, 6, 56, -3));
		
		assertEquals(v1.norm(), 1);
	}

}
