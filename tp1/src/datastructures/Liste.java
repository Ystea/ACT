package datastructures;

import java.util.ArrayList;
import java.util.Collections;

@SuppressWarnings("serial")
public class Liste extends ArrayList<Integer> implements DataStructure {

	private int size; 

	public Liste(int size) {
		super(size);
		this.size = size;

		for (int i=0 ; i<size ; i++)
			this.add(i);
	}

	@Override
	public void alea() {
		Collections.shuffle(this);
	}

	@Override
	public boolean recherche(int e) {
		return this.contains(e);
	}

	@Override
	public int minimumSimple() {
		return (Integer)Collections.min(this);
	}

	@Override
	public int minimumTri() {
		Collections.sort(this);
		return this.get(0);
	}

	@Override
	public void mystere() {
		Integer min;
		int indexMin;

		for (int i=0 ; i<this.size ; i++){

			min = (Integer)Collections.min(this.subList(i,this.size));
			indexMin = this.indexOf(min);

			Collections.reverse(this.subList(indexMin,this.size));
			Collections.reverse(this.subList(i,this.size));

		} 
	}

}
