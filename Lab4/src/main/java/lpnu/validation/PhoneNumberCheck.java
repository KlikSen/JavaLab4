package lpnu.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(ElementType.FIELD)
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = PhoneNumberCheckValidator.class)
public @interface PhoneNumberCheck {

    String message() default "Incorrect phone number";


    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

