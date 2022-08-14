package dev.latvian.apps.units.function;

import dev.latvian.apps.units.FixedNumberUnit;
import dev.latvian.apps.units.Unit;
import dev.latvian.apps.units.UnitVariables;

import java.util.Random;

public class RandomUnit extends FuncUnit {
	public static final Random RANDOM = new Random();
	public static final FunctionFactory FACTORY = FunctionFactory.of("random", 0, 2, RandomUnit::ofArgs);

	private static Unit ofArgs(Unit[] units) {
		if (units.length == 1) {
			return new RandomUnit(FixedNumberUnit.ZERO, units[0]);
		} else if (units.length == 2) {
			return new RandomUnit(units[0], units[1]);
		}

		return new RandomUnit(FixedNumberUnit.ZERO, FixedNumberUnit.ONE);
	}

	private final Unit min;
	private final Unit max;

	private RandomUnit(Unit min, Unit max) {
		super(FACTORY);
		this.min = min;
		this.max = max;
	}

	@Override
	public double get(UnitVariables variables) {
		if (min == FixedNumberUnit.ZERO && max == FixedNumberUnit.ONE) {
			return RANDOM.nextDouble();
		}

		double m = min.get(variables);
		return m + RANDOM.nextDouble() * (max.getFloat(variables) - m);
	}
}