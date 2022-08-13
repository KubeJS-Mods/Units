package dev.latvian.apps.units.operator;

import dev.latvian.apps.units.Unit;

@FunctionalInterface
public interface UnaryOperatorFactory {
	Unit create(Unit unit);
}
