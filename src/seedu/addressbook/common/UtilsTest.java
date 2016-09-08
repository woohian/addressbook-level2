package seedu.addressbook.common;

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
import seedu.addressbook.data.person.*;

public class UtilsTest {
	
	@ Test
	public void testAnyNull(){
		assertFalse(Utils.isAnyNull(Name.EXAMPLE, Address.EXAMPLE, Phone.EXAMPLE, Email.EXAMPLE));
		assertFalse(Utils.isAnyNull());
		
		assertTrue(Utils.isAnyNull(Name.EXAMPLE, Address.EXAMPLE, Phone.EXAMPLE, Email.EXAMPLE, null));
		assertTrue(Utils.isAnyNull(null, 1, 2));		
	}
	
	public void testIfElementIsUnique(){
		final List<String> list1 = Arrays.asList("test1", "test1");
		final List<String> list2 = Arrays.asList("test1", "test2");
		
		assertFalse(Utils.elementsAreUnique(list1));		
		assertTrue(Utils.elementsAreUnique(list2));		
	}
}
