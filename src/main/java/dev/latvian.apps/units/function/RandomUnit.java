package dev.latvian.apps.units.function;

import dev.latvian.apps.units.UnitVariables;

import java.util.Random;

public class RandomUnit extends FuncUnit {
	public static final Random RANDOM = new Random();
	public static final FunctionFactory FACTORY = FunctionFactory.of0("random", RandomUnit::new);

	private RandomUnit() {
		super(FACTORY);
	}

	@Override
	public double get(UnitVariables variables) {
		return RANDOM.nextDouble();
	}
}