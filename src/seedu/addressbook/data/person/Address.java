package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";
    public static final String ADDRESS_FORMAT = ", ";

    public final String value;
    public String[] address;
    public Block block;
    public Street street;
    public Unit unit;
    public PostalCode postalCode;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        if (!isValidAddress(address)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        
        value = address;
        this.address = address.split(", ");
        block = new Block(this.address[0]);
        street = new Street(this.address[1]);
        unit = new Unit(this.address[2]);
        postalCode = new PostalCode(this.address[3]);        
    }
    

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return block.getBlock() + ADDRESS_FORMAT + street.getStreet() + ADDRESS_FORMAT +
        		unit.getUnit() + ADDRESS_FORMAT + postalCode.getPostalCode();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}

class Block{
	private String block;
	
	public Block(String block){
		this.block = block;
	}
	
	public String getBlock(){
		return block;
	}
}

class Street{
	private String street;
	
	public Street(String street){
		this.street = street;
	}
	
	public String getStreet(){
		return street;
	}
}

class Unit{
	private String unit;
	
	public Unit(String unit){
		this.unit = unit;
	}
	
	public String getUnit(){
		return unit;
	}
}

class PostalCode{
	private String postal;
	
	public PostalCode(String postal){
		this.postal = postal;
	}
	
	public String getPostalCode(){
		return postal;
	}
}
