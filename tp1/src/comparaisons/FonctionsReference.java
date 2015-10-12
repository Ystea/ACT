package comparaisons;

public class FonctionsReference {

    private int[] sizes;

    public FonctionsReference(int[] sizes) {
	this.sizes = sizes;
    }
	
    /**
     * Retourne le tableau de toutes les valeurs de n^pow pour tous
     * les n présents dans this.sizes.
     * @param pow puissance
     * @return tableau des résultats
     */
    public double[] puissance (double pow) {
	double[] values = new double[this.sizes.length];
		
	for (int idx=0 ; idx<this.sizes.length ; idx++)
	    values[idx] = Math.pow(this.sizes[idx], pow);
		
	return values;
    }
    
    /**
     * Retourne le tableau de toutes les valeurs de log(n) pour tous
     * les n présents dans this.sizes.
     * @return tableau des résultats
     */
    public double[] logarithme () {
	double[] values = new double[this.sizes.length];
		
	for (int idx=0 ; idx<this.sizes.length ; idx++)
	    values[idx] = Math.log(this.sizes[idx]);
		
	return values;
    }

/**
     * Retourne le tableau de toutes les valeurs de n*log(n) pour tous
     * les n présents dans this.sizes.
     * @return tableau des résultats
     */
    public double[] nlog() {
	double[] values = new double[this.sizes.length];

	for (int idx = 0; idx < this.sizes.length; idx++) {
	    values[idx] = this.sizes[idx] * Math.log(this.sizes[idx]);
	}
	return values;
    }

/**
     * Retourne le tableau de toutes les valeurs de exp(n) pour tous
     * les n présents dans this.sizes.
     * @return tableau des résultats
     */    
    public double[] exp() {
	double[] values = new double[this.sizes.length];

	for (int idx = 0; idx < this.sizes.length; idx++) {
	    values[idx] = Math.exp(this.sizes[idx]);
	}
	return values;
    }

    /**
     * Retourne le tableau de toutes les valeurs de k^n pour tous
     * les n présents dans this.sizes.
     * @param k 
     * @return tableau des résultats
     */
    public double[] kpuissance(double k) {
	double[] values = new double[this.sizes.length];
		
	for (int idx=0 ; idx<this.sizes.length ; idx++)
	    values[idx] = Math.pow(k, this.sizes[idx]);
		
	return values;
    }

    /**
     * Retourne le tableau de toutes les valeurs de n! pour tous
     * les n présents dans this.sizes.
     * @return tableau des résultats
     */
    public double[] factorielle() {
	double[] values = new double[this.sizes.length];
	int n = 0;
	int res = 1;
	
	for (int idx = 0; idx < this.sizes.length; idx++) {
	    while (sizes[idx] != n++) {
		res = res*n;
	    }
	    values[idx] = res;
	}
	return values;
    }


    /**
     * Retourne le tableau de toutes les valeurs de n^n pour tous
     * les n présents dans this.sizes.
     * @return tableau des résultats
     */
    public double[] npuissance() {
	double[] values = new double[this.sizes.length];
		
	for (int idx=0 ; idx<this.sizes.length ; idx++)
	    values[idx] = Math.pow(this.sizes[idx], this.sizes[idx]);
	return values;
    }
}
