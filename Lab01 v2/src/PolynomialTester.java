/**
 * Testing Polynomial Class
 * @author Abdullah Riaz
 * @version 11.02.2021 
 * Rewritten from scratch as previous one was not neatly formatted and documented
*/ 

public class PolynomialTester{
    public static void main(String[] args) {
        
        //Variables
        Polynomial emptyPoly = new Polynomial();
        Polynomial singlePoly = new Polynomial(6, 2);

        double[] coff= {5,8,3,1};
        Polynomial multiplePoly = new Polynomial(coff);

        //Tests
        System.out.println("getCoefficient test : " + multiplePoly.getCoefficient(2));
        System.out.println("getDegree test : " + multiplePoly.getDegree());
        System.out.println("emptyPoly toString() : " + emptyPoly.toString() );
        System.out.println("singlePoly toString() : " + singlePoly.toString() );
        System.out.println("multiplePoly toString() : " + multiplePoly.toString() );
        System.out.println("Evaluation Test : " + multiplePoly.eval(2) );
        System.out.println("Horner Evaluation Test : " + multiplePoly.eval2(2) );

    }
} 