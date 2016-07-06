package parser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InputFormatterTest {
    String input_seperated_by_single_space;
    String input_seperated_by_multiple_space;
    String[] expectedData;

    @Before
    public void setUp() throws Exception {
        input_seperated_by_single_space = "1 0 0 0 6 4 1 2 1 W";
        input_seperated_by_multiple_space = "1 0    0 0 6    4      1 2 1   W ";
        expectedData = new String[]{"1", "0", "0", "0", "6", "4", "1", "2", "1", "W"};
    }

    @Test
    public void should_format_given_data_when_data_is_seperated_by_single_space_and_return_formatted_data() {
        InputFormatter inputFormatter = new InputFormatter(input_seperated_by_single_space);
        Assert.assertArrayEquals(expectedData, inputFormatter.format());
    }

    @Test
    public void should_format_given_data_when_data_is_seperated_by_multiple_space_and_return_formatted_data() {
        InputFormatter inputFormatter = new InputFormatter(input_seperated_by_multiple_space);
        Assert.assertArrayEquals(expectedData, inputFormatter.format());
    }
}