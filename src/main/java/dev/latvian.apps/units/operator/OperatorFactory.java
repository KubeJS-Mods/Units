package dev.latvian.apps.units.operator;

import dev.latvian.apps.units.Unit;

@FunctionalInterface
public interface OperatorFactory {
	Unit create(Unit left, Unit right);
}
