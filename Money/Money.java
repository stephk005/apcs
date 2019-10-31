/**
 * Money.java
 * A class to model money, in dollars and
 * cents.  This class contains fields for
 * dollars and cents, and methods that can
 * be used to manipulate these fields:
 * adding, subtracting, multiplying and
 * dividing.
 * @author Scott DeRuiter
 * @version 1.0
 * @since 8/29/2019
 */
public class Money
{
	/** The number of dollars in the money object.  */
	private int myDollars;
	/** The number of cents in the money object.  */
	private int myCents;

	/** Creates a Money object, setting both the
	 *  fields equal to zero.
	 */
	public Money ( )
	{
		initialize(0, 0);
	}

	/** Creates a Money object, setting both the
	 *  fields equal to the values passed in through
	 *  the parameter list.
	 *  @param  newDollars  The number of dollars.
	 *  @param  newCents  The number of cents.
	 */
	public Money(int newDollars, int newCents)
	{
		initialize(newDollars, newCents);
	}

	/** Initializes the money, with the values
	 *  passed in through the parameter list.
	 *  @param  newDollars  The number of dollars.
	 *  @param  newCents  The number of cents.
	 */
	public void initialize(int newDollars, int newCents)
	{
		myDollars = newDollars;
		myCents = newCents;
		normalize();
	}

	/** Adds the Money in the parameter list to
	 *  the Money in the current Money object.
	 *  @param  amount    Money to be added.
	 *  @return  The result of adding the two Money amounts.
	 */
	public Money add(Money amount)
	{
		Money result = new Money();
		result.myCents = myCents + amount.myCents;
		result.myDollars = myDollars + amount.myDollars;
		result.normalize();
		return result;
	}

	public Money subtract(Money amount){
		Money result = new Money();
		result.myCents=myCents-amount.myCents;
		result.myDollars=myDollars-amount.myDollars;
		result.normalize();
		return result;
	}

	public Money multiply(int multiplier){
		Money result=new Money();
		result.myDollars=multiplier*myDollars;
		result.myCents=(multiplier*myCents);
		result.normalize();
		return result;

	}

	public Money divide(int divider){
		Money result = new Money();
		result.myCents=(myCents + (myDollars*100))/divider;
		result.myDollars=0;
		result.normalize();
		return result;
	}

	private void normalize(){
		if(myCents<0){
			myDollars+=(myCents/100-1);
			myCents=myCents%100+100;
		}
		else{
			myDollars+=(myCents/100);
			myCents%=100;
		}
	}

	/** Returns a String that represents the amount of Money.
	 *  @return  A String representing the amount of Money.
	 */
	public String toString ( )
	{
		if(myCents<10){
			return "$" + myDollars + ".0" + myCents;
		}
		return "$" + myDollars + "." + myCents;

	}

	/** Returns the number of dollars in the Money object.
	 *  @return  an int representing the number of dollars.
	 */
	public int getDollars ( )
	{
		return myDollars;
	}

	/** Returns the number of cents in the Money object.
	 *  @return  an int representing the number of cents.
	 */
	public int getCents ( )
	{
		return myCents;
	}
}
