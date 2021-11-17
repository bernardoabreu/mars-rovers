package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.Point;

class PointTest {

	@Test
	void testEquals() {
		Point p = new Point(2, 3);
		Point p2 = new Point(2, 3);

		Assertions.assertTrue(p.equals(p2));
	}

	@Test
	void testEqualsWhenNotInstance() {
		Point p = new Point(2, 3);
		Object obj = new Object();

		Assertions.assertFalse(p.equals(obj));
	}

	@Test
	void testEqualsWhenSame() {
		Point p = new Point(2, 3);

		Assertions.assertTrue(p.equals(p));
	}

	@Test
	void testSetLocation​() {
		Point p = new Point();
		int x = 2;
		int y = 3;
		p.setLocation​(x, y);

		Assertions.assertEquals(x, p.getX());
		Assertions.assertEquals(y, p.getY());
	}

	@Test
	void testSetLocation() {
		Point p = new Point();
		int x = 2;
		int y = 3;
		p.setLocation​(x, y);

		Point p2 = new Point();
		p2.setLocation(p);

		Assertions.assertEquals(x, p2.getX());
		Assertions.assertEquals(y, p2.getY());
	}
}
