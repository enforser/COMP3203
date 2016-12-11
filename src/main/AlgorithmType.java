// ======================================================================================
// FILE: AlgorithmType.java
// CREATION DATE: OCT 22, 2016
// ABOUT: Algorithm Types.
// ======================================================================================

package main;

public enum AlgorithmType
{
	RIGID_COVERAGE,
	SIMPLE_COVERAGE,
	OVERLAP_COVERAGE,
	SPLIT_COVERAGE;
	
	public String toString() {
		switch(this) {
			case RIGID_COVERAGE:
				return "RIGID_COVERAGE";
			case SIMPLE_COVERAGE:
				return "SIMPLE_COVERAGE";
			case OVERLAP_COVERAGE:
				return "OVERLAP_COVERAGE";
			case SPLIT_COVERAGE:
				return "SPLIT_COVERAGE";
		}
		
		return null;
	}
}