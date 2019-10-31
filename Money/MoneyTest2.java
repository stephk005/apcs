public class MoneyTest2
{
	public static void main(String [] args)
	{
		Money valueA = new Money();
		Money valueB = new Money(8,50);
		Money valueC = new Money(4,113);
		Money valueD = new Money(2,507);
		Money valueE = new Money(0,691);
		valueA.initialize(6,53);
		Money sum, difference, product, quotient;

		System.out.println("\n\n\nvalueA is " + valueA);
		System.out.println("\nvalueB is " + valueB);
		System.out.println("\nvalueC is " + valueC);
		System.out.println("\nvalueD is " + valueD);
		System.out.println("\nvalueE is " + valueE);

		sum = valueA.add(valueB);
		System.out.println("\n\n" + valueA + " plus " + valueB + " is " + sum);
		sum = valueC.add(valueD);
		System.out.println("\n" + valueC + " plus " + valueD + " is " + sum);

		product = valueC.multiply(3);
		System.out.println("\n\n" + valueC + " times 3 = " + product);
		product = valueC.multiply(10);
		System.out.println("\n" + valueC + " times 10 = " + product);
		product = valueC.multiply(44);
		System.out.println("\n" + valueC + " times 44 = " + product);

		difference = valueD.subtract(valueC);
		System.out.println("\n\n" + valueD + " minus " + valueC + " equals " + difference);
		difference = valueB.subtract(valueE);
		System.out.println("\n" + valueB + " minus " + valueE + " equals " + difference);
		difference = valueE.subtract(valueC);
		System.out.println("\n" + valueE + " minus " + valueC + " equals " + difference);

		quotient = valueC.divide(3);
		System.out.println("\n\n" + valueC + " divided by 3 = " + quotient);
		quotient = valueD.divide(3);
		System.out.println("\n" + valueD + " divided by 3 = " + quotient);
		quotient = valueE.divide(3);
		System.out.println("\n" + valueE + " divided by 3 = " + quotient + "\n\n\n");
	}
}

/*  Expected Output:


C:\Java\Money>java MoneyTest2



valueA is $6.53

valueB is $8.50

valueC is $5.13

valueD is $7.07

valueE is $6.91


$6.53 plus $8.50 is $15.03

$5.13 plus $7.07 is $12.20


$5.13 times 3 = $15.39

$5.13 times 10 = $51.30

$5.13 times 44 = $225.72


$7.07 minus $5.13 equals $1.94

$8.50 minus $6.91 equals $1.59

$6.91 minus $5.13 equals $1.78


$5.13 divided by 3 = $1.71

$7.07 divided by 3 = $2.35

$6.91 divided by 3 = $2.30




C:\Java\Money>

*/
