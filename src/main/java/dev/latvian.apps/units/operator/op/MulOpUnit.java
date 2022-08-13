package dev.latvian.apps.units.operator.op;

import dev.latvian.apps.units.Unit;
import dev.latvian.apps.units.UnitVariables;
import dev.latvian.apps.units.operator.OpUnit;
import dev.latvian.apps.units.token.UnitSymbol;

public class MulOpUnit extends OpUnit {
	public MulOpUnit(Unit left, Unit right) {
		super(UnitSymbol.MUL, left, right);
	}

	@Override
	public double get(UnitVariables variables) {
		return left.get(variables) * right.get(variables);
	}
}
