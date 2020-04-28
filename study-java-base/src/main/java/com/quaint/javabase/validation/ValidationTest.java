package com.quaint.javabase.validation;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * desc:
 * </p>
 *
 * @author quaint
 * @since 28 April 2020
 */
public class ValidationTest {

    public static void main(String[] args) {

        List<List<String>> strTest = new ArrayList<>();
        List<String> test = new ArrayList<>();
        test.add("aaa");
        test.add("");
        test.add("ccc");
        strTest.add(test);
        test.add("ddd");
        strTest.add(test);
        test.add("eee");
        // 这个空值 不会通过
        strTest.add(null);
        strTest.add(test);
        System.out.println(strTest);

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        for (int i = 0; i < strTest.size(); i++) {
            System.out.println("=======");
            Set<ConstraintViolation<List<String>>> validate = validator.validate(strTest.get(i));
            for (ConstraintViolation cv: validate) {
                System.out.println(cv.getPropertyPath().toString());
                System.out.println(cv.getMessage());
            }
        }


    }

}
