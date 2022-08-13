package dev.latvian.apps.units.token;

import dev.latvian.apps.units.TernaryUnit;
import dev.latvian.apps.units.Unit;

public record TernaryUnitToken(UnitToken cond, UnitToken ifTrue, UnitToken ifFalse) implements UnitToken {
	@Override
	public Unit interpret(UnitTokenStream stream) {
		return new TernaryUnit(cond.interpret(stream), ifTrue.interpret(stream), ifFalse.interpret(stream));
	}

	@Override
	public String toString() {
		return "(" + cond + " ? " + ifTrue + " : " + ifFalse + ")";
	}
}
