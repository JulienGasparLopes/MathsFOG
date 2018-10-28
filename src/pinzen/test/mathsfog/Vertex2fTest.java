package pinzen.test.mathsfog;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import pinzen.utils.mathsfog.Vertex2f;

class Vertex2fTest {

	/**
	 * Test a Vertex2f's components are equals to x and y
	 * @param v : Vertex2f to test
	 * @param x : component on axe X
	 * @param y : component on axe Y
	 */
	private void assertVertex2fEquals(Vertex2f v, float x, float y) {
		assertEquals(v.x, x);
		assertEquals(v.y, y);
	}
	
	
	@Test
	void testVertex2fCreation() {
		Vertex2f v1 = new Vertex2f(1,2);
		Vertex2f v2 = new Vertex2f(42);
		Vertex2f v3 = new Vertex2f();
		
		assertVertex2fEquals(v1, 1, 2);
		assertVertex2fEquals(v2, 42, 42);
		assertVertex2fEquals(v3, 0, 0);
	}

	@Test
	void testNorm() {
		Vertex2f v1 = new Vertex2f(1,2);
		
		assertEquals(v1.norm(), (float)Math.sqrt(5));
	}

	@Test
	void testTranslation() {
		Vertex2f v1 = new Vertex2f(1,2);
		Vertex2f v2 = new Vertex2f(2,3);
		
		Vertex2f v3 = Vertex2f.translate(v1, v2);
		
		assertVertex2fEquals(v3, 3, 5);
	}
	
	@Test
	void testNormalization() {
		Vertex2f v1 = Vertex2f.normalize(new Vertex2f(4, 6));
		
		assertEquals(v1.norm(), 1);
	}
}
