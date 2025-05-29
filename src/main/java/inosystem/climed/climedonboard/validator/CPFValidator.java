package inosystem.climed.climedonboard.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class CPFValidator implements ConstraintValidator<CPFValid, String> {
    private static final Pattern CPF_PATTERN = Pattern.compile("\\d{11}"); // Apenas números

    @Override
    public void initialize(CPFValid constraintAnnotation) {
    }

    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext context) {
        if (cpf == null) {
            return false; // CPF não pode ser nulo
        }

        // Remove pontos e traços (exemplo: 777.777.777-77 -> 77777777777)
        cpf = cpf.replaceAll("[^0-9]", "");

        // Se não tiver exatamente 11 dígitos, retorna falso
        if (!CPF_PATTERN.matcher(cpf).matches()) {
            return false;
        }

        return validarCPF(cpf);
    }

    private boolean validarCPF(String cpf) {
        if (cpf.length() != 11) return false;

        // Verifica se todos os dígitos são iguais, o que invalida o CPF
        if (cpf.matches("(\\d)\\1{10}")) return false;

        int soma = 0, peso = 10;
        for (int i = 0; i < 9; i++) {
            soma += (cpf.charAt(i) - '0') * peso--;
        }
        int primeiroDigito = 11 - (soma % 11);
        if (primeiroDigito >= 10) primeiroDigito = 0;

        soma = 0; peso = 11;
        for (int i = 0; i < 10; i++) {
            soma += (cpf.charAt(i) - '0') * peso--;
        }
        int segundoDigito = 11 - (soma % 11);
        if (segundoDigito >= 10) segundoDigito = 0;

        return (cpf.charAt(9) - '0' == primeiroDigito) && (cpf.charAt(10) - '0' == segundoDigito);
    }
}