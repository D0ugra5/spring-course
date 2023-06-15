package med.voll.api.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;


import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@RestControllerAdvice
public class TratadorDeErros {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404() {
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErro400(MethodArgumentNotValidException ex){
        List<FieldError> erros = ex.getFieldErrors();

        return ResponseEntity.badRequest().body(erros.stream().map(DadosErrosValidacoes:: new ).toList());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        String errorMessage = ex.getRootCause().getMessage();

        // Extrair o campo usando expressões regulares
        Pattern pattern = Pattern.compile("'(.*?)'");
        Matcher matcher = pattern.matcher(errorMessage);
        String fieldName = "";
        if (matcher.find()) {
            fieldName = matcher.group(0);
            System.out.println(matcher);
        }

        if (!fieldName.isEmpty()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new DadosErrosValidacoes(fieldName,"Chave duplicada encontrada no campo"));
        }

        return ResponseEntity.badRequest().body("Erro Interno");
    }


    public String extractKeyText(String errorMessage) {
        String keyText = "";
        int keyIndex = errorMessage.indexOf("key");
        if (keyIndex >= 0) {
            int endIndex = errorMessage.indexOf("'", keyIndex + 4);
            if (endIndex >= 0) {
                keyText = errorMessage.substring(keyIndex + 4, endIndex);
            }
        }
        return keyText;
    }
    private record DadosErrosValidacoes(String campo, String mensagem){
        public DadosErrosValidacoes(FieldError err){
            this(err.getField(), err.getDefaultMessage());
        }
        public DadosErrosValidacoes(String campo,String mensagem){
            this.campo = campo;
            this.mensagem = mensagem;
        }

    };


}
