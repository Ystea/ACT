package datastructures;

import java.util.Arrays;
import java.util.Random;

public class Tableau implements DataStructure {

	private int[] tab;

	public Tableau(int size) {
		this.tab = new int[size];
		
		for (int i=0 ; i<size ; i++)
			this.tab[i] = i;
	}

	@Override
	public void alea() {
		Random random = new Random(); 
		int place;
		int tmp;

		for (int i=0; i < this.tab.length; i++){
			place = i+random.nextInt(this.tab.length-i);
			tmp = this.tab[i];
			this.tab[i] = this.tab[place];
			this.tab[place] = tmp;
		}
	}

	@Override
	public boolean recherche(int e) {
		for(int j=0;j<this.tab.length;j++){
			if (this.tab[j] == e) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int minimumSimple() {
		int min = 0;
		for(int j=1;j<this.tab.length;j++){
			if (this.tab[min] > this.tab[j]) {
				min = j;
			}
		}
		return this.tab[min];
	}

	@Override
	public int minimumTri() {
		Arrays.sort(this.tab);
		return this.tab[0];
	}

	@Override
	public void mystere() {
		int indexMin;
		int tmp;

		for ( int i = 0 ; i < this.tab.length; i++){

			indexMin = i;
			for(int j=i+1;j<this.tab.length;j++){
				if (this.tab[indexMin] > this.tab[j]) {
					indexMin = j;
				}
			}	   

			for (int k = indexMin; k < (indexMin  + this.tab.length)/2 ; k++){
				tmp = this.tab[k];
				this.tab[k] = this.tab[this.tab.length + indexMin - k - 1];
				this.tab[this.tab.length + indexMin - k - 1] = tmp;
			}

			for (int p = i; p < (i  + this.tab.length)/2 ; p++){
				tmp = this.tab[p];
				this.tab[p] = this.tab[this.tab.length + i - p - 1];
				this.tab[this.tab.length + i - p - 1] = tmp;
			}
		}
	}

}
