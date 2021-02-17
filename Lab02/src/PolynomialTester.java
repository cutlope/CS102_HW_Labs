public class PolynomialTester {
    public static void main(String[] args) {

        String s = "-----------------------";
        Polynomial poly1 = new Polynomial();
        Polynomial poly2 = new Polynomial(5.0, 6);

        double[] coff = {3,4,1,3,0,2};
        Polynomial poly3 = new Polynomial(coff);

        double[] coff2 = {2,1};
        Polynomial poly4 = new Polynomial(coff2);
    


        System.out.println(poly3.add(poly4).toString());
        System.out.println("The Multiplication of " + poly3.toString() + " and of "+ poly4.toString() + ": " + poly3.mul(poly4).toString());


        System.out.println(poly4.toString() + "  -   "+ poly3.toString() + "  =  " + poly4.sub(poly3).toString());
        System.out.println(poly4.toString() + "  -   "+ poly3.toString() + "  =  " + poly3.compose(poly4).toString());
        System.out.println("The Addition Operation");
        System.out.printf("\t%s" + "\n +" + "\t%s" + "\n" + "\t%s" +"\n\t%s%n",poly3.toString(),poly4.toString(),s,poly3.add(poly4).toString());

        System.out.println("\nThe Subtraction Operation");
        System.out.printf("\t%s" + "\n -" + "\t%s" + "\n" + "\t%s" +"\n\t%s%n",poly3.toString(),poly4.toString(),s,poly3.sub(poly4).toString() );

        System.out.println("\nThe Multiplication Operation");
        System.out.printf("\t%s" + "\n *" + "\t%s" + "\n" + "\t%s" +"\n\t%s%n",poly3.toString(),poly4.toString(),s,poly3.mul(poly4).toString() );
        

        System.out.println("\nThe Composition Operation");
        System.out.println("\n P(Q(x)) = " + poly3.compose(poly4) ); 

        System.out.println("\nThe Division Operation");
        System.out.printf("\t%s" + "\n /" + "\t%s" + "\n" + "\t%s" +"\n\t%s%n",poly3.toString(),poly4.toString(),s,poly3.div(poly4).toString() );
    }
}
