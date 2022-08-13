package dev.latvian.apps.units.operator.op;

import dev.latvian.apps.units.Unit;
import dev.latvian.apps.units.UnitVariables;
import dev.latvian.apps.units.operator.OpUnit;
import dev.latvian.apps.units.token.UnitSymbol;

public class PowOpUnit extends OpUnit {
	public PowOpUnit(Unit left, Unit right) {
		super(UnitSymbol.POW, left, right);
	}

	@Override
	public double get(UnitVariables variables) {
		return Math.pow(left.get(variables), right.get(variables));
	}
}
