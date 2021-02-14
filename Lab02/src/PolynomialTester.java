public class PolynomialTester {
    public static void main(String[] args) {

        Polynomial poly1 = new Polynomial();
        Polynomial poly2 = new Polynomial(5.0, 6);

        double[] coff = {3,4,1};
        Polynomial poly3 = new Polynomial(coff);

        double[] coff2 = {2,1};
        Polynomial poly4 = new Polynomial(coff2);
    


        System.out.println(poly3.sum(poly4).toString());
        // System.out.println("The Multiplication of " + poly3.toString() + " and of "+ poly4.toString() + ": " + poly3.mul(poly4).toString());

        System.out.println(poly4.toString() + "  -   "+ poly3.toString() + "  =  " + poly4.sub(poly3).toString());
        System.out.println(poly4.toString() + "  -   "+ poly3.toString() + "  =  " + poly3.compose(poly4).toString());




        



    }
}
