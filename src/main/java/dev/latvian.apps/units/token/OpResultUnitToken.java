package dev.latvian.apps.units.token;

import dev.latvian.apps.units.Unit;

public record OpResultUnitToken(UnitSymbol operator, UnitToken left, UnitToken right) implements UnitToken {
	@Override
	public Unit interpret(UnitTokenStream stream) {
		var uleft = left.interpret(stream);
		var uright = right.interpret(stream);
		return operator.op.create(uleft, uright);
	}

	@Override
	public String toString() {
		return "(" + left + " " + operator + " " + right + ")";
	}
}
