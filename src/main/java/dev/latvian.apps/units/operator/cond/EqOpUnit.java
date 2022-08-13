package dev.latvian.apps.units.operator.cond;

import dev.latvian.apps.units.Unit;
import dev.latvian.apps.units.UnitVariables;
import dev.latvian.apps.units.token.UnitSymbol;

public class EqOpUnit extends CondOpUnit {
	public EqOpUnit(Unit left, Unit right) {
		super(UnitSymbol.EQ, left, right);
	}

	@Override
	public boolean getBoolean(UnitVariables variables) {
		return left == right || Math.abs(left.get(variables) - right.get(variables)) < 0.00001D;
	}
}
