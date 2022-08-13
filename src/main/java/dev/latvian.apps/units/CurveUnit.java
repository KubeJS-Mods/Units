package dev.latvian.apps.units;

public class CurveUnit extends Unit {
	public final Unit horizontalRange;
	public final Unit input;
	public final Easing easing;
	public final double[] nodes;

	public CurveUnit(Easing easing, Unit input, Unit horizontalRange, double[] nodes) {
		this.easing = easing;
		this.horizontalRange = horizontalRange;
		this.input = input;
		this.nodes = nodes;
	}

	@Override
	public double get(UnitVariables context) {
		double maxRange = horizontalRange.get(context);
		double value = Math.min(input.get(context) / maxRange, 1D);

		double sectionSize = 1D / (nodes.length - 1D);

		if (value % sectionSize == 0D || value == 1D) {
			return nodes[(int) (value / sectionSize)];
		}

		double scaled = value * (nodes.length - 1D);
		int prevIndex = (int) scaled;
		int nextIndex = (int) scaled + 1;

		double previousValue = nodes[prevIndex];
		double nextValue = nodes[nextIndex];
		double prevDoubleIndex = prevIndex * sectionSize;
		double nextDoubleIndex = nextIndex * sectionSize;
		double betweenPercentage = (value - prevDoubleIndex) / (nextDoubleIndex - prevDoubleIndex);

		return previousValue - ((previousValue - nextValue) * betweenPercentage);
	}

	public enum Easing {
		LINEAR,
		BEZIER,
		BEZIER_CHAIN,
		CATMULL_ROM
	}
}
