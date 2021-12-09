package lpnu.validation;

import lpnu.entity.User;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import java.util.regex.*;

public class PhoneNumberCheckValidator implements ConstraintValidator<PhoneNumberCheck, String> {

    private static final SpelExpressionParser PARSER = new SpelExpressionParser();

    @Override
    public void initialize(final PhoneNumberCheck constraintAnnotation) {
    }

    @Override
    public boolean isValid(final String string, final ConstraintValidatorContext context) {

        final Pattern p = Pattern.compile("^\\d{10}$");

        final Matcher m = p.matcher(string);

        return m.matches();
    }
}