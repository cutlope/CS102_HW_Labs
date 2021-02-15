/**
 * Polynomial Class
 * @author Abdullah Riaz
 * @version 11.02.2021 
 * Rewritten from scratch as previous one was not clean and not completly functional
*/ 


public class Polynomial
{
    // Properties

    double[] coefficient;
    int power;
    
    // Constructors

    /**
     * Default constructor
     */
    public Polynomial() {                   
        coefficient = new double[1]; 
        coefficient[0] = 0.0;
        power = 0;
     }

    /**
     * Single Polynomial Constructor
     * @param c - Double Value which is the coefficient 
     * @param d - integer value which is the degree of the polynomial
     */
    public Polynomial(double c, int d) {    
        coefficient = new double[1];
        coefficient[0] = c;
        power = d;
    }


    /**
     * Multiple Term Polynomial Constructor
     */
    public Polynomial(double[] coff) {
        coefficient = coff;
        power = coff.length;
    }


    // Methods

    /** 
     * Return coefficient of a given degree
     * @param degree 
     * @return the coefficient associated with degree parameter
     */
    public double getCoefficient(int degree) {
        return coefficient[degree];
    }

    /** 
     * Get thes highest degree of non-zero polynomial 
     * @return degree of polynomial
     */
    public int getDegree() {
        return power - 1;           // Reduced by 1 since arrays start from 0
    }

    /** 
     * Returns the string representation of the polynomial
     * @return String
     */
    public String toString() {
        
        String polyStr= "";
        char sign;

        for ( int i = 0; i < coefficient.length; i++) {

        if ( coefficient.length > 1 ) {                     //Checks if multiple terms in the polynomial

            if (coefficient[i] > 0 ) {                      //Checks if value positive or negative to assign correct '+' or '-'

                sign = '+';
            }
            else {
                sign = '-';
            }
            

            if ( i == 0 ) {                                // Checks if its the first term to remove 'x' since x^0 is always 1
                polyStr  = polyStr + coefficient[i] ;
            }

            else if (coefficient[i] == 1 || coefficient[i] == -1) {
                polyStr  = polyStr + " " + sign + " " + 'x' + '^' + i ;
            }

            else {
                polyStr  = polyStr + " " + sign + " " +  coefficient[i] + 'x' + '^' + i ;       
                }

            }


        else {

            if (coefficient[i] == 0.0) {                    //String Formating so unnecassry text is not printed in case its a single term polynomial
                polyStr =  polyStr + 0;
            }
            else 
                 polyStr= polyStr  +  coefficient[i] + 'x' + '^' + power;
        }

    }
        return polyStr;
        
    }


   /** 
     * evaluates the polynomial at x
     * @param x 
     * @return value of polynomial when x
     */
    public double eval(double x) {
        
        double polySum = 0;
        for ( int i = 0; i < coefficient.length; i++) {
            polySum = coefficient[i] + (Math.pow(x, i));
        }

        return polySum;

    } 

    /** 
     * evaluates the polynomial at x using Horner method
     * @param x 
     * @return value of polynomial when x
     */
    public double eval2(double x) {
        
        double polySum = 0;
        for ( int i = coefficient.length - 1; i >= 0; i--) {
            polySum = (x * polySum) + coefficient[i];
        }

        return polySum;

    }
    
    /** 
     * Sums the polynomial on which method is called and the passed polynomial
     * @param p2 - Polynomial which is passed 
     * @return sum of polynomials 
     */
    public Polynomial sum(Polynomial p2) {
        
        Polynomial polySum;
        double[] polyAdd;
        
        polyAdd = new double[ (Math.max(p2.getDegree(), this.getDegree() )) + 1 ];  

        for ( int i = 0; i < coefficient.length; i++) {

            polyAdd[i] = polyAdd[i] + coefficient[i];
        }

        for ( int i = 0; i < p2.getDegree() + 1; i++) {

            polyAdd[i] = polyAdd[i] + p2.getCoefficient(i) ;
        }

        polySum = new Polynomial(polyAdd);
        
        return polySum;
        
    } 


    /** 
     * Multiplies the polynomial on which method is called and the passed polynomial
     * @param p2 - Polynomial which is passed 
     * @return sum of polynomials 
     */
    public Polynomial mul(Polynomial p2) {
        
        Polynomial polySum;
        double[] polyAdd;
        
        polyAdd = new double[ (p2.getDegree() + this.getDegree() ) + 1 ];  

        for (int i = 0; i < coefficient.length; i++) {
            for (int j = 0; j < p2.getDegree() + 1; j++) {
                polyAdd[i+j] += (coefficient[i] * p2.getCoefficient(j));
            }
        }

        polySum = new Polynomial(polyAdd);
        return polySum;
        
    }


    /** 
     * Multiplies the polynomial on which method is called and the passed polynomial
     * @param p2 - Polynomial which is passed 
     * @return subtracted polynomial
     */
    public Polynomial sub(Polynomial p2) {
        
       Polynomial polySum;
       double[] polyAdd;
        
       polyAdd = new double[ (Math.max(p2.getDegree(), this.getDegree() )) + 1 ];  

       for ( int i = 0; i < coefficient.length; i++) {

           polyAdd[i] = polyAdd[i] + coefficient[i];
       }

       for ( int i = 0; i < p2.getDegree() + 1; i++) {

           polyAdd[i] = polyAdd[i] - p2.getCoefficient(i) ;
       }

       polySum = new Polynomial(polyAdd);
                
       return polySum;
                
    }

    /** 
     * Composes the polynomial on which method is called and the passed polynomial
     * @param p2 - Polynomial which is passed 
     * @return composed polynomial
     */
    public Polynomial compose(Polynomial p2) {
        
        Polynomial polyCompose = new Polynomial();
        
        for (int i = this.getDegree(); i >= 0; i--) {
            Polynomial polyTerm = new Polynomial(coefficient[i], 0);
            polyCompose = polyTerm.sum(p2.mul(polyCompose));
        }
        
        return polyCompose;
    
    }


}
