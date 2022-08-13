package dev.latvian.apps.units.operator;

import dev.latvian.apps.units.Unit;
import dev.latvian.apps.units.UnitVariables;
import dev.latvian.apps.units.VariableUnit;
import dev.latvian.apps.units.token.UnitSymbol;

public class SetUnit extends OpUnit {
	public SetUnit(UnitSymbol symbol, Unit left, Unit right) {
		super(symbol, left, right);
	}

	@Override
	public double get(UnitVariables variables) {
		if (left instanceof VariableUnit var) {
			variables.getVariables().set(var.name, right.get(variables));
		}

		return right.get(variables);
	}

	@Override
	public int getInt(UnitVariables variables) {
		if (left instanceof VariableUnit var) {
			variables.getVariables().set(var.name, right.get(variables));
		}

		return right.getInt(variables);
	}

	@Override
	public boolean getBoolean(UnitVariables variables) {
		if (left instanceof VariableUnit var) {
			variables.getVariables().set(var.name, right.get(variables));
		}

		return right.getBoolean(variables);
	}
}
