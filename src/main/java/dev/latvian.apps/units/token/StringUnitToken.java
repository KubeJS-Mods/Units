package dev.latvian.apps.units.token;

import dev.latvian.apps.units.FixedNumberUnit;
import dev.latvian.apps.units.Unit;
import dev.latvian.apps.units.VariableUnit;

public record StringUnitToken(String name) implements UnitToken {
	@Override
	public Unit interpret(UnitTokenStream stream) {
		var constant = stream.context.constants.get(name);

		if (constant != null) {
			return constant;
		}

		try {
			return FixedNumberUnit.of(Double.parseDouble(name));
		} catch (Exception ex) {
			return VariableUnit.of(name);
		}
	}

	@Override
	public String toString() {
		return name;
	}
}
