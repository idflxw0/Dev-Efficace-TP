package TP.TP5.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import  TP.TP5.tree.LinkedBSTreeEquiped;

class TestInbalance {
	@Test
	void test() {
		final int NB_TESTS = 500_000;
		final int SIZE = 100;
		for (int i = 0; i < NB_TESTS; ++i) {
			List<Integer> values = IntStream.rangeClosed(1, SIZE).boxed().collect(Collectors.toList());
			Collections.shuffle(values);
			LinkedBSTreeEquiped<Integer> t = new LinkedBSTreeEquiped<>();
			for (int v : values) {
				t.add(v);
				assertEquals(t.inbalance(), t.getInbalance());
			}
			assertTrue(t.deepCheckInbalance());
		}
	}
}
