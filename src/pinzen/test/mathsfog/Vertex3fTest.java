package pinzen.test.mathsfog;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import pinzen.utils.mathsfog.Vertex3f;

class Vertex3fTest {

	/**
	 * Test a Vertex3f's components are equals to x, y and z
	 * @param v : Vertex3f to test
	 * @param x : component on axe X
	 * @param y : component on axe Y
	 * @param z : component on axe Z
	 */
	private void assertVertex3fEquals(Vertex3f v, float x, float y, float z) {
		assertEquals(v.x, x);
		assertEquals(v.y, y);
		assertEquals(v.z, z);
	}
	
	
	
	@Test
	void testVertex3fCreation() {
		Vertex3f v1 = new Vertex3f(1,2,3);
		Vertex3f v2 = new Vertex3f(42);
		Vertex3f v3 = new Vertex3f();
		
		assertVertex3fEquals(v1, 1, 2, 3);
		assertVertex3fEquals(v2, 42, 42, 42);
		assertVertex3fEquals(v3, 0, 0, 0);
	}

	@Test
	void testNorme() {
		Vertex3f v1 = new Vertex3f(1,2,3);
		
		assertEquals(v1.norm(), (float)Math.sqrt(14));
	}

	@Test
	void testTranslation() {
		Vertex3f v1 = new Vertex3f(1,2,3);
		Vertex3f v2 = new Vertex3f(2,3,4);
		
		Vertex3f v3 = Vertex3f.Translate(v1, v2);
		
		assertVertex3fEquals(v3, 3, 5, 7);
	}
	
	@Test
	void testNormalization() {
		Vertex3f v1 = Vertex3f.Normalize(new Vertex3f(4, 6, 56));
		
		assertEquals(v1.norm(), 1);
	}

}
